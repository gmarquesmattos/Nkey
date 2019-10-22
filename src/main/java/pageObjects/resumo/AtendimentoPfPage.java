package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class AtendimentoPfPage extends BasePage {

    private By botaoIrParaAtendimento = By.id("s_16_1_2_0_Ctrl");
    private By botaoNovoAtendimento = By.id("s_1_1_11_0_Ctrl");
    private By textoDescricaoAtendimento = By.id("1_Description");
    private By botaoSalvarAtendimento = By.id("s_1_1_24_0_Ctrl");
    private By tabelaDescricaoAtendimento = By.id("1_s_1_l_Description");
    private By botaoExcluirAtendimento = By.id("s_1_1_5_0_Ctrl");

    public AtendimentoPfPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void realizarNovoAtendimento() {
        clicar(botaoNovoAtendimento);
     }

    public void escreverDescricaoAtendimento() {
        clicar(tabelaDescricaoAtendimento);
        escrever(textoDescricaoAtendimento, "Novo Atendimento Automacao");
    }

    public void salvarAtendimento() {
        clicar(botaoSalvarAtendimento);
     }

    public void excluirAtendimento() {
        clicar(botaoExcluirAtendimento);
        esperaAceitarAlert();
     }

    public String pesquisarAtendimento() {
        return obterTexto(tabelaDescricaoAtendimento);
    }

    private AtendimentoPfPage acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        String CPF = "03401711970";
        new PessoaFisicaPage(driver, CPF);
        clicar(botaoIrParaAtendimento);
        return this;
    }

}
