package editor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Project {

    private Project() {}

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private List<BuildingInformation> buildings = new ArrayList<>();

    public List<BuildingInformation> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<BuildingInformation> buildings) {
        this.buildings = buildings;
    }

    public void saveToFile() throws Exception {
        JAXBContext ctx = JAXBContext.newInstance(Project.class);

        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        FileWriter writer = new FileWriter(new File(path));
        m.marshal(this, writer);
        writer.close();
    }

    public static Project fromDirectory(File f) throws Exception {
        if (!f.isDirectory()) {
            return null;
        }

        File project_file = new File(f, "jbuild_project.xml");

        if (!project_file.exists()) {
            Project p = new Project();
            p.path = project_file.getAbsolutePath();
            p.saveToFile();
            return p;
        }

        JAXBContext readCtx = JAXBContext.newInstance(Project.class);
        Unmarshaller um = readCtx.createUnmarshaller();
        return (Project) um.unmarshal(project_file);
    }
}
