package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class AtividadePfPage extends BasePage {

    private By botaoIrParaAtividade = By.id("s_13_1_0_0_Ctrl");
    private By botaoNovaAtividade = By.id("s_1_1_15_0_Ctrl");
    private By tabelaDescricaoAtividade = By.id("1_s_1_l_Description");
    private By textoDescricaoAtividade = By.id("1_Description");
    private By botaoSalvarAtividade = By.id("s_1_1_20_0_Ctrl");
    private By BotaoExcluirAtividade = By.id("s_1_1_4_0_Ctrl");

    public AtividadePfPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void adicionarNovaAtividade() {
        clicar(botaoNovaAtividade);
    }

    public void escreverDescricaoAtividade() {
        clicar(tabelaDescricaoAtividade);
        escrever(textoDescricaoAtividade, "Nova Atividade Automacao");
    }

    public void salvarAtividade() {
        clicar(botaoSalvarAtividade);
    }

    public void excluirAtividade() {
        clicar(BotaoExcluirAtividade);
        esperaAceitarAlert();
    }

    public String pesquisarAtividade() {
        return obterTexto(tabelaDescricaoAtividade);
    }

    private AtividadePfPage acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        String CPF = "03401711970";
        new PessoaFisicaPage(driver,CPF);
        clicar(botaoIrParaAtividade);
        return this;
    }
}
