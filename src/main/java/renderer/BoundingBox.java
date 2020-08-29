package renderer;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class BoundingBox {
    private Vector3D min, max;

    public BoundingBox(Vector3D min, Vector3D max) {
        this.min = min;
        this.max = max;
    }

    public Vector3D getMin() {
        return min;
    }

    public void setMin(Vector3D min) {
        this.min = min;
    }

    public Vector3D getMax() {
        return max;
    }

    public void setMax(Vector3D max) {
        this.max = max;
    }
}
