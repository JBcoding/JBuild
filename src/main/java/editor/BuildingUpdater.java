package editor;

import renderer.Building;

import java.util.HashMap;
import java.util.Map;

public class BuildingUpdater implements BuildingChangedListener {
    Map<Building, BuildingInformation> map = new HashMap<>();
    Project project;


    public void setProject(Project p) {
        this.project = p;
        map = new HashMap<>();
    }

    public void addHash(Building b, BuildingInformation bi) {
        map.put(b, bi);
    }

    public void clear() {
        map = new HashMap<>();
    }

    @Override
    public void buildingChanged(Building building, BuildingChangeType type) {
        if (project == null) return;

        if (type == BuildingChangeType.MOVED) {
            updateBuiliding(building);
        } else if (type == BuildingChangeType.DELETED) {
            deleteBuilding(building);
        }

        try {
            project.saveToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteBuilding(Building building) {
        BuildingInformation bi = map.get(building);
        if (bi != null) {
            map.remove(building);
            project.getBuildings().remove(bi);
        }
    }

    private void updateBuiliding(Building building) {
        if (map.containsKey(building)) {
            BuildingInformation bi = map.get(building);
            bi.setRotation(building.getRotationAngle());
            bi.setTranslation(building.getTranslation().toArray());
        } else {
            BuildingInformation bi = new BuildingInformation();
            bi.setRotation(building.getRotationAngle());
            bi.setTranslation(building.getTranslation().toArray());
            bi.setFilePath(building.getFilePath());
            map.put(building, bi);
            project.getBuildings().add(bi);
        }
    }
}
