package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;

public class DetalhesDaPessoajuridicaPage extends BasePage {
    private By botaoRecomendarPS = By.id("s_2_1_4_0_Ctrl");


    public DetalhesDaPessoajuridicaPage(WebDriver driver){
        super(driver);
        acessar();
    }

    public void pesquisarPessoaJuridica(String cnpj) {
        new PessoaJuridicaPage(driver, cnpj);
    }
    public void clicarBotaoRecomendarPS() {
        clicar(botaoRecomendarPS);
    }

    private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaJuridica();
    }
}
