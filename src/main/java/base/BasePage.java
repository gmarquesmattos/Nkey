package base;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static driver.DriverManager.getDriver;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public static final Logger LOGGER = LogManager.getLogger();

    WaitAux waitAux = new WaitAux();
    WebElement elemento;

    public BasePage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        int tempo = 30;
        wait = new WebDriverWait(getDriver(), tempo);
    }

    public void clicar(By by) {
        waitAux.waitJQueryAndLoadPage();
        elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
    }

    public void escrever(By by, String texto) {
        waitAux.waitJQueryAndLoadPage();
        elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.clear();
        elemento.sendKeys(texto);
    }

    public String obterTexto(By by) {

        waitAux.waitJQueryAndLoadPage();
        elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return elemento.getText();
    }

    public String obterTexto(String valor) {

        waitAux.waitJQueryAndLoadPage();
        elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(valor)));
        return elemento.getText();
    }

    public String obterValueElemento(By by) {
        return getDriver().findElement(by).getAttribute("value");
    }


    public void clicarTab(By by) {

        waitAux.waitJQueryAndLoadPage();
        elemento.sendKeys(Keys.TAB);
    }

    public void limparCampo(By by) {

        waitAux.waitJQueryAndLoadPage();
        elemento.clear();

    }


    public void entrar() {

        waitAux.waitJQueryAndLoadPage();
        elemento.sendKeys(Keys.ENTER);
    }

    public boolean verificarSeEstaAtivo(By by) {
        elemento = getDriver().findElement(by);
        return elemento.isEnabled();
    }

    public void compararString(String texto1, String texto2) {
        Assert.assertEquals(texto1, texto2);

    }

    public void esperaAceitarAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getDriver().switchTo().alert();
        alert.accept();

    }
}
