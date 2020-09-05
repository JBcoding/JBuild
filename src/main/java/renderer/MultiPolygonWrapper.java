package renderer;

import com.jogamp.opengl.GL2;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.MatrixUtils;

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
            for (Vector3D point : polygon.getPoints()) {
                min = new Vector3D(Math.min(min.getX(), point.getX()),Math.min(min.getY(), point.getY()),Math.min(min.getY(), point.getY()));
                max = new Vector3D(Math.max(max.getX(), point.getX()),Math.max(max.getY(), point.getY()),Math.max(max.getY(), point.getY()));
            }
        }

        return min.add(max.subtract(min).scalarMultiply(0.5d));
    }

    public static MultiPolygonWrapper generatePolyCut(ConvexPolygon polygon, Double depth, int startIndex, int sides) {
        List<ConvexPolygon> polys = new ArrayList<>();
        Vector3D min = Vector3D.POSITIVE_INFINITY;
        Vector3D max = Vector3D.NEGATIVE_INFINITY;

        for (Vector3D point : polygon.getPoints()) {
            min = new Vector3D(Math.min(min.getX(), point.getX()),Math.min(min.getY(), point.getY()),Math.min(min.getZ(), point.getZ()));
            max = new Vector3D(Math.max(max.getX(), point.getX()),Math.max(max.getY(), point.getY()),Math.max(max.getZ(), point.getZ()));
        }

        Vector3D center = min.add(max.subtract(min).scalarMultiply(0.5d));

        // Assume at least 3 points
        for (int i = startIndex; i < sides; i++) {
            Vector3D p1 = polygon.getPoints().get(i);
            Vector3D p2 = polygon.getPoints().get((i + 1) % polygon.getPoints().size());
            Vector3D direction1 = center.subtract(p1).normalize().scalarMultiply(depth);
            Vector3D direction2 = center.subtract(p2).normalize().scalarMultiply(depth);
            Vector3D p3 = p2.add(direction2);
            Vector3D p4 = p1.add(direction1);

            ConvexPolygon poly = new ConvexPolygon(polygon, new ArrayList<Vector3D>() {{
                add(p1);
                add(p2);
                add(p3);
                add(p4);
            }});

            Vector3D trans = new Vector3D(
                    Math.min(p1.getX(), Math.min(p2.getX(), Math.min(p3.getX(), p4.getX()))),
                    Math.min(p1.getZ(), Math.min(p2.getZ(), Math.min(p3.getZ(), p4.getZ()))),
                    -Math.min(p1.getY(), Math.min(p2.getY(), Math.min(p3.getY(), p4.getY())))
                    );

            poly.setTranslation(poly.getTranslation().add(trans));
            polys.add(poly);
        }

        MultiPolygonWrapper shape = new MultiPolygonWrapper();
        shape.setSimplePolygons(polys);
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
        for (ConvexPolygon polygon :
                simplePolygons) {
            polygon.draw(gl, false, debug, polygon.getTranslation().add(position));
        }
    }

    @Override
    public List<Shape> extrude(double distance) {
        List<Shape> combined = new ArrayList<>();
        for (ConvexPolygon polygon : simplePolygons) {
            combined.addAll(polygon.extrude(distance));
        }
        // TODO: Collect all top and bottom pieces into two non-convex polys
        return combined;
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
        Vector3D center = getCenter();
        for (ConvexPolygon poly : simplePolygons) {
            poly.rotateAroundPoint(axis, new Vector2D(center.getX(), center.getY()), angle);
        }
    }

    @Override
    public void rotateAroundPoint(Vector3D axis, Vector2D point, double angle) {
        for (ConvexPolygon poly : simplePolygons) {
            poly.rotateAroundPoint(axis, point, angle);
        }
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
}
