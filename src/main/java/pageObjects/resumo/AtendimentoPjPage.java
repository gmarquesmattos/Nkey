package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class AtendimentoPjPage extends BasePage {

    private By botaoIrParaAtendimentoPj = By.id("s_11_1_2_0_Ctrl");
    private By botaoNovoAtendimentoPj = By.id("s_1_1_11_0_Ctrl");
    private By textoDescricaoAtendimentoPj = By.id("1_Description");
    private By tabelaDescricaoAtendimentoPj = By.id("1_s_1_l_Description");
    private By tabelaDescricaoAgencia = By.id("1_s_1_l_Sicredi_Division");
    private By botaoSalvarAtendimentoPj = By.id("s_1_1_24_0_Ctrl");
    private By campoDescricaoPj = By.id("1_Sicredi_Division");
    private By botaoExcluirAtendimentoPj = By.id("s_1_1_5_0_Ctrl");

    public AtendimentoPjPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void criarNovoAtendimento() {
        clicar(botaoNovoAtendimentoPj);
    }

    public void escreverDescricaoAtendimento() {
        clicar(tabelaDescricaoAtendimentoPj);
        escrever(textoDescricaoAtendimentoPj, "Novo Atendimento Automacao PJ");
    }

    public void selecionarAgenciaAtendimento() {
        clicar(tabelaDescricaoAgencia);
        escrever(campoDescricaoPj, "UA FORTALEZA DOS VALOS");
    }

    public void salvarAtendimento() {
        clicar(botaoSalvarAtendimentoPj);
    }

    public String pesquisarAtendimentoPj() {
        return obterTexto(tabelaDescricaoAtendimentoPj);
    }

    public void excluirAtedimentoPj() {
        clicar(botaoExcluirAtendimentoPj);
        esperaAceitarAlert();
    }

    private void acessar() {
        new HomePage(driver).acessarPessoaJuridica();
        new PessoaJuridicaPage(driver);
        clicar(botaoIrParaAtendimentoPj);
    }
}


