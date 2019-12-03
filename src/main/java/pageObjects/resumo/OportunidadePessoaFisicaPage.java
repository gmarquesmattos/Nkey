package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class OportunidadePessoaFisicaPage extends BasePage {

    private By botaoIrParaOportunidade = By.id("s_18_1_1_0_Ctrl");
    private By botaoNovaOportunidade = By.id("s_1_1_8_0_Ctrl");
    private By tabelaDescricaoAgencia = By.id("1_s_1_l_Sicredi_Agencia");
    private By textoAgencia = By.id("s_1_2_14_0_icon");
    private By botaoOkAgencia = By.id("s_3_1_45_0_Ctrl");
    private By tabelaDescricaoOportunidade = By.id("1_s_1_l_Name");
    private By tabelaTextoDescricao = By.id("1_s_1_l_Name");
    private By textoDescricao = By.id("1_Name");
    private By tabelaGrupoProduto = By.id("1_s_1_l_Sicredi_Op_Prod_Produto");
    private By textoGrupoProduto = By.id("1_Sicredi_Op_Prod_Produto");
    private By botaoSalvarOportunidade = By.id("s_1_1_11_0_Ctrl");
    private By botaoPesquisarOportunidade = By.id("s_1_1_7_0_Ctrl");
    private By tabelaDescricaoResponsavel = By.id("1_s_1_l_Sales_Rep");
    private By textoDescricaoResponsavel = By.id("1_Sales_Rep");
    private By botaoExcluirOportunidade = By.id("s_1_1_3_0_Ctrl");

    public OportunidadePessoaFisicaPage() {
             acessar();
    }

    public void pesquisarPessoaFisica(String cpf) {

        new PessoaFisicaPage(cpf).acessarNomeCompleto();
    }

    public void acessarOportunidade(){
        clicar(botaoIrParaOportunidade);
    }

    public void adicionarNovaOportunidade() {
        clicar(botaoNovaOportunidade);
    }

    public void selecionarAgenciaAtendimento() {
        clicar(tabelaDescricaoAgencia);
        clicar(textoAgencia);
        clicar(botaoOkAgencia);
    }

    public void preencherDescricao() {
        clicar(tabelaDescricaoOportunidade);
        escrever(textoDescricao, "[TESTE]-Nova oportunidade Automacao");
    }

    public void preencherGrupoProduto() {
       clicar(tabelaGrupoProduto);
       escrever(textoGrupoProduto,"Capital Social");
    }

    public void salvarOportunidade() {
        clicar(botaoSalvarOportunidade);
    }

    public String retornarTextoDescricaoOportunidade() {
        return obterTexto(tabelaTextoDescricao);
    }

    public void pesquisarOportunidade(){
        clicar(botaoPesquisarOportunidade);
    }

    public void selecionarResponsavelOportunidade(String responsavel){
        clicar(tabelaDescricaoResponsavel);
        escrever(textoDescricaoResponsavel,responsavel);
        entrar();
    }

    public void excluirOportunidade() {
        clicar(botaoExcluirOportunidade);
        esperaAceitarAlert();
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();
     }
}
