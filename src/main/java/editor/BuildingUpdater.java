package editor;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import renderer.Building;

import java.util.HashMap;
import java.util.Map;

public class BuildingUpdater implements BuildingChangedListener {
    BiMap<Building, BuildingInformation> map = HashBiMap.create();
    Project project;


    public void setProject(Project p) {
        this.project = p;
        map = HashBiMap.create();
    }

    public void addHash(Building b, BuildingInformation bi) {
        map.put(b, bi);
    }

    public void clear() {
        map = HashBiMap.create();
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
            bi.setSeed(building.getSeed());
        } else {
            BuildingInformation bi = new BuildingInformation();
            bi.setRotation(building.getRotationAngle());
            bi.setTranslation(building.getTranslation().toArray());
            bi.setFilePath(building.getFilePath());
            bi.setSeed(building.getSeed());
            map.put(building, bi);
            project.getBuildings().add(bi);
        }
    }
}
