package renderer;

import com.jogamp.opengl.GL2;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Road {
    Vector3D startPoint;
    Vector3D endPoint;

    public void draw(GL2 gl, boolean highlighted, boolean debug) {
        if (startPoint == null || endPoint == null) {
            return;
        }

        double roadWidth = 2;

        Vector3D se = startPoint.subtract(endPoint);
        Vector3D widthVector = Util.preMultiplyVector3dMatrix(se, Util.createRotationMatrix(Math.PI / 2, Vector3D.PLUS_J));
        if (widthVector.distance(Vector3D.ZERO) <= 0.0001d) {
            return;
        }
        widthVector = widthVector.normalize();
        widthVector = widthVector.scalarMultiply(roadWidth);

        Vector3D widthVectorLine = widthVector.scalarMultiply(.1);

        double parts = Math.ceil(startPoint.distance(endPoint));
        Vector3D diff = endPoint.subtract(startPoint).scalarMultiply(1.0 / parts);
        for (int i = 0; i < startPoint.distance(endPoint); i++) {
            Vector3D p1 = startPoint.add(diff.scalarMultiply(i));
            Vector3D p2 = startPoint.add(diff.scalarMultiply(i + 1));

            gl.glColor3d(0, 0, 0);
            gl.glBegin(gl.GL_POLYGON);
            gl.glVertex3d(p1.add(widthVector).getX(), 0, p1.add(widthVector).getZ());
            gl.glVertex3d(p1.subtract(widthVector).getX(), 0, p1.subtract(widthVector).getZ());
            gl.glVertex3d(p2.subtract(widthVector).getX(), 0, p2.subtract(widthVector).getZ());
            gl.glVertex3d(p2.add(widthVector).getX(), 0, p2.add(widthVector).getZ());
            gl.glEnd();

            if (i % 2 == 0) {
                gl.glColor3d(1, 1, 1);
                gl.glBegin(gl.GL_POLYGON);
                gl.glVertex3d(p1.add(widthVectorLine).getX(), .05, p1.add(widthVectorLine).getZ());
                gl.glVertex3d(p1.subtract(widthVectorLine).getX(), .05, p1.subtract(widthVectorLine).getZ());
                gl.glVertex3d(p2.subtract(widthVectorLine).getX(), .05, p2.subtract(widthVectorLine).getZ());
                gl.glVertex3d(p2.add(widthVectorLine).getX(), .05, p2.add(widthVectorLine).getZ());
                gl.glEnd();
            }

            if (debug) {
                Util.drawLine(gl, p1.subtract(widthVector), p1.add(widthVector), 1, 1, 1);
            }
        }

        // add rounded ending
        double angle = Math.atan2(se.getZ(), se.getX());
        parts = 10;
        gl.glColor3d(0, 0, 0);
        gl.glBegin(gl.GL_POLYGON);
        for (int i = 0; i <= parts; i++) {
            double localAngle = angle + (double)i / parts * Math.PI - Math.PI / 2;
            Vector3D point = new Vector3D(Math.cos(localAngle), 0, Math.sin(localAngle));
            point = point.scalarMultiply(roadWidth);
            point = point.add(startPoint);
            gl.glVertex3d(point.getX(), point.getY(), point.getZ());
        }
        gl.glEnd();
        gl.glBegin(gl.GL_POLYGON);
        for (int i = 0; i <= parts; i++) {
            double localAngle = angle + (double)i / parts * Math.PI + Math.PI / 2;
            Vector3D point = new Vector3D(Math.cos(localAngle), 0, Math.sin(localAngle));
            point = point.scalarMultiply(roadWidth);
            point = point.add(endPoint);
            gl.glVertex3d(point.getX(), point.getY(), point.getZ());
        }
        gl.glEnd();

        if (debug) {
            Util.drawLine(gl, startPoint.add(widthVector), startPoint.subtract(widthVector), 1, 1, 1);
            Util.drawLine(gl, startPoint.subtract(widthVector), endPoint.subtract(widthVector), 1, 1, 1);
            Util.drawLine(gl, endPoint.subtract(widthVector), endPoint.add(widthVector), 1, 1, 1);
            Util.drawLine(gl, endPoint.add(widthVector), startPoint.add(widthVector), 1, 1, 1);
        }

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
