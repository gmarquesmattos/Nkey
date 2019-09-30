package pageObjects.retaguarda;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;


public class RetaguardaPage extends BasePage {


    public RetaguardaPage(WebDriver driver) {
        super(driver);
    }

    private By botaoListaDeAtendimentosRetaguarda = By.id("s_ssvctrl_tabView");
    private By tabelaListaRetaguardaCadastroCanais = By.linkText("Lista de atendimentos de retaguarda - cadastro canais");
    private By seletorAtendimentos = By.id("s_vis_div");
    private By opcaoTodosMeusAtendimentos = By.xpath("//div[@id='_swecontent']//option[2]");
    private By botaoPesquisar = By.id("s_2_1_12_0_Ctrl");
    private By textoCooperativa = By.id("1_Sicredi_Organization");
    private By tabelaCategoria = By.id("1_s_2_l_SR_Type_New_");
    private By botaoRetaguardaIr = By.id("s_2_1_9_0_Ctrl");

    public RetaguardaPage acessarCadastroCanais() {
        HomePage homePO = new HomePage(driver);
        homePO.selecionarMenuHome();
        clicar(botaoListaDeAtendimentosRetaguarda);
        clicar(tabelaListaRetaguardaCadastroCanais);
        clicar(seletorAtendimentos);
        clicar(opcaoTodosMeusAtendimentos);
        clicar(botaoPesquisar);
        return this;
    }

    public RetaguardaPage preencherCooperativa() {
        escrever(textoCooperativa, "SICREDI PIONEIRA RS");
        clicar(botaoRetaguardaIr);
        clicar(tabelaCategoria);
        return this;

    }


    public void apagarRegistro() {
    }
}


