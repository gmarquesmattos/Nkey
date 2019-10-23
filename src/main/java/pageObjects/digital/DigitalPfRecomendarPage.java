package pageObjects.digital;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;

public class DigitalPfRecomendarPage extends BasePage {

    private By botaoPesquisar = By.id("s_1_1_11_0_Ctrl");
    private By textoCpf = By.id("1_Social_Security_Number");
    private By botaoRecomendarPS = By.cssSelector("button[class='siebui-ctrl-btn siebui-icon-launchtask s_2_1_13_0 appletButton']");
    private By janelaErroRecomendar = By.cssSelector("#_sweview_popup");
    private By textoRecomendadadosbasicos = By.cssSelector("div[class='siebui-applet-taskui-h']");
    private By linkEsteiraPS = By.cssSelector("#S_A14_tile_2");

    public DigitalPfRecomendarPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void pesquisarPessoa(String cpf) {
        clicar(botaoPesquisar);
        escrever(textoCpf, cpf);
        entrar();
    }

    public void clicarBotaorecomendarPS() {
        clicar(botaoRecomendarPS);
    }

    public String mensagemRecomendar() {
        return obterTexto(janelaErroRecomendar);
    }

    public String mensagemPaginaRecomendaDadosBasicos() {
        return obterTexto(textoRecomendadadosbasicos);
    }

    public void clicarlinkEsteiraPS() {
        clicar(linkEsteiraPS);

    }

    public String esperaAceitarAlertRecomendar() {

        return esperaAceitarAlert();

    }

    private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
    }
}
