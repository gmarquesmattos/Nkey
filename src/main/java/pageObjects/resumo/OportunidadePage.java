package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class OportunidadePage extends BasePage {

    private By botaoIrParaAtividade = By.id("s_18_1_1_0_Ctrl");
    private By botaoNovaOportunidade = By.id("s_1_1_8_0_Ctrl");
    private By botaoIconegrupoProduto = By.id("s_1_2_23_0_icon");
    private By botaoPesquisar = By.id("s_3_1_7_0_Ctrl");
    private By campoGrupoDeProduto = By.id("1_Product_Name");
    private By botaoIrProduto = By.id("s_3_1_4_0_Ctrl");
    private By botaoProdutoOk = By.id("s_3_1_46_0_Ctrl");
    private By campoTextoDescricao = By.id("1_s_1_l_Name");
    private By campoDescriaoProduto = By.id("1_Name");
    private By botaoSalvarOportunidade = By.id("s_1_1_11_0_Ctrl");
    private By botaoExcluirOportunidade = By.id("s_1_1_3_0_Ctrl");

    public OportunidadePage(WebDriver driver) {
        super(driver);
        acessar();

    }

    public OportunidadePage clicarNovaOportunidade() {
        clicar(botaoNovaOportunidade);
        return this;
    }

    public OportunidadePage preencherGrupoProduto() {
        clicar(botaoIconegrupoProduto);
        clicar(botaoPesquisar);
        escrever(campoGrupoDeProduto, "Conta - Corrente");
        clicar(botaoIrProduto);
        clicar(botaoProdutoOk);
        return this;
    }

    public OportunidadePage preencherDescricao() {
        clicar(campoTextoDescricao);
        escrever(campoDescriaoProduto, "Novo oportunidade Automacao");
        return this;
    }

    public OportunidadePage salvarOportunidade() {
        clicar(botaoSalvarOportunidade);
        return this;
    }

    public String pesquisarAtendimento() {
        return obterTexto(campoTextoDescricao);
    }

    public OportunidadePage clicarExcluirOportunidade() {
        clicar(botaoExcluirOportunidade);
        esperaAceitarAlert();
        return this;
    }


    private OportunidadePage acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        new PessoaFisicaPage(driver);
        clicar(botaoIrParaAtividade);
        return this;
    }

}
