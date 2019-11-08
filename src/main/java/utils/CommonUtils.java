package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class CommonUtils {

    private static final Logger LOGGER = LogManager.getLogger();

    private CommonUtils() {

    }

    /**
     * Retorna o valor da propriedade contida no arquivo conf/config.properties
     * @param propriedade uma propriedade existente no arquivo config/config.properties
     * @return o valor da propriedade informada
     */
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
}
