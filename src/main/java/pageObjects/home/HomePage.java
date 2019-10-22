package pageObjects.home;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.login.LoginPage;


public class HomePage extends BasePage {

    private By tabelaMeusAtendimentosDeRetaguarda = By.cssSelector("#s_3_1_9_0_mb");
    private By menuLateralPaginaInicial = By.cssSelector("button[title='Primeiro nível da barra de visualização']");
    private By menuLateralPessoaFisica = By.linkText("Pessoa física");
    private By menulateralPessoaJuridica = By.linkText("Pessoa jurídica");
    private By rotuloBemVindo = By.className("Welcome");


    public HomePage(WebDriver driver) {
        super(driver);
        new LoginPage(driver);
    }

    public void selecionarMenuHome() {
        clicar(tabelaMeusAtendimentosDeRetaguarda);
    }

    public HomePage acessarPessoaFisica() {
        obterTexto(rotuloBemVindo);
        clicar(menuLateralPaginaInicial);
        clicar(menuLateralPessoaFisica);
        return  this;
    }

    public void acessarPessoaJuridica(){
        clicar(menuLateralPaginaInicial);
        clicar(menulateralPessoaJuridica);
    }
}
