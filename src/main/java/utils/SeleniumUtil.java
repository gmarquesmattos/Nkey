package utils;

import base.WaitAux;
import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {

    public static void clicar(WebElement elemento) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
        WaitAux.waitJQueryAndLoadPage();
        wait.until(ExpectedConditions.visibilityOf(elemento));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));

        elemento.click();
    }

    public static void esperaAlert() throws InterruptedException {
        int i = 0;
        while (i++ < 5) {
            try {
                Alert alert = DriverManager.getDriver().switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(1000);
                continue;
            }
        }
    }

}
