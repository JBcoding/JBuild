package editor;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class EditorProperties {
    private static EditorProperties instance = null;
    private Properties properties;

    private EditorProperties() {
        Properties defaultProps = new Properties();
        try {
            defaultProps.load(getClass().getClassLoader().getResourceAsStream("default.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Properties appProps = new Properties(defaultProps);
        try {
            appProps.load(new FileInputStream(getConfigurationFile()));
        } catch (IOException e) {
            properties = defaultProps;
        }
        properties = appProps;
        System.out.println(properties.getProperty("render_distance"));
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public void set(String key, String value) {
        properties.setProperty(key, value);
        try {
            properties.store(new FileWriter(getConfigurationFile()), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EditorProperties getInstance() {
        if (instance == null) {
            instance = new EditorProperties();
        }
        return instance;
    }

    public boolean save() {
        try {
            properties.store(new FileWriter(getConfigurationFile()), null);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private File getConfigurationFile() {
        File homeDirectory = FileSystemView.getFileSystemView().getHomeDirectory();
        File conf_file = new File(homeDirectory, ".jbuild.properties");
        if (!conf_file.exists()) {
            try {
                conf_file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return conf_file;
    }
}
