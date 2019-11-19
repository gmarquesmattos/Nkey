package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class OportunidadePjPage extends BasePage {

    private By botaoIrParaOportunidade = By.id("s_10_1_1_0_Ctrl");
    private By botaoNovaOportunidadePj = By.id("s_1_1_8_0_Ctrl");
    private By tabelaDescricaoOportunidade = By.id("1_s_1_l_Name");
    private By tabelaDescricaoAgencia = By.id("1_s_1_l_Sicredi_Agencia");
    private By textoAgencia = By.id("s_1_2_14_0_icon");
    private By botaoOk = By.id("s_3_1_45_0_Ctrl");
    private By textoDescricaoOportunidade = By.id("1_Name");
    private By tabelaGrupoProduto = By.id("1_s_1_l_Sicredi_Op_Prod_Produto");
    private By textoGrupoProduto = By.id("1_Sicredi_Op_Prod_Produto");
    private By botaoSalvarOportunidade = By.id("s_1_1_11_0_Ctrl");
    private By botaoExcluirOportunidade = By.id("s_1_1_3_0_Ctrl");

    public OportunidadePjPage() {
        acessar();
    }

    public void pesquisarPessoaJuridica(String cnpj) {
        new PessoaJuridicaPage(cnpj).acessarRazaoSocial();
    }

    public void acessarOportunidade(){
        clicar(botaoIrParaOportunidade);
    }

    public void adicionarNovaOportunidade() {
        clicar(botaoNovaOportunidadePj);
    }

    public void selecionarAgenciaOportunidade() {
        clicar(tabelaDescricaoAgencia);
        clicar(textoAgencia);
        clicar(botaoOk);
    }

    public void preencherDescricao() {
        clicar(tabelaDescricaoOportunidade);
        escrever(textoDescricaoOportunidade, "[TESTE]-Nova Oportunidade Automacao PJ");
    }

    public void preencherGrupoProduto() {
        clicar(tabelaGrupoProduto);
        escrever(textoGrupoProduto,"Capital Social");
    }
    public void salvarOportunidade() {
        clicar(botaoSalvarOportunidade);
    }

    public String pesquisarAtendimentoPj() {
        return obterTexto(tabelaDescricaoOportunidade);
    }

    public void excluirOportunidadePj() {
        clicar(botaoExcluirOportunidade);
        esperaAceitarAlert();
    }

    private void acessar() {
        new HomePage().acessarPessoaJuridica();
      }


}