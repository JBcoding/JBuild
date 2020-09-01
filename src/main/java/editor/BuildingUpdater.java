package editor;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import renderer.Building;
import renderer.Road;

public class BuildingUpdater implements BuildingChangedListener, RoadChangedListener {
    private BiMap<Building, BuildingInformation> map = HashBiMap.create();
    private BiMap<Road, RoadInformation> roadmap = HashBiMap.create();
    Project project;


    public void setProject(Project p) {
        this.project = p;
        map = HashBiMap.create();
        roadmap = HashBiMap.create();
    }

    public void removeBuilding(Building b) {
        map.remove(b);
    }

    public BuildingInformation getBuildingInformation(Building b) {
        return map.get(b);
    }

    public Building getBuilding(BuildingInformation bi) {
        return map.inverse().get(bi);
    }

    public void addBuildingHash(Building b, BuildingInformation bi) {
        map.put(b, bi);
    }
    public void addRoadHash(Road r, RoadInformation ri) {
        roadmap.put(r, ri);
    }

    public void clear() {
        map = HashBiMap.create();
        roadmap = HashBiMap.create();
    }

    @Override
    public void buildingChanged(Building building, BuildingChangeType type) {
        if (project == null) return;

        if (type == BuildingChangeType.MOVED) {
            updateBuilding(building);
        } else if (type == BuildingChangeType.DELETED) {
            deleteBuilding(building);
        }

        save();
    }

    private void deleteBuilding(Building building) {
        BuildingInformation bi = map.get(building);
        if (bi != null) {
            map.remove(building);
            project.getBuildings().remove(bi);
        }
    }

    private void save() {
        try {
            project.saveToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBuilding(Building building) {
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

    @Override
    public void roadChanged(Road road, RoadChangeType type) {
        if (type == RoadChangeType.ADD) {
            RoadInformation ri = RoadInformation.fromRoad(road);
            project.getRoads().add(ri);
            roadmap.put(road, ri);
            save();
        } else if (type == RoadChangeType.REMOVE) {
            RoadInformation ri = roadmap.get(road);
            if (ri != null) {
                roadmap.remove(road);
                project.getRoads().remove(ri);
                save();
            }
        }
    }
}
