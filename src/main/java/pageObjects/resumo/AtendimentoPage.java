package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class AtendimentoPage extends BasePage {

    private By linkSaldoContaPrincipal = By.id("s_2_1_32_0");
    private By rotuloContaPrincipal = By.id("s_2_1_12_0");
    private By botaoIrParaAtendimento = By.id("s_16_1_2_0_Ctrl");

    public AtendimentoPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    private AtendimentoPage acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        new PessoaFisicaPage(driver);
        return this;
    }

    public void clicarIrAtendimento() {

        clicar(botaoIrParaAtendimento);
    }
}
