package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class OportunidadePfPage extends BasePage {

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
    private By botaoExcluirOportunidade = By.id("s_1_1_3_0_Ctrl");

    public OportunidadePfPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(driver, cpf).acessarNomeCompleto();
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
        escrever(textoDescricao, "Nova oportunidade Automacao");
    }

    public void preencherGrupoProduto() {
       clicar(tabelaGrupoProduto);
       escrever(textoGrupoProduto,"Capital Social");
    }

    public void salvarOportunidade() {
        clicar(botaoSalvarOportunidade);
    }

    public String pesquisarTextoDescricaoOportunidade() {
        return obterTexto(tabelaTextoDescricao);
    }

    public void ExcluirOportunidade() {
        clicar(botaoExcluirOportunidade);
        esperaAceitarAlert();
    }

    private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
     }
}
