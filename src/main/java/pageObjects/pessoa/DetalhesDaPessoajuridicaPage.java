package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;

public class DetalhesDaPessoajuridicaPage extends BasePage {
    private By botaoRecomendarPS = By.id("s_2_1_4_0_Ctrl");


    public DetalhesDaPessoajuridicaPage(){
           acessar();
    }

    public void pesquisarPessoaJuridica(String cnpj) {
        new PessoaJuridicaPage(cnpj);
    }
    public void clicarBotaoRecomendarPS() {
        clicar(botaoRecomendarPS);
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaJuridica();
    }
}
