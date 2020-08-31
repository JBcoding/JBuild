package renderer;

import com.jogamp.opengl.GL2;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Road {
    Vector3D startPoint;
    Vector3D endPoint;

    public void draw(GL2 gl, boolean highlighted, boolean debug) {
        Vector3D se = startPoint.subtract(endPoint);
        Vector3D widthVector = Util.preMultiplyVector3dMatrix(se, Util.createRotationMatrix(Math.PI / 2, Vector3D.PLUS_J));
        if (widthVector.distance(Vector3D.ZERO) <= 0.0001d) {
            return;
        }
        widthVector = widthVector.normalize();
        widthVector = widthVector.scalarMultiply(2);

        gl.glColor3d(0, 0,0);
        gl.glBegin(gl.GL_POLYGON);
        gl.glVertex3d(startPoint.add(widthVector).getX(), 0, startPoint.add(widthVector).getZ());
        gl.glVertex3d(startPoint.subtract(widthVector).getX(), 0, startPoint.subtract(widthVector).getZ());
        gl.glVertex3d(endPoint.subtract(widthVector).getX(), 0, endPoint.subtract(widthVector).getZ());
        gl.glVertex3d(endPoint.add(widthVector).getX(), 0, endPoint.add(widthVector).getZ());
        gl.glEnd();
    }

    public static Vector3D snapStartPoint(Vector3D point) {
        return new Vector3D(Math.round(point.getX()), 0, Math.round(point.getZ()));
    }

    public static Vector3D snapEndPoint(Vector3D startPoint, Vector3D endPoint, boolean precise) {
        if (precise) {
            return snapStartPoint(endPoint);
        }

        Vector3D deltaVector = startPoint.subtract(endPoint);
        double angle = Math.atan2(deltaVector.getZ(), deltaVector.getX());

        angle /= Math.PI;
        angle *= 4;
        angle = Math.round(angle);
        angle /= 4;
        angle *= Math.PI;

        angle += Math.PI;

        double length = startPoint.distance(endPoint);
        if (Math.abs((angle+.00001) % (Math.PI / 2)) < 0.001d) {
            length = Math.round(length);
        } else if (Math.abs((angle+.00001) % (Math.PI / 4)) < 0.001d) {
            length = Math.round(length / Math.sqrt(2)) * Math.sqrt(2);
        }

        return startPoint.add(new Vector3D(Math.cos(angle), 0, Math.sin(angle)).scalarMultiply(length));
    }

    public Vector3D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Vector3D startPoint) {
        this.startPoint = startPoint;
    }

    public Vector3D getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Vector3D endPoint) {
        this.endPoint = endPoint;
    }
}
