package base;

import driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Jquery {
    private static final int DEFAULT_WAIT_PAGE = 35;

    public Jquery() {
        aguardarJqueryCarregarPágina();
    }

    private  void aguardarJqueryCarregarPágina() {
        new WebDriverWait(DriverManager.getDriver(), DEFAULT_WAIT_PAGE).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("return document.readyState");
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }

}


