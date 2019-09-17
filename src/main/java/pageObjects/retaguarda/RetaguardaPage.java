package pageObjects.retaguarda;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.home.HomePage;

import java.time.LocalDate;


public class RetaguardaPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger();
    private final String OUTROS_TIPOS = "outros";
    private final String MENSAL_PRIORIDADES = "mensal";
    private final String VALOR_DETALHAMENTO = "1200";
    private LocalDate localDate = LocalDate.now();
    private Integer ano;
    private Integer mes;

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

    @FindBy(id = "s_1_1_1_0_Ctrl")
    WebElement botaoAssumirAtendimento;

    @FindBy(id = "s_3_1_13_0_Ctrl")
    WebElement botaoEditar;

    @FindBy(xpath = "//input[@name='s_6_1_1_0']")
    WebElement campoAnoRenda;

    @FindBy(xpath = "//input[@name='s_6_1_2_0']")
    WebElement campoMesRenda;

    @FindBy(id = "s_6_1_13_0_Ctrl")
    WebElement botaoSalvarRenda;

    @FindBy(xpath = "//div[@id='_sweview_popup']")
    WebElement textDataRenda;

    @FindBy(id = "s_5_1_11_0_Ctrl")
    WebElement botaoNovoDetalhamento;

    @FindBy(id = "1_s_5_l_Sicredi_Tipo")
    WebElement ClicarComboDetalheTipo;

    @FindBy(id = "1_Sicredi_Tipo")
    WebElement campoValorDetalheTipo;

    @FindBy(id = "1_s_5_l_Sicredi_Peridicidade")
    WebElement clicarCampooDetalhePeriodicidade;


    @FindBy(id = "1_Sicredi_Peridicidade")
    WebElement valorComboDetalhePeriodicidade;

    @FindBy(id = "1_s_5_l_Sicredi_Valor")
    WebElement clicarCampoValor;

    @FindBy(id = "1_Sicredi_Valor")
    WebElement detalhamentoValor;

    @FindBy(id = "s_5_1_24_0_Ctrl")
    WebElement clicarBotaoSalvar;

    @FindBy(id = "s_5_1_10_0_Ctrl")
    WebElement botaoPesquisar2;

    @FindBy(id = "s_5_1_7_0_Ctrl")
    WebElement botaoIr;


    @FindBy(id = "btn-accept")
    WebElement botaoAccept;

    @FindBy(id = "s_5_1_5_0_Ctrl")
    WebElement botaoExcluirDetalhamento;


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


}


