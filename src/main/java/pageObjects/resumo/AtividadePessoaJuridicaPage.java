package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class AtividadePessoaJuridicaPage extends BasePage {

    private By botaoIrParaAtividade =By.cssSelector("button[title='Atividades:Ir para']");
    private By botaoCriarAtividade =By.cssSelector("button[title='Atividades:Novo']");
    private By tabelaDescricaoAtividade =By.id("1_s_1_l_Description");
    private By textoDescricaoAtividade =By.id("1_Description");
    private By tabelaDescricaoAgencia=By.id("1_s_1_l_Sicredi_Division");
    private By botaoPicListAgencia =By.id("s_1_2_38_0_icon");
    private By botaoOkAgencia =By.cssSelector("button[title='Agência:OK']");
    private By botaoSalvarAtividade =By.cssSelector("button[title='Atividades:Salvar']");
    private By botaoPesquisarAtividade = By.id("s_1_1_14_0_Ctrl");
    private By tabelaDescricaoResponsavel = By.id("1_s_1_l_Primary_Owned_By");
    private By textoDescricaoResponsavel = By.id("1_Primary_Owned_By");
    private By tabelaStatus = By.id("1_s_1_l_Status");
    private By textoStatus = By.id("1_Status");


    public AtividadePessoaJuridicaPage(){
        acessar();
    }

    public void pesquisarPessoaJuridica(String cnpj) {
        new PessoaJuridicaPage(cnpj).acessarRazaoSocial();
    }

    public void acessarAtividade(){
        clicar(botaoIrParaAtividade);
    }

    public void criarAtividade(){
        clicar(botaoCriarAtividade);

    }

    public void escreverAtividade() {
       clicar(tabelaDescricaoAtividade);
       escrever(textoDescricaoAtividade,"[TESTE]-Nova Atividade Automacao PJ");

    }

    public void selecionarAgenciaAtividade(){
        clicar(tabelaDescricaoAgencia);
        clicar(botaoPicListAgencia);
        clicar(botaoOkAgencia);
    }

    public void salvarAtividade(){
        clicar(botaoSalvarAtividade);
    }

    public String retornarTextoDescricaoAtividade() {
        return obterTexto(tabelaDescricaoAtividade);
    }

    public void pesquisarAtividade(){
        clicar(botaoPesquisarAtividade);
    }

    public void selecionarResponsavelAtividade(String responsavel){
        clicar(tabelaDescricaoResponsavel);
        escrever(textoDescricaoResponsavel,responsavel);
        entrar();
    }

    public void cancelarAtividade(){
        clicar(tabelaStatus);
        escrever(textoStatus,"Cancelado");
        salvarAtividade();
    }

    private void acessar() {
        new HomePage().acessarPessoaJuridica();
    }


}
