package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URL;

import static utils.CommonUtils.retornarValorArquivoConfiguracao;

public enum DriverFactory implements IDriverType {


    CHROME {
        @Override
        public MutableCapabilities returnDriver() { return defaultChromeOptions();
        }
    },

    CHROME_HEADLESS {
        @Override
        public MutableCapabilities returnDriver() {
            return ((ChromeOptions) defaultChromeOptions()).addArguments("headless");
        }
    };

    private static final Logger LOGGER = LogManager.getLogger();

    private static MutableCapabilities defaultChromeOptions() {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");
        capabilities.addArguments("lang=pt-BR");
        capabilities.setExperimentalOption("useAutomationExtension", false);
        return capabilities;
    }

    public static WebDriver criarInstancia(String browser) throws Exception {
        WebDriver driver;
        RemoteWebDriver remoteWebDriver;

        switch(retornarValorArquivoConfiguracao("execucao")){

             case "local":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "local-win":
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\win\\chromedriver.exe"); // path of chromedriver
                driver = new ChromeDriver();
                break;

            case "grid":
                String gridURL = retornarValorArquivoConfiguracao("grid.url") + ":" + retornarValorArquivoConfiguracao("grid.port") + "/wd/hub";
                remoteWebDriver = new RemoteWebDriver(new URL(gridURL), defaultChromeOptions());

                driver = remoteWebDriver;
                break;


            default:
                throw new Exception("Browser no encontrado: " +  browser);
        }


        return driver;
    }

    private static MutableCapabilities retornaCapacidade(String browser) {
        return valueOf(browser.toUpperCase()).returnDriver();
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
