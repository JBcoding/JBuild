package renderer;

import com.jogamp.opengl.GL2;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPolygonWrapper extends Shape {
    List<ConvexPolygon> simplePolygons;

    public MultiPolygonWrapper() {
        this.simplePolygons = new ArrayList<>();
        this.rotation = MatrixUtils.createRealDiagonalMatrix(new double[]{1, 1, 1});
        this.translation = Vector3D.ZERO;
    }

    protected Vector3D getCenter() {
        Vector3D min = Vector3D.POSITIVE_INFINITY;
        Vector3D max = Vector3D.NEGATIVE_INFINITY;

        for (ConvexPolygon polygon : simplePolygons) {
            for (Vector3D point2d : polygon.getPoints()) {
                Vector3D point = polygon.getRealPoint(point2d);
                min = new Vector3D(Math.min(min.getX(), point.getX()),Math.min(min.getY(), point.getY()),Math.min(min.getY(), point.getY()));
                max = new Vector3D(Math.max(max.getX(), point.getX()),Math.max(max.getY(), point.getY()),Math.max(max.getY(), point.getY()));
            }
        }

        return min.add(max.subtract(min).scalarMultiply(0.5d));
    }

    public static MultiPolygonWrapper generatePolyCut(ConvexPolygon polygon, Double depth, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            endIndex += polygon.getPoints().size();
        }
        boolean completeCycle = endIndex % polygon.getPoints().size() == startIndex % polygon.getPoints().size();
        List<ConvexPolygon> polys = new ArrayList<>();
        Vector3D min = Vector3D.POSITIVE_INFINITY;
        Vector3D max = Vector3D.NEGATIVE_INFINITY;

        for (Vector3D point : polygon.getPoints()) {
            min = new Vector3D(Math.min(min.getX(), point.getX()),Math.min(min.getY(), point.getY()),Math.min(min.getZ(), point.getZ()));
            max = new Vector3D(Math.max(max.getX(), point.getX()),Math.max(max.getY(), point.getY()),Math.max(max.getZ(), point.getZ()));
        }

        Vector3D center = min.add(max).scalarMultiply(.5);

        // Assume at least 3 points
        for (int i = startIndex; i < endIndex; i++) {
            Vector3D p1 = polygon.getPoints().get(i % polygon.getPoints().size());
            Vector3D p2 = polygon.getPoints().get((i + 1) % polygon.getPoints().size());
            Vector3D pPrev = polygon.getPoints().get((i - 1 + polygon.getPoints().size()) % polygon.getPoints().size());
            Vector3D pNext = polygon.getPoints().get((i + 2) % polygon.getPoints().size());

            if (i == startIndex && !completeCycle) {
                pPrev = p1.add(p1.subtract(p2));
            }
            if (i == endIndex - 1 && !completeCycle) {
                pNext = p2.add(p2.subtract(p1));
            }

            double angleP1P2 = Math.atan2(p1.subtract(p2).getY(), p1.subtract(p2).getX());
            double angleP1PPrev = Math.atan2(p1.subtract(pPrev).getY(), p1.subtract(pPrev).getX());
            double angleP2P1 = angleP1P2 + Math.PI;
            double angleP2PNext = Math.atan2(p2.subtract(pNext).getY(), p2.subtract(pNext).getX());
            double angleMiddleP1 = (angleP1P2 + angleP1PPrev) / 2;
            double angleMiddleP2 = (angleP2P1 + angleP2PNext) / 2;

            Vector3D offsetP1 = new Vector3D(Math.cos(angleMiddleP1), Math.sin(angleMiddleP1), 0);
            Vector3D offsetP2 = new Vector3D(Math.cos(angleMiddleP2), Math.sin(angleMiddleP2), 0);

            Vector3D centerP1;
            Vector3D centerP2;

            if (p1.add(offsetP1).distance(center) > p1.subtract(offsetP1).distance(center)) {
                centerP1 = p1.subtract(offsetP1);
            } else {
                centerP1 = p1.add(offsetP1);
            }

            if (p2.add(offsetP2).distance(center) > p2.subtract(offsetP2).distance(center)) {
                centerP2 = p2.subtract(offsetP2);
            } else {
                centerP2 = p2.add(offsetP2);
            }

            Vector3D direction1 = centerP1.subtract(p1).normalize().scalarMultiply(depth);
            Vector3D direction2 = centerP2.subtract(p2).normalize().scalarMultiply(depth);

            double angleD1 = Math.atan2(direction1.getY(), direction1.getX());
            double angleD2 = Math.atan2(direction2.getY(), direction2.getX());

            double angleP1P2Ce = angleP1P2 - angleD1;
            double angleP2P1Ce = angleP2P1 - angleD2;

            double depthFactorD1 = 1 / Math.abs(Math.sin(angleP1P2Ce));
            double depthFactorD2 = 1 / Math.abs(Math.sin(angleP2P1Ce));

            direction1 = direction1.scalarMultiply(depthFactorD1);
            direction2 = direction2.scalarMultiply(depthFactorD2);

            Vector3D p3 = p2.add(direction2);
            Vector3D p4 = p1.add(direction1);


            List<Vector3D> points = new ArrayList<Vector3D>() {{
                add(p1);
                add(p2);
                add(p3);
                add(p4);
            }};

            // Polygon should now be rotated so that p1 --- p2 is the X-axis

            Vector3D directionVector = p2.subtract(p1);

            // angle is angle between X axis and p2 --- p1
            // points should be rotated -angle around p2
            double angle = Math.atan2(directionVector.getY(), directionVector.getX());
            RealMatrix m = Util.createRotationMatrix(angle, Vector3D.PLUS_K);
            RealMatrix mInverse = Util.createRotationMatrix(-angle, polygon.getNormalVector());

            for (int j = 0; j < points.size(); j++) {
                Vector3D point = points.get(j);
                point = Util.preMultiplyVector3dMatrix(point, m);
                points.set(j, point);
            }

            double minX = points.stream().mapToDouble(Vector3D::getX).min().getAsDouble();
            double minY = points.stream().mapToDouble(Vector3D::getY).min().getAsDouble();


            ConvexPolygon poly = new ConvexPolygon(polygon, points);
            poly.setRotation(poly.getRotation().multiply(mInverse));

            Vector3D currentPosition = poly.getRealPoint(new Vector3D(points.get(0).getX() - minX, points.get(0).getY() - minY, 0));
            Vector3D wantedPosition = polygon.getRealPoint(p1);
            Vector3D offset = wantedPosition.subtract(currentPosition);

            poly.translateGlobal(offset);

            polys.add(poly);
        }

        MultiPolygonWrapper shape = new MultiPolygonWrapper();
        shape.setSimplePolygons(polys);
        shape.setRotation(polygon.getRotation());
        return shape;
    }

    public List<ConvexPolygon> getSimplePolygons() {
        return simplePolygons;
    }

    public void setSimplePolygons(List<ConvexPolygon> simplePolygons) {
        this.simplePolygons = simplePolygons;
    }

    @Override
    public void draw(GL2 gl, boolean highlighted, boolean debug, Vector3D position) {
        for (ConvexPolygon polygon :  simplePolygons) {
            polygon.draw(gl, highlighted, debug, position);
        }
    }

    @Override
    public List<Shape> extrude(double distance) {
        List<Shape> combined = new ArrayList<>();
        for (ConvexPolygon polygon : simplePolygons) {
            combined.addAll(polygon.extrude(distance));
        }

        List<Shape> sides = new ArrayList<>();
        List<ConvexPolygon> tops = new ArrayList<>();
        List<ConvexPolygon> bottoms = new ArrayList<>();

        for (Shape shape : combined) {
            if (shape.getFaceType() == FaceType.TOP) {
                tops.add((ConvexPolygon) shape);
            } else if (shape.getFaceType() == FaceType.BOTTOM) {
                bottoms.add((ConvexPolygon) shape);
            } else {
                sides.add(shape);
            }
        }

        MultiPolygonWrapper top = new MultiPolygonWrapper();
        top.setSimplePolygons(tops);
        top.setFaceType(FaceType.TOP);

        MultiPolygonWrapper bottom = new MultiPolygonWrapper();
        bottom.setSimplePolygons(bottoms);
        bottom.setFaceType(FaceType.BOTTOM);

        return new ArrayList<Shape>() {{
            add(top);
            add(bottom);
            addAll(sides);
        }};
    }

    @Override
    public List<Shape> split(Axis2D axis, UnitLength[] splits, boolean repeat, boolean includePartialSections) {
        List<Shape> combined = new ArrayList<>();
        int splitOffset = 0;
        for (ConvexPolygon polygon : simplePolygons) {
            List<Shape> shapeSplits = polygon.split(axis, splits, repeat, includePartialSections);
            for (Shape s : shapeSplits) {
                s.setSplitIndex(s.getSplitIndex() + splitOffset);
            }
            splitOffset += shapeSplits.size();
            combined.addAll(shapeSplits);
        }
        return combined;
    }

    @Override
    public void rotate(Vector3D axis, double angle) {
        rotateAroundPoint(axis, Vector2D.ZERO, angle);
    }

    @Override
    public void rotateCenter(Vector3D axis, double angle) {
        //double maxX = points.stream().mapToDouble(Vector3D::getX).max().getAsDouble();
        //double maxY = points.stream().mapToDouble(Vector3D::getY).max().getAsDouble();

        //Vector2D centerPoint = new Vector2D(maxX / 2, maxY / 2);

        //rotateAroundPoint(axis, centerPoint, angle);
    }

    @Override
    public void rotateAroundPoint(Vector3D axis, Vector2D point, double angle) {
        rotateAroundPoint(axis, new Vector3D(point.getX(), point.getY(), 0d), angle);
    }

    @Override
    protected void rotateAroundPoint(Vector3D axis, Vector3D point, double angle) {
        Vector3D globalPoint = getRealPoint(new Vector3D(point.getX(), point.getY(), point.getZ()));
        this.rotation = Util.createRotationMatrix(angle, axis).multiply(this.rotation);
        Vector3D newGlobalPoint = getRealPoint(new Vector3D(point.getX(), point.getY(), point.getZ()));
        this.translation = this.translation.add(globalPoint.subtract(newGlobalPoint));
    }

    @Override
    public void scale(Vector2D factors) {
        for (ConvexPolygon poly : simplePolygons) {
            poly.scale(factors);
            poly.setTranslation(new Vector3D(
                    poly.getTranslation().getX() * factors.getX(),
                    poly.getTranslation().getY(),
                    poly.getTranslation().getZ() * factors.getY())
            );
        }
    }

    @Override
    public BoundingBox getBoundingBox() {
        Vector3D min = new Vector3D(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        Vector3D max = new Vector3D(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);

        for (ConvexPolygon poly : simplePolygons) {
            BoundingBox b = poly.getBoundingBox();
            min = new Vector3D(Math.min(min.getX(), b.getMin().getX()), Math.min(min.getY(), b.getMin().getY()), Math.min(min.getZ(), b.getMin().getZ()));
            max = new Vector3D(Math.max(max.getX(), b.getMax().getX()), Math.max(max.getY(), b.getMax().getY()), Math.max(max.getZ(), b.getMax().getZ()));
        }
        return new BoundingBox(min, max);
    }

    @Override
    public void setColor(Color color) {
        for (ConvexPolygon poly : simplePolygons) {
            poly.setColor(color);
        }
    }

    @Override
    public void translate(Vector3D offset) {
        for (ConvexPolygon cp : simplePolygons) {
            Vector3D localOffset = Util.preMultiplyVector3dMatrix(offset, MatrixUtils.inverse(rotation));
            cp.translateGlobal(localOffset);
        }
    }

    @Override
    public void translateGlobal(Vector3D offset) {
        for (ConvexPolygon cp : simplePolygons) {
            cp.translateGlobal(offset);
        }
    }
}
