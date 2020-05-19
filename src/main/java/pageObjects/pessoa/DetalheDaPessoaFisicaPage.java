package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;

public class DetalheDaPessoaFisicaPage extends BasePage {
    private By botaoRecomendarPS = By.cssSelector("button[title='Detalhes do contato:Recomendar P&S']");
    private By janelaErroRecomendar = By.cssSelector("#_sweview_popup");
    public DetalheDaPessoaFisicaPage() {
        acessar();
    }

    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(cpf);
    }
    public void clicarBotaoRecomendarPS() {
        clicar(botaoRecomendarPS);
    }

    public String mensagemBotaoRecomendar() {
        return obterTexto(janelaErroRecomendar);
    }


    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();
    }
}

