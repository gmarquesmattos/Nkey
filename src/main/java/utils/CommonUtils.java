package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CommonUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    private CommonUtils() {

    }

    public static String retornarValorArquivoConfiguracao(String propriedade) {
        Properties properties;

        try {
            properties = new Properties();

            String env = null == System.getProperty("env") ? "local" : System.getProperty("env");

            String separadorArquivo = System.getProperty("file.separator");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            Path configPath = Paths.get("conf" + separadorArquivo + env + separadorArquivo + "config.properties");

            properties.load(classloader.getResourceAsStream(configPath.toString()));
            return properties.getProperty(propriedade);
        } catch (IOException | NullPointerException e) {
            LOGGER.error("Propriedade " + propriedade + " não foi encontrada nos arquivos de configuração", e);
        }
        return null;
    }

    public static String getProperty(String propertyName) {
        Properties properties;

        try {
            properties = new Properties();

            String conf = null == System.getProperty("conf") ? "local" : System.getProperty("conf");

            String separadorArquivo = System.getProperty("file.separator");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            Path configPath = Paths.get("conf" + separadorArquivo + conf + separadorArquivo + "config.properties");

            properties.load(classloader.getResourceAsStream(configPath.toString()));

            return properties.getProperty(propertyName);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

        return null;
    }

        public static File getFileFromResources (String fileName){

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            URL resource = classLoader.getResource(fileName);

            if (resource == null) {
                throw new IllegalArgumentException("file is not found!");
            } else {
                return new File(resource.getFile());
            }

        }
    }
