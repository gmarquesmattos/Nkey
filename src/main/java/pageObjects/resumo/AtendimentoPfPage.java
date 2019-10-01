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

    public AtendimentoPfPage realizarNovoAtendimento() {
        clicar(botaoNovoAtendimento);
        return this;

    }

    public AtendimentoPfPage escreverDescricaoAtendimento() {
        clicar(tabelaDescricaoAtendimento);
        escrever(textoDescricaoAtendimento, "Novo Atendimento Automacao");
        return this;
    }

    public AtendimentoPfPage salvarAtendimento() {
        clicar(botaoSalvarAtendimento);
        return this;
    }

    public String pesquisarAtendimento() {
        return obterTexto(tabelaDescricaoAtendimento);
    }

    public AtendimentoPfPage excluirAtendimento() {
        clicar(botaoExcluirAtendimento);
        esperaAceitarAlert();
        return this;
    }

    private AtendimentoPfPage acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        new PessoaFisicaPage(driver);
        clicar(botaoIrParaAtendimento);
        return this;
    }

}
