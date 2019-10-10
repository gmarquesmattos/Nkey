package base;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitAux {
    private static final int DEFAULT_WAIT_PAGE = 30;
    private static final Logger LOGGER = LogManager.getLogger();

    WaitAux() {

        waitJQueryAndLoadPage();
    }

    public static void waitJQueryAndLoadPage() {
        (new WebDriverWait(DriverManager.getDriver(), 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                String readyState = js.executeScript("return document.readyState").toString();
                System.out.println("Ready State: " + readyState);
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }

}


