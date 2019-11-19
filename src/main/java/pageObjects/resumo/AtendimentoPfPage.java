package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class AtendimentoPfPage extends BasePage {

    private By botaoIrParaAtendimento = By.id("s_16_1_2_0_Ctrl");
    private By botaoNovoAtendimento = By.id("s_1_1_11_0_Ctrl");
    private By textoDescricaoAtendimento = By.id("1_Description");
    private By tabelaDescricaoAgencia = By.id("1_s_1_l_Sicredi_Division");
    private By textoAgencia = By.id("s_1_2_35_0_icon");
    private By botaoOk = By.id("s_3_1_80_0_Ctrl");
    private By botaoSalvarAtendimento = By.id("s_1_1_24_0_Ctrl");
    private By tabelaDescricaoAtendimento = By.id("1_s_1_l_Description");
    private By botaoPesquisarAtendimento = By.id("s_1_1_10_0_Ctrl");
    private By tabelaDescricaoResponsavel = By.id("1_s_1_l_Owner");
    private By textoDescricaoResponsavel = By.id("1_Owner");
    private By botaoExcluirAtendimento = By.id("s_1_1_5_0_Ctrl");

    public AtendimentoPfPage() {
        acessar();
    }

    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(cpf).acessarNomeCompleto();
    }

    public void acessarAtendimento(){
        clicar(botaoIrParaAtendimento);
    }

    public void realizarNovoAtendimento() {
        clicar(botaoNovoAtendimento);
     }

    public String retornarTextoDescricaoAtendimento() {
        return obterTexto(tabelaDescricaoAtendimento);
    }

    public void pesquisarAtendimento(){
        clicar(botaoPesquisarAtendimento);
    }

    public void selecionarResponsavelAtendimento(){
        clicar(tabelaDescricaoResponsavel);
        escrever(textoDescricaoResponsavel,"KARINE_BONJOUR");
        entrar();
    }

    public void escreverDescricaoAtendimento() {
        clicar(tabelaDescricaoAtendimento);
        escrever(textoDescricaoAtendimento, "[TESTE]-Novo Atendimento Automacao");
    }

    public void selecionarAgenciaAtendimento() {
        clicar(tabelaDescricaoAgencia);
        clicar(textoAgencia);
        clicar(botaoOk);
    }

    public void salvarAtendimento() {
        clicar(botaoSalvarAtendimento);
     }

    public void excluirAtendimento() {
        clicar(botaoExcluirAtendimento);
        esperaAceitarAlert();
     }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();

    }

}
