package pageObjects.home;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AbstractPageObject;
import utils.CommonUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class HomePO extends AbstractPageObject {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait wait2s;

    @FindBy(id = "s_10_1_9_0")
    WebElement locatorMenuRetaguarda;
    WebElement locatorBotaoSalvar;

   public HomePO() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Integer.parseInt(CommonUtils.retornarValorArquivoConfiguracao("timeout")));
    }

    public String getTituloHomePage() {
        reportPrintPass("Buscou titulo da Home Page com sucesso.");
        return driver.getTitle();
    }

    public void  selecionarMenuHome() {
        locatorMenuRetaguarda.click();
    }




    public boolean validaUrl(String url) {
        reportPrintPass("URL: "+url);
        return wait.until(urlToBe(url));
    }


}
