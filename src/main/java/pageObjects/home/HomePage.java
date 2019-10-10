package pageObjects.home;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.login.LoginPage;

public class HomePage extends BasePage {


    private By tabelaMeusAtendimentosDeRetaguarda = By.id("s_10_1_9_0");
    private By menuLateralPaginaInicial = By.xpath("//button[@class='siebui-nav-hb-btn siebui-display']");
    private By menuLateralPessoaFisica = By.id("ui-id-99");
    private By menulateralPessoaJuridica = By.id("ui-id-100");


    public HomePage(WebDriver driver) {

        super(driver);
        new LoginPage(driver);
    }

    public void selecionarMenuHome() {

        clicar(tabelaMeusAtendimentosDeRetaguarda);
    }

    public HomePage acessarPessoaFisica() {

        clicar(menuLateralPaginaInicial);
        clicar(menuLateralPessoaFisica);
        return  this;
    }

    public HomePage acessarPessoaJuridica(){

        clicar(menuLateralPaginaInicial);
        clicar(menulateralPessoaJuridica);
        return this;
    }

}
