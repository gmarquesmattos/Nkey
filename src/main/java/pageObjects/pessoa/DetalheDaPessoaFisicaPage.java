package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;

public class DetalheDaPessoaFisicaPage extends BasePage {
    private By botaoRecomendarPS = By.cssSelector("button[title='Detalhes do contato:Recomendar P&S']");
    private By janelaErroRecomendar = By.cssSelector("#_sweview_popup");
    public DetalheDaPessoaFisicaPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(driver, cpf);
    }
    public void clicarBotaoRecomendarPS() {
        clicar(botaoRecomendarPS);
    }

    public String mensagemBotaoRecomendar() {

        return obterTexto(janelaErroRecomendar);
    }

    private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
    }
}

