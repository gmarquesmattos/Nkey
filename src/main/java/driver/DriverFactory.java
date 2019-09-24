package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.SKIP;
import static utils.CommonUtils.retornarValorArquivoConfiguracao;

public enum DriverFactory implements IDriverType {

    FIREFOX {
        public MutableCapabilities returnDriver() {
            return new FirefoxOptions();
        }
    },

    FIREFOX_HEADLESS {
        public MutableCapabilities returnDriver() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            return firefoxOptions;
        }
    },

    CHROME {
        @Override
        public MutableCapabilities returnDriver() {
            return defaultChromeOptions();
        }
    },

    CHROME_HEADLESS {
        @Override
        public MutableCapabilities returnDriver() {
            return ((ChromeOptions) defaultChromeOptions()).addArguments("headless");
        }
    },

    SAFARI {
        @Override
        public MutableCapabilities returnDriver() {
            return new SafariOptions();
        }
    },

    EDGE {
        @Override
        public MutableCapabilities returnDriver() {
            return new EdgeOptions();
        }
    };


    private static MutableCapabilities defaultChromeOptions() {
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.addArguments("start-maximized");
        capabilities.addArguments("lang=pt-BR");
        capabilities.setExperimentalOption("useAutomationExtension", false);
        return capabilities;
    }


    public static WebDriver criarInstancia(String browser) throws Exception {
        WebDriver driver;

        switch (retornarValorArquivoConfiguracao("execucao")) {

            case "local-mac":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/mac/chromedriver"); // path of chromedriver
                driver = new ChromeDriver();
                break;

            case "local":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "local-win":
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\win\\chromedriver.exe"); // path of chromedriver
                driver = new ChromeDriver();
                break;

            case "test-container":
                driver = getChromeContainer();
                break;

            default:
                throw new Exception("Browser no encontrado: " + browser);
        }

        return driver;
    }

    private static MutableCapabilities retornaCapacidade(String browser) {
        return valueOf(browser.toUpperCase()).returnDriver();
    }

    public static BrowserWebDriverContainer setupSeleniumContainer() {
        BrowserWebDriverContainer chromeContainer = new BrowserWebDriverContainer().withCapabilities(new ChromeOptions())
                .withRecordingMode(SKIP,new File("./target/"));
        chromeContainer.start();
        return chromeContainer;
    }

    private static WebDriver getChromeContainer() {
        return setupSeleniumContainer().getWebDriver();
    }





    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
