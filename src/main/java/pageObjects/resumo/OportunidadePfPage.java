package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class OportunidadePfPage extends BasePage {

    private By botaoIrParaAtividade = By.id("s_18_1_1_0_Ctrl");
    private By botaoNovaOportunidade = By.id("s_1_1_8_0_Ctrl");
    private By campoGrupoDeProduto = By.id("1_Sicredi_Op_Prod_Produto");
    private By campoTextoDescricao = By.id("1_s_1_l_Name");
    private By campoDescriaoProduto = By.id("1_Name");
    private By botaoSalvarOportunidade = By.id("s_1_1_11_0_Ctrl");
    private By botaoExcluirOportunidade = By.id("s_1_1_3_0_Ctrl");

    public OportunidadePfPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void clicarNovaOportunidade() {
        clicar(botaoNovaOportunidade);
    }

    public void preencherGrupoProduto() {
        escrever(campoGrupoDeProduto, "Conta - Corrente");
        clicarTab(campoGrupoDeProduto);
    }

    public void preencherDescricao() {
        clicar(campoTextoDescricao);
        escrever(campoDescriaoProduto, "Novo oportunidade Automacao");
    }

    public void salvarOportunidade() {
        clicar(botaoSalvarOportunidade);
    }

    public String pesquisarAtendimento() {
        return obterTexto(campoTextoDescricao);
    }

    public void clicarExcluirOportunidade() {
        clicar(botaoExcluirOportunidade);
        esperaAceitarAlert();
    }

    private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        new PessoaFisicaPage(driver);
        clicar(botaoIrParaAtividade);
    }
}
