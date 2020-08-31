package editor;

import renderer.Road;

public class RoadInformation {
    double[] startPoint;
    double[] endPoint;

    public double[] getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(double[] startPoint) {
        this.startPoint = startPoint;
    }

    public double[] getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(double[] endPoint) {
        this.endPoint = endPoint;
    }

    public static RoadInformation fromRoad(Road r) {
        RoadInformation ri = new RoadInformation();
        ri.startPoint = r.getStartPoint().toArray();
        ri.endPoint = r.getEndPoint().toArray();
        return ri;
    }
}
