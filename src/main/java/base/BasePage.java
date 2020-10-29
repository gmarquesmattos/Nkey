package base;

import com.gargoylesoftware.htmlunit.javascript.host.geo.Coordinates;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class BasePage {
    //String janelaPrincipal = this.SelectPopUp();

    private static final int TEMPO_ESPERA = 70;
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
        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
    }

    public void clicar2(By by) {

        driver.findElement(by).click();

    }

    public void clicarPorTexto(String texto) {
        driver.findElement(By.xpath("//*[@text='" + texto + "']")).click();

    }

    //    public void moverMouse(WebElement by){
//
//     //   WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
//        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated((By) by));
//        Actions actionProvider = new Actions(driver);
//
//
//        // Performs mouse move action onto the element
//        actionProvider.moveToElement(elemento).build().perform(); //moves cursor to point (5,5)
//
//
//    }
    public void escrever(By by, String texto) {
        LOGGER.info("Escreveu em: " + by.toString());

        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        elemento.click();
        elemento.clear();
        elemento.sendKeys(texto);

    }

    public String obterTexto(By by) {

        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        return elemento.getText();

    }

    public String obterTexto2(By by) {

        //  elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getText();

    }

    public String obterTextoPorNome(String texto) {

        return driver.findElement(By.xpath("//*[@text='" + texto + "']")).getText();

    }

    public String obterValorElemento(By by) {
        //aguardarCarregamento();
        AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).getAttribute("value");
    }

    public void selecionarValor(final By elementId, final String value) {
//        WebElement comboboxElement = driver.findElement(elementId);
//        driver.findElement(elementId).click();
//        Select combobox = new Select(comboboxElement);
//        combobox.selectByVisibleText(value);

        elemento = AGUARDAR.until(ExpectedConditions.visibilityOfElementLocated(elementId));

        WebElement comboboxElement = driver.findElement(elementId);
        driver.findElement(elementId).click();
        Select combobox = new Select(comboboxElement);
        combobox.selectByVisibleText(value);

    }

    public void selecionaCmbo(By by, String opcao) {
        driver.findElement(By.id("cdtipoacompanhamento")).click();
        new Select(driver.findElement(By.id("cdtipoacompanhamento"))).selectByVisibleText("RISCO - IMPLEMENTADO");

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
        //aguardarCarregamento();
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

    public void clicarJavaScript(By by) {
        aguardarCarregamento();
        elemento = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", elemento);
    }

    public void acessarFrame() {
        System.out.println("@@@@@@@@@@@" + driver.switchTo().frame("framePrincipal").getTitle());


    }

    public void acessarFrame2() {

        driver.switchTo().frame(0);


    }

    public void acessarJanela() {
        driver.switchTo().window("win_ser_1");


    }

    private void aguardarCarregamento() {
        AGUARDAR.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("return document.readyState");
                return (Boolean) js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
            }
        });
    }


    public String SelectPopUpService() {
        this.sleep(3000);
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String windowId : windows) {
            if (!windowId.equals(mainWindow)) {
                driver.switchTo().window(windowId);
            }
        }
        return mainWindow;
    }

    public String SelectPopUp() {
        this.sleep(5000);
        String janelaPrincipal = driver.getWindowHandle();
        Set<String> janelas = driver.getWindowHandles();
        for (String idJanela : janelas) {
            if (!idJanela.equals(janelaPrincipal)) {
                driver.switchTo().window(idJanela);
            }
        }
        return janelaPrincipal;
    }
    public void SelectPageMain2(final String janelaPrincipal) {

        this.sleep(2500);

        driver.switchTo().window(janelaPrincipal);

    }

    public void SelectPageMain(final String mainWindow) {
        this.sleep(2500);
        //  driver.close();

        driver.switchTo().window(mainWindow);
    }
    private void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String gerarDataAtual(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        String dataAtual = formatter.format(date);
        return dataAtual;
    }


}