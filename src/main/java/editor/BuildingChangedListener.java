package editor;

import renderer.Building;

public interface BuildingChangedListener {
    public void buildingChanged(Building building, BuildingChangeType type);
}
