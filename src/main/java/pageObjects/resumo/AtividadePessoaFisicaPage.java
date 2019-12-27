package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class AtividadePessoaFisicaPage extends BasePage {

    private By botaoIrParaAtividade = By.id("s_13_1_0_0_Ctrl");
    private By botaoNovaAtividade = By.id("s_1_1_15_0_Ctrl");
    private By tabelaDescricaoAtividade = By.id("1_s_1_l_Description");
    private By textoDescricaoAtividade = By.id("1_Description");
    private By tabelaDescricaoAgencia = By.id("1_s_1_l_Sicredi_Division");
    private By textoAgencia = By.id("s_1_2_38_0_icon");
    private By botaoOk = By.id("s_3_1_63_0_Ctrl");
    private By botaoSalvarAtividade = By.id("s_1_1_20_0_Ctrl");
    private By botaoPesquisarAtividade = By.id("s_1_1_14_0_Ctrl");
    private By tabelaDescricaoResponsavel = By.id("1_s_1_l_Primary_Owned_By");
    private By textoDescricaoResponsavel = By.id("1_Primary_Owned_By");
    private By tabelaStatus = By.id("1_s_1_l_Status");
    private By textoStatus = By.id("1_Status");

    public AtividadePessoaFisicaPage() {
            acessar();
    }


    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(cpf).acessarNomeCompleto();
    }

    public void acessarAtividade(){
        clicar(botaoIrParaAtividade);
    }

    public void adicionarNovaAtividade() {
        clicar(botaoNovaAtividade);
    }

    public void escreverDescricaoAtividade() {
        clicar(tabelaDescricaoAtividade);
        escrever(textoDescricaoAtividade, "[TESTE]-Nova Atividade Automacao PF");
    }
    public void selecionarAgenciaAtividade() {
        clicar(tabelaDescricaoAgencia);
        clicar(textoAgencia);
        clicar(botaoOk);
    }
    public void salvarAtividade() {
        clicar(botaoSalvarAtividade);
    }

    public void pesquisarAtividade(){
        clicar(botaoPesquisarAtividade);
    }

    public void selecionarResponsavelAtividade(String responsavel){
        clicar(tabelaDescricaoResponsavel);
        escrever(textoDescricaoResponsavel,responsavel);
        entrar();
    }

    public void cancelarAtividade() {
        clicar(tabelaStatus);
        escrever(textoStatus,"Cancelado");
        salvarAtividade();
    }

    public String retornarTextoDescricaoAtividade() {
        return obterTexto(tabelaDescricaoAtividade);
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();
    }
}
