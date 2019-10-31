package base;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.windows.WEmbeddedFrame;

import static driver.DriverManager.getDriver;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public static final Logger LOGGER = LogManager.getLogger();
    WaitAux waitAux = new WaitAux();
    WebElement elemento;
    private int tempo_espera = 30;

    public BasePage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        wait = new WebDriverWait(getDriver(), tempo_espera);
    }

    public void clicar(By by) {
        //waitAux.waitJQueryAndLoadPage();
        elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
    }

    public void clicarSemEsperar(By by) {
        new WaitAux();
      WebElement teste = getDriver().findElement(by);
       teste.click();
    }

    public void escrever(By by, String texto) {
        waitAux.waitJQueryAndLoadPage();
        elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
        elemento.clear();
        elemento.sendKeys(texto);

    }

    public String obterTexto(By by) {
        waitAux.waitJQueryAndLoadPage();
        elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return elemento.getText();
    }

    public String obterValueElemento(By by) {
        WaitAux.waitJQueryAndLoadPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
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
        WaitAux.waitJQueryAndLoadPage();
        elemento.sendKeys(Keys.ENTER);
    }

    public boolean verificarSeEstaAtivo(By by) {
        WaitAux.waitJQueryAndLoadPage();
        elemento = getDriver().findElement(by);
        return elemento.isEnabled();
    }

    public void esperaAceitarAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getDriver().switchTo().alert();
        alert.accept();

    }

    public String esperaAceitarRetornarTextoAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getDriver().switchTo().alert();
        String textoAlerta = alert.getText();
        alert.accept();
        return textoAlerta;
    }

}
