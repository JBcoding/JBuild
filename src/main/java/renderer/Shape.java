package renderer;

import com.jogamp.opengl.GL2;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.RealMatrix;

import java.awt.*;
import java.util.List;

public abstract class Shape {
    protected RealMatrix rotation;
    protected Vector3D translation;
    protected FaceType faceType;
    protected int splitIndex = -1;
    protected int faceIndex = -1;
    protected Color color = Color.gray;
    protected boolean partial = false;

    public boolean isPartial() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    public abstract void draw(GL2 gl, boolean highlighted, boolean debug, Vector3D position);

    public abstract List<Shape> extrude(double distance);

    public abstract List<Shape> split(Axis2D axis, UnitLength[] splits, boolean repeat, boolean includePartialSections);

    public abstract void rotate(Vector3D axis, double angle);

    public abstract void rotateCenter(Vector3D axis, double angle);

    public abstract void rotateAroundPoint(Vector3D axis, Vector2D point, double angle);

    public abstract void scale(Vector2D factors);

    public abstract void translate(Vector3D offset);

    public abstract void translateGlobal(Vector3D offset);

    public abstract BoundingBox getBoundingBox();

    public RealMatrix getRotation() {
        return rotation;
    }

    public void setRotation(RealMatrix rotation) {
        this.rotation = rotation;
    }

    public Vector3D getTranslation() {
        return translation;
    }

    public void setTranslation(Vector3D translation) {
        this.translation = translation;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public FaceType getFaceType() {
        return faceType;
    }

    public void setFaceType(FaceType faceType) {
        this.faceType = faceType;
    }

    public int getSplitIndex() {
        return splitIndex;
    }

    public void setSplitIndex(int splitIndex) {
        this.splitIndex = splitIndex;
    }

    public int getFaceIndex() {
        return faceIndex;
    }

    public void setFaceIndex(int faceIndex) {
        this.faceIndex = faceIndex;
    }
}
