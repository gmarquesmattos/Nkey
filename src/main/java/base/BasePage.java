package base;

import driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.PrimitiveIterator;

import static driver.DriverManager.getDriver;

public class BasePage {

    private static final int TEMPO_ESPERA = 35;
    private WebDriverWait AGUARDAR;

    private WebElement elemento;
    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        AGUARDAR = new WebDriverWait(getDriver(), TEMPO_ESPERA);
    }

    public void clicar(By by) {
        new Jquery();
        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
    }

    public void escrever(By by, String texto) {
        new Jquery();
        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
        elemento.clear();
        elemento.sendKeys(texto);

    }

    public String obterTexto(By by) {
        new Jquery();
        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        return elemento.getText();
    }

    public String obterValueElemento(By by) {
        new Jquery();
        AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by).getAttribute("value");
    }

    public void clicarTab(By by) {
        new Jquery();
        elemento.sendKeys(Keys.TAB);
    }

    public void limparCampo(By by) {
        new Jquery();
        elemento.clear();
    }

    public void entrar() {
        new Jquery();
        elemento.sendKeys(Keys.ENTER);
    }

    public boolean verificarSeEstaAtivo(By by) {
        new Jquery();
        elemento = getDriver().findElement(by);
        return elemento.isEnabled();
    }

    public void esperaAceitarAlert() {
        AGUARDAR.until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getDriver().switchTo().alert();
        alert.accept();

    }

    public String esperaAceitarRetornarTextoAlert() {
        AGUARDAR.until(ExpectedConditions.alertIsPresent());
        Alert alert = DriverManager.getDriver().switchTo().alert();
        String textoAlerta = alert.getText();
        alert.accept();
        return textoAlerta;
    }

}
