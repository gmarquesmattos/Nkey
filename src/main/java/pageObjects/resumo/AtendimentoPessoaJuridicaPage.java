package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class AtendimentoPessoaJuridicaPage extends BasePage {

    private By botaoIrParaAtendimento = By.id("s_11_1_2_0_Ctrl");
    private By botaoNovoAtendimento = By.id("s_1_1_11_0_Ctrl");
    private By textoDescricaoAtendimento = By.id("1_Description");
    private By tabelaDescricaoAtendimento = By.id("1_s_1_l_Description");
    private By tabelaDescricaoAgencia = By.id("1_s_1_l_Sicredi_Division");
    private By botaoPesquisarAtendimento = By.id("s_1_1_10_0_Ctrl");
    private By tabelaDescricaoResponsavel = By.id("1_s_1_l_Owner");
    private By textoDescricaoResponsavel = By.id("1_Owner");
    private By textoAgencia = By.id("s_1_2_35_0_icon");
    private By botaoOk = By.id("s_3_1_80_0_Ctrl");
    private By botaoSalvarAtendimento = By.id("s_1_1_24_0_Ctrl");
    private By tabelaStatus = By.id("1_s_1_l_Status");
    private By textoStatus = By.id("1_Status");

    public AtendimentoPessoaJuridicaPage() {
        acessar();
    }

    public void pesquisarPessoaJuridica(String cnpj) {
        new PessoaJuridicaPage(cnpj).acessarRazaoSocial();
    }

    public void acessarAtendimento(){
        clicar(botaoIrParaAtendimento);
    }

    public void criarNovoAtendimento(){
        clicar(botaoNovoAtendimento);
    }

    public void pesquisarAtendimento(){
        clicar(botaoPesquisarAtendimento);
    }

    public void selecionarResponsavelAtendimento(String responsavel){
        clicar(tabelaDescricaoResponsavel);
        escrever(textoDescricaoResponsavel,responsavel);
        entrar();
    }

    public void escreverDescricaoAtendimento() {
        clicar(tabelaDescricaoAtendimento);
        escrever(textoDescricaoAtendimento, "[TESTE]-Novo Atendimento Automacao PJ");
    }

    public void selecionarAgenciaAtendimento() {
        clicar(tabelaDescricaoAgencia);
        clicar(textoAgencia);
        clicar(botaoOk);
    }

    public void salvarAtendimento() {
        clicar(botaoSalvarAtendimento);
    }

    public String retornarTextoDescricaoAtendimento() {
        return obterTexto(tabelaDescricaoAtendimento);
    }

    public void cancelarAtedimento() {
            clicar(tabelaStatus);
            escrever(textoStatus,"Cancelado");
            salvarAtendimento();

    }

    private void acessar() {
        new HomePage().acessarPessoaJuridica();

    }


}


