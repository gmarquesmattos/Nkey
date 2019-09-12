package pageObjects.home;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AbstractPageObject;
import utils.CommonUtils;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlToBe;

public class HomePage extends BasePage {


    private By tabelaMeusAtendimentosDeRetaguarda = By.id("s_10_1_9_0");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selecionarMenuHome() {
        clicar(tabelaMeusAtendimentosDeRetaguarda);
    }
}
