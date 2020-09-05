package renderer;

import com.jogamp.opengl.GL2;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.MatrixUtils;

import java.util.*;

public class ConvexPolygon extends Shape {
    List<Vector3D> points;

    private ConvexPolygon(ConvexPolygon parent, final Vector3D... points) {
        this(parent, Arrays.asList(points));
    }

    private ConvexPolygon(ConvexPolygon parent, List<Vector3D> points) {
        this(parent);
        this.points = cleanPoints(points);
    }

    public List<Vector3D> getPoints() {
        return points;
    }

    public void setPoints(List<Vector3D> points) {
        this.points = points;
    }

    private ConvexPolygon(ConvexPolygon parent) {
        this((Shape) parent, parent.points);
    }

    public ConvexPolygon(Shape parent, List<Vector3D> points) {
        this.points = cleanPoints(points);
        this.rotation = parent.rotation.copy();
        this.translation = new Vector3D(parent.translation.toArray());
        this.color = parent.color;
    }

    public ConvexPolygon(List<Vector3D> points) {
        this.points = cleanPoints(points);

        this.rotation = MatrixUtils.createRealDiagonalMatrix(new double[]{1, 1, 1});
        this.translation = Vector3D.ZERO;
    }

    private List<Vector3D> cleanPoints(List<Vector3D> dirtyPoints) {
        double minX = dirtyPoints.stream().mapToDouble(Vector3D::getX).min().getAsDouble();
        double minY = dirtyPoints.stream().mapToDouble(Vector3D::getY).min().getAsDouble();

        List<Vector3D> cleanPoints = new ArrayList<>();
        for (Vector3D point : dirtyPoints) {
            cleanPoints.add(new Vector3D(point.getX() - minX, point.getY() - minY, 0));
        }

        minX = cleanPoints.stream().mapToDouble(Vector3D::getX).min().getAsDouble();

        while (cleanPoints.get(0).getX() > minX) {
            Collections.rotate(cleanPoints, 1);
        }

        return cleanPoints;
    }

    public ConvexPolygon(Vector3D... points) {
       this(Arrays.asList(points));
    }

    private Vector3D getNormalVector() {
        Vector3D deltaP1P2 = getRealPoint(points.get(0)).subtract(getRealPoint(points.get(1)));
        for (int i = 2; i < points.size(); i++) {
            Vector3D deltaP1Pi = getRealPoint(points.get(0)).subtract(getRealPoint(points.get(i)));
            Vector3D normalVector = deltaP1P2.crossProduct(deltaP1Pi);
            if (normalVector.distance(Vector3D.ZERO) < 0.0000001d) {
                continue;
            }
            return normalVector.normalize().negate();
        }
        return null;
    }

    private Vector3D getLightNormalVector(Vector3D position) {
        Vector3D point = getRealPoint(points.get(0));
        Vector3D normalVector = getNormalVector();

        Vector3D ppn = point.add(normalVector);
        Vector3D pnn = point.subtract(normalVector);

        if (ppn.distance(position) < pnn.distance(position)) {
            return normalVector;
        } else {
            return normalVector.scalarMultiply(-1);
        }
    }

    private double getAreaOfTriangle(Vector3D a, Vector3D b, Vector3D c) {
        return Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2);
    }

    public void drawTriangle(GL2 gl, boolean debug, Vector3D p1, Vector3D p2, Vector3D p3, Vector3D lightNormal) {
        gl.glColor3d(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f);

        gl.glBegin(GL2.GL_TRIANGLES);

        gl.glNormal3d(lightNormal.getX(), lightNormal.getY(), lightNormal.getZ());
        gl.glVertex3d(p1.getX(), p1.getY(), p1.getZ());

        gl.glNormal3d(lightNormal.getX(), lightNormal.getY(), lightNormal.getZ());
        gl.glVertex3d(p2.getX(), p2.getY(), p2.getZ());

        gl.glNormal3d(lightNormal.getX(), lightNormal.getY(), lightNormal.getZ());
        gl.glVertex3d(p3.getX(), p3.getY(), p3.getZ());

        gl.glEnd();

        if (debug) {
            renderer.Util.drawLine(gl, p1, p2);
            renderer.Util.drawLine(gl, p2, p3);
            renderer.Util.drawLine(gl, p3, p1);
        }
    }

    public void drawAndSplitTriangles(GL2 gl, boolean debug, Vector3D p1, Vector3D p2, Vector3D p3, Vector3D lightNormal, double maxTriangleSize) {
        if (getAreaOfTriangle(p1, p2, p3) < maxTriangleSize) {
            drawTriangle(gl, debug, getRealPoint(p1), getRealPoint(p2), getRealPoint(p3), lightNormal);
            return;
        }

        Vector3D a, b, c, d;
        double dp1p2 = p1.distance(p2);
        double dp1p3 = p1.distance(p3);
        double dp2p3 = p2.distance(p3);
        if (dp1p2 >= dp1p3 && dp1p2 >= dp2p3) {
            a = p1; b = p2; c = p3;
        } else if (dp1p3 >= dp1p2 && dp1p3 >= dp2p3) {
            a = p3; b = p1; c = p2;
        } else {
            a = p2; b = p3; c = p1;
        }

        d = a.add(b).scalarMultiply(.5);
        drawAndSplitTriangles(gl, debug, a, d, c, lightNormal, maxTriangleSize);
        drawAndSplitTriangles(gl, debug, b, c, d, lightNormal, maxTriangleSize);
    }

    public void drawTriangles(GL2 gl, boolean debug, List<Vector3D> points, Vector3D lightNormal, Vector3D cameraPosition) {
        Vector3D firstPoint = points.get(0);
        Vector3D lastPoint = points.get(1);
        for (int i = 2; i < points.size(); i++) {
            Vector3D point = points.get(i);

            // check if the 3 points are on a line
            if ((firstPoint.subtract(lastPoint)).crossProduct(firstPoint.subtract(point)).distance(Vector3D.ZERO) > 0.0000001d) {
                double distanceToCamera = renderer.Util.smallestDistanceBetweenPointAndTriangle(getRealPoint(firstPoint), getRealPoint(lastPoint), getRealPoint(point), cameraPosition);
                drawAndSplitTriangles(gl, debug, firstPoint, lastPoint, point, lightNormal, Math.max(.05, distanceToCamera / 10));
            }

            lastPoint = point;
        }

    }

    @Override
    public void draw(GL2 gl, boolean highlighted, boolean debug, Vector3D cameraPosition) {
        gl.glColor3d(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f);

        Vector3D lightNormal = getLightNormalVector(cameraPosition);
        drawTriangles(gl, debug && highlighted, points, lightNormal, cameraPosition);

        if (highlighted || debug) {
            for (int i = 0; i < points.size(); i++) {
                Vector3D point1 = points.get(i);
                point1 = getRealPoint(point1);

                Vector3D point2 = points.get((i + 1) % points.size());
                point2 = getRealPoint(point2);

                Util.drawLine(gl, point1, point2);
            }
        }
    }

    @Override
    public List<Shape> extrude(double distance) {
        List<Shape> newFaces = new ArrayList<Shape>();

        ConvexPolygon bottom = new ConvexPolygon(this);
        bottom.faceType = FaceType.BOTTOM;
        newFaces.add(bottom);

        ConvexPolygon top = new ConvexPolygon(this);
        top.faceType = FaceType.TOP;
        top.translation = top.translation.add(getNormalVector().scalarMultiply(distance));
        newFaces.add(top);

        for (int i = 0; i < points.size(); i++) {
            Vector3D from = points.get(i);
            Vector3D to = points.get((i + 1) % points.size());
            double deltaDistance = from.distance(to);

            ConvexPolygon side = new ConvexPolygon(this,
                    new Vector3D(0, 0, 0),
                    new Vector3D(0, distance, 0),
                    new Vector3D(deltaDistance, distance, 0),
                    new Vector3D(deltaDistance, 0, 0)
            );
            side.faceType = FaceType.SIDE;
            side.faceIndex = i;
            side.translation = side.translation.add(getRealPoint(to).subtract(getRealPoint(Vector3D.ZERO)));
            side.rotation = Util.createRotationMatrix(Math.PI / 2, Vector3D.MINUS_I).multiply(side.rotation);
            if (distance < 0) {
                side.translation = side.translation.add(Util.preMultiplyVector3dMatrix(new Vector3D(0, 0, distance), this.rotation));
            }

            double angle = Math.atan2(from.getY() - to.getY(), from.getX() - to.getX());

            side.rotation = Util.createRotationMatrix(-angle, Vector3D.PLUS_J).multiply(side.rotation);

            newFaces.add(side);
        }

        return newFaces;
    }

    @Override
    public List<Shape> split(Axis2D axis, UnitLength[] splits, boolean repeat, boolean includePartialSections) {
        if (axis == Axis2D.Y) {
            // code below is made for splits in x axis, so just swap axis for y
            for (int i = 0; i < points.size(); i++) {
                Vector3D point = points.get(i);
                points.set(i, new Vector3D(-point.getY(), point.getX(), point.getZ()));
            }
            this.points = cleanPoints(points);
        }
        double maxX = points.stream().mapToDouble(Vector3D::getX).max().getAsDouble();
        double maxY = points.stream().mapToDouble(Vector3D::getY).max().getAsDouble();
        List<Double> widths = new ArrayList<>();
        double currentPosition = 0;
        boolean lastPartial = false;
        double remainderSum = 0;
        double remainderPortion = maxX;
        for (UnitLength split : splits) {
            if (split.getUnit() != Unit.REM) {
                remainderPortion -= split.getWidth(maxX, 0, 0);
            } else {
                remainderSum += split.getAmount();
            }
        }


        doWhile: do {
            for (UnitLength split : splits) {
                double width = split.getWidth(maxX, remainderSum, remainderPortion);
                currentPosition += width;
                if (currentPosition > maxX) {
                    if (includePartialSections) {
                        widths.add(currentPosition);
                        lastPartial = true;
                    }
                    break doWhile;
                } else if (Math.abs(currentPosition - maxX) < 0.00001d) { // currentPosition == maxX
                    widths.add(currentPosition);
                    break doWhile;
                } else {
                    widths.add(currentPosition);
                }
            }
        } while (repeat);

        List<Shape> newFaces = new ArrayList<>();

        double currentWidth;
        Set<Vector3D> usedPoints = new HashSet<>();
        List<Vector3D> newPoints;
        List<Vector3D> previousIntersectionPoints = new ArrayList<>();
        for (int j = 0; j < widths.size(); j++) {
            currentWidth = widths.get(j);
            newPoints = new ArrayList<>();
            if (previousIntersectionPoints.size() != 0) {
                newPoints.add(previousIntersectionPoints.get(1));
                newPoints.add(previousIntersectionPoints.get(0));
                previousIntersectionPoints.clear();
            }
            for (int i = 0; i < points.size(); i++) {
                Vector3D from = points.get(i);
                Vector3D to = points.get((i + 1) % points.size());
                if (from.getX() < currentWidth && !usedPoints.contains(from)) {
                    newPoints.add(from);
                    usedPoints.add(from);
                }
                Vector3D intersection = Util.lineLineIntersection(
                        new Vector3D(currentWidth, 0, 0),
                        new Vector3D(currentWidth, maxY, 0),
                        from,
                        to
                );
                if (intersection != null) {
                    newPoints.add(intersection);
                    previousIntersectionPoints.add(intersection);
                }
            }

            double localMinX = newPoints.stream().mapToDouble(Vector3D::getX).min().getAsDouble();
            double localMaxX = newPoints.stream().mapToDouble(Vector3D::getX).max().getAsDouble();
            double localMinY = newPoints.stream().mapToDouble(Vector3D::getY).min().getAsDouble();
            Vector3D offsetVector = new Vector3D(localMinX, localMinY, 0);
            for (int i = 0; i < newPoints.size(); i++) {
                newPoints.set(i, newPoints.get(i).subtract(offsetVector));
            }
            if (axis == Axis2D.Y) {
                // code above is made for splits in x axis, so just swap axis for y
                for (int i = 0; i < newPoints.size(); i++) {
                    Vector3D point = newPoints.get(i);
                    newPoints.set(i, new Vector3D(point.getY(), -point.getX(), point.getZ()));
                }
                offsetVector = new Vector3D(-localMinY, maxX - localMaxX, 0);
            }
            ConvexPolygon newFace = new ConvexPolygon(this, newPoints);
            newFace.splitIndex = j;
            newFace.translation = newFace.translation.add(Util.preMultiplyVector3dMatrix(offsetVector, newFace.rotation));

            if (newFace.points.stream().mapToDouble(Vector3D::getX).max().getAsDouble() < 0.000001 ||
                newFace.points.stream().mapToDouble(Vector3D::getY).max().getAsDouble() < 0.000001) {
                continue;
            }

            newFaces.add(newFace);
        }
        if (lastPartial && newFaces.size() > 0) {
            newFaces.get(newFaces.size() - 1).setPartial(true);
        }
        if (axis == Axis2D.Y) {
            // code above is made for splits in x axis, so just swap axis for y
            for (int i = 0; i < points.size(); i++) {
                Vector3D point = points.get(i);
                points.set(i, new Vector3D(-point.getY(), point.getX(), point.getZ()));
            }
            this.points = cleanPoints(points);
        }
        return newFaces;
    }

    @Override
    public void rotate(Vector3D axis, double angle) {
        rotateAroundPoint(axis, Vector2D.ZERO, angle);
    }

    @Override
    public void rotateCenter(Vector3D axis, double angle) {
        double maxX = points.stream().mapToDouble(Vector3D::getX).max().getAsDouble();
        double maxY = points.stream().mapToDouble(Vector3D::getY).max().getAsDouble();

        Vector2D centerPoint = new Vector2D(maxX / 2, maxY / 2);

        rotateAroundPoint(axis, centerPoint, angle);
    }

    @Override
    public void rotateAroundPoint(Vector3D axis, Vector2D point, double angle) {
        Vector3D globalPoint = getRealPoint(new Vector3D(point.getX(), point.getY(), 0d));
        this.rotation = Util.createRotationMatrix(angle, axis).multiply(this.rotation);
        Vector3D newGlobalPoint = getRealPoint(new Vector3D(point.getX(), point.getY(), 0d));
        this.translation = this.translation.add(globalPoint.subtract(newGlobalPoint));

    }

    @Override
    public void scale(Vector2D factors) {
        for (int i = 0; i < points.size(); i++) {
            Vector3D point = points.get(i);
            double x = point.getX() * factors.getX();
            double y = point.getY() * factors.getY();
            double z = point.getZ();
            points.set(i, new Vector3D(x, y, z));
        }
    }



    @Override
    public BoundingBox getBoundingBox() {
        Vector3D min = getRealPoint(points.get(0));
        Vector3D max = getRealPoint(points.get(0));

        for (int i = 1; i < points.size(); i++) {
            Vector3D p = getRealPoint(points.get(i));
            min = new Vector3D(Math.min(min.getX(), p.getX()), Math.min(min.getY(), p.getY()), Math.min(min.getZ(), p.getZ()));
            max = new Vector3D(Math.max(max.getX(), p.getX()), Math.max(max.getY(), p.getY()), Math.max(max.getZ(), p.getZ()));
        }

        return new BoundingBox(min, max);
    }
}
