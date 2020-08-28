import com.jogamp.opengl.GL2;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Util {
    public static RealMatrix createRotationMatrix(double angle, Vector3D axis) {
        axis = axis.normalize();
        double l = axis.getX(), m = axis.getY(), n = axis.getZ();
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);
        double a, b, c, d, e, f, g, h, i;
        a = l * l * (1 - cosAngle) + cosAngle; b = m * l * (1 - cosAngle) - n * sinAngle; c = n * l * (1 - cosAngle) + m * sinAngle;
        d = l * m * (1 - cosAngle) + n * sinAngle; e = m * m * (1 - cosAngle) + cosAngle; f = n * m * (1 - cosAngle) - l * sinAngle;
        g = l * n * (1 - cosAngle) - m * sinAngle; h = m * n * (1 - cosAngle) + l * sinAngle; i = n * n * (1 - cosAngle) + cosAngle;
        return MatrixUtils.createRealMatrix(new double[][]{{a, b, c}, {d, e, f}, {g, h, i}});
    }

    public static Vector3D preMultiplyVector3dMatrix(Vector3D vector, RealMatrix matrix) {
        return new Vector3D(matrix.preMultiply(new ArrayRealVector(vector.toArray())).toArray());
    }

    public static Vector3D lineLineIntersection(Vector3D a, Vector3D b, Vector3D c, Vector3D d) {

        // Line AB represented as a1x + b1y = c1
        double a1 = b.getY() - a.getY();
        double b1 = a.getX() - b.getX();
        double c1 = a1*(a.getX()) + b1*(a.getY());

        // Line CD represented as a2x + b2y = c2
        double a2 = d.getY() - c.getY();
        double b2 = c.getX() - d.getX();
        double c2 = a2*(c.getX())+ b2*(c.getY());

        double determinant = a1*b2 - a2*b1;

        if (determinant != 0) {
            double x = (b2 * c1 - b1 * c2) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            double epsilon = 0.0000001d;
            if (Math.min(a.getX(), b.getX()) - epsilon <= x && x <= Math.max(a.getX(), b.getX() + epsilon) &&
                Math.min(a.getY(), b.getY()) - epsilon <= y && y <= Math.max(a.getY(), b.getY() + epsilon) &&
                Math.min(c.getX(), d.getX()) - epsilon <= x && x <= Math.max(c.getX(), d.getX() + epsilon) &&
                Math.min(c.getY(), d.getY()) - epsilon <= y && y <= Math.max(c.getY(), d.getY() + epsilon)) {
                return new Vector3D(x, y, 0);
            }
        }
        return null;
    }

    public static void drawLine(GL2 gl, Vector3D p1, Vector3D p2) {
        gl.glColor3d( .8f, .8f, 1);

        gl.glLineWidth(8);

        gl.glBegin(GL2.GL_LINES);

        gl.glVertex3d(p1.getX(), p1.getY(), p1.getZ());

        gl.glVertex3d(p2.getX(), p2.getY(), p2.getZ());

        gl.glEnd();
    }

    public static Vector3D getIntersectionPoint(Vector3D startPoint, Vector3D direction, Vector3D min, Vector3D max, Vector3D p) {
        /*
        plane Equation N_x (x - p1_x) + N_y (y - p1_y) + N_z (z - p1_z) = 0
        Line equation (x, y, z) = (o_x + d_x t, o_y + d_y t, o_z + d_z t), o = startPoint, d = direction
        Substitute line equation into plane equation and solve for t
        t = -(N__x*o__x-N__x*p1__x+N__y*o__y-N__y*p1__y+N__z*o__z-N__z*p1__z)/(N__x*d__x+N__y*d__y+N__z*d__z)
        t = -(N.o - N.p1) / N.d,     . is dot product
        t = -A / B
        If B equals 0, the the line is parallel to the plane
        */
        Vector3D normalVector = (min.subtract(p).crossProduct(max.subtract(p)));
        double B = normalVector.dotProduct(direction);
        if (B == 0) { // Line is parallel to the plane
            return null;
        }
        double A = normalVector.dotProduct(startPoint) - normalVector.dotProduct(min);
        double t = -A / B;
        if (t <= 0) { // The plane is behind the line
            return null;
        }
        return startPoint.add(direction.scalarMultiply(t));
    }

    public static double getIntersectionDistance(Vector3D startPoint, Vector3D direction, Vector3D min, Vector3D max, Vector3D p, Axis3D axisToDiscard) {
        Vector3D planeIntersectionPoint = getIntersectionPoint(startPoint, direction, min, max, p);
        if (planeIntersectionPoint == null) {
            return Double.MAX_VALUE;
        }
        double t = planeIntersectionPoint.distance(startPoint) / direction.distance(Vector3D.ZERO);

        Vector2D min2d, max2d, pip2d;
        switch (axisToDiscard) {
            case X:
                min2d = new Vector2D(min.getY(), min.getZ());
                max2d = new Vector2D(max.getY(), max.getZ());
                pip2d = new Vector2D(planeIntersectionPoint.getY(), planeIntersectionPoint.getZ());
                break;
            case Y:
                min2d = new Vector2D(min.getX(), min.getZ());
                max2d = new Vector2D(max.getX(), max.getZ());
                pip2d = new Vector2D(planeIntersectionPoint.getX(), planeIntersectionPoint.getZ());
                break;
            case Z:
                min2d = new Vector2D(min.getY(), min.getX());
                max2d = new Vector2D(max.getY(), max.getX());
                pip2d = new Vector2D(planeIntersectionPoint.getY(), planeIntersectionPoint.getX());
                break;
            default:
                throw new IllegalStateException("Enum is null");
        }

        if (min2d.getX() <= pip2d.getX() && pip2d.getX() <= max2d.getX() &&
            min2d.getY() <= pip2d.getY() && pip2d.getY() <= max2d.getY()) {
            return t;
        }
        return Double.MAX_VALUE;
    }
}
