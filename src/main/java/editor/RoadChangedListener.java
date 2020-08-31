package editor;

import renderer.Road;

public interface RoadChangedListener {
    public void roadChanged(Road road, RoadChangeType type);
}
