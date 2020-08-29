package editor;

public class BuildingInformation {
    private String filePath;
    double[] translation;
    double rotation;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public double[] getTranslation() {
        return translation;
    }

    public void setTranslation(double[] translation) {
        this.translation = translation;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }
}
