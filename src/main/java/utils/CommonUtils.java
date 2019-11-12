package utils;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CommonUtils {

    private CommonUtils() {

    }

    public static String getProperty(String propertyName) {
        Properties properties;

        try {
            properties = new Properties();

            String env = null == System.getProperty("env") ? "dev" : System.getProperty("env");

            String separadorArquivo = System.getProperty("file.separator");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            Path configPath = Paths.get("env" + separadorArquivo + env + separadorArquivo + "config.properties");

            properties.load(classloader.getResourceAsStream(configPath.toString()));

            return properties.getProperty(propertyName);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Obtém um arquivo do resource
     * @param fileName Caminho do arquivo dentro do resources
     * @return File
     */
    public static File getFileFromResources(String fileName) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
