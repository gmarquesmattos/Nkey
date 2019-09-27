package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class CriarAtendimentoPage extends BasePage {


    private By linkSaldoContaPrincipal = By.id("s_2_1_32_0");
    private By rotuloContaPrincipal = By.id("s_2_1_12_0");

    public CriarAtendimentoPage(WebDriver driver) {
        super(driver);
        acessar();
    }
    private CriarAtendimentoPage acessar(){
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        new PessoaFisicaPage(driver);
        return this;
    }

}
