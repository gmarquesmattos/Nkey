package base;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    private static final int TEMPO_ESPERA = 35;
    private WebDriverWait AGUARDAR;

    private WebElement elemento;
    public WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger();

    public BasePage() {
        driver = DriverManager.getDriver();
        AGUARDAR = new WebDriverWait(driver, TEMPO_ESPERA);
    }

    public void clicar(By by) {
        LOGGER.info("Clicou em: " + by.toString());
        aguardarCarregamento();
        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
    }

    public void escrever(By by, String texto) {
        LOGGER.info("Escreveu em: " + by.toString());
        aguardarCarregamento();
        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
        elemento.clear();
        elemento.sendKeys(texto);

    }

    public String obterTexto(By by) {
        aguardarCarregamento();
        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        return elemento.getText();
    }

    public String obterValorElemento(By by) {
        aguardarCarregamento();
        AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getAttribute("value");
    }

    public void clicarTab() {
        aguardarCarregamento();
        elemento.sendKeys(Keys.TAB);
    }

    public void limparCampo() {
        aguardarCarregamento();
        elemento.clear();
    }

    public void entrar() {
        aguardarCarregamento();
        elemento.sendKeys(Keys.ENTER);
    }

    public boolean verificarSeEstaAtivo(By by) {
        aguardarCarregamento();
        elemento = driver.findElement(by);
        return elemento.isEnabled();
    }

    public String esperaAceitarAlert() {
        AGUARDAR.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String textoAlerta = alert.getText();
        alert.accept();
        return textoAlerta;
    }

    public void clicarJavaScript(By by){
        aguardarCarregamento();
        elemento = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", elemento);
    }

    private void aguardarCarregamento(){
        AGUARDAR.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("return document.readyState");
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }

}
