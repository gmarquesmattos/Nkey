package base;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitAux {
    private static final int DEFAULT_WAIT_PAGE = 30;
    private static final Logger LOGGER = LogManager.getLogger();

    WaitAux() {
        waitJQueryAndLoadPage();
    }

    public static void waitJQueryAndLoadPage() {
        try {
            DriverManager.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_PAGE) {
            }.until((ExpectedCondition<Boolean>) driverObject -> (Boolean) ((JavascriptExecutor) driverObject).executeScript("return jQuery.active == 0"));
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("return jQuery.active == 0");
            DriverManager.getDriver().manage().timeouts().implicitlyWait(DEFAULT_WAIT_PAGE, TimeUnit.SECONDS);
        } catch (Exception e) {
            LOGGER.error("Não foi possível aguardar carregamento");
        }
    }

}


