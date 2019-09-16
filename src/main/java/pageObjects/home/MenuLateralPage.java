package pageObjects.home;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MenuLateralPage extends BasePage {

    public MenuLateralPage(WebDriver driver) {
        super(driver);
    }
    private By menuLateralPaginaInicial = By.xpath("//button[@class='siebui-nav-hb-btn siebui-display']");
    private By menuLateralPessoaFisica = By.id("ui-id-99");

    public MenuLateralPage acessarPessoaFisica() {

        clicar(menuLateralPaginaInicial);
        clicar(menuLateralPessoaFisica);
        return  this;
    }



}
