package pageObjects.digital;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;

public class TelaDeRelacionamentoPjPage extends BasePage {

    private By botaoPesquisarPj = By.id("s_1_1_6_0_Ctrl");
    private By textoPj = By.id("1_Sicredi_CNPJ_Mascara");
    private By botaoIrPj = By.id("s_1_1_5_0_Ctrl");
    private By botaoRecomendarPS = By.cssSelector("div[class='siebui-btn-grp-search'] button[title ='Detalhe da conta:Recomendar P&S']");
    private By textoRecomendadadosbasicos = By.cssSelector("div[class='siebui-applet-taskui-h']");
    private By textoRazaoSocialPj = By.name("Name");
    private By linkEsteiraPS = By.cssSelector("div[id = S_A4_tile_2]");

    public TelaDeRelacionamentoPjPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void pesquisarPj(String cnpj) {
        clicar(botaoPesquisarPj);
        escrever(textoPj, cnpj);
        clicar(botaoIrPj);
    }

    public void clicarBotaoRecomendarPs() {
        clicar(botaoRecomendarPS);

    }

    public String mensagemPaginaRecomendaDadosBasicos() {
        return obterTexto(textoRecomendadadosbasicos);
    }

    public void acessarRazaoSocial() {
        clicar(textoRazaoSocialPj);
    }

    public void clicarlinkEsteiraPS() {
        clicar(linkEsteiraPS);

    }

    private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaJuridica();
    }
}
