package pageObjects.home;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    private By tabelaMeusAtendimentosDeRetaguarda = By.id("s_10_1_9_0");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selecionarMenuHome() {
        clicar(tabelaMeusAtendimentosDeRetaguarda);
    }
}
