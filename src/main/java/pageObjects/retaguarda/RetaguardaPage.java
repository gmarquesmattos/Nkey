package pageObjects.retaguarda;

import base.BasePage;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.home.HomePage;
import utils.SeleniumUtil;

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

    public RetaguardaPage preencherDetalhamento(int valor) {
        acessarCadastroCanais();
        preencherCooperativa();
        editarAtendimento();
        novoDetalhamento(valor);
        return this;
    }

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

    public void editarAtendimento() {
        if (botaoAssumirAtendimento.isEnabled()) {
            SeleniumUtil.esperarElementoClicar(botaoAssumirAtendimento);
        }
        SeleniumUtil.esperarElementoClicar(botaoEditar);


    }


    public void novoDetalhamentoTipoDuplicado() {
        SeleniumUtil.esperarElementoClicar(botaoNovoDetalhamento);
        SeleniumUtil.esperarElementoClicar(ClicarComboDetalheTipo);
        campoValorDetalheTipo.sendKeys(OUTROS_TIPOS);
        campoValorDetalheTipo.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampooDetalhePeriodicidade);
        valorComboDetalhePeriodicidade.sendKeys(MENSAL_PRIORIDADES);
        valorComboDetalhePeriodicidade.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampoValor);
        detalhamentoValor.sendKeys(VALOR_DETALHAMENTO);
        SeleniumUtil.esperarElementoClicar(clicarBotaoSalvar);
    }


    public void TipoDuplicadoBotaoNovodetalhamento() {
        SeleniumUtil.esperarElementoClicar(botaoNovoDetalhamento);
        SeleniumUtil.esperarElementoClicar(ClicarComboDetalheTipo);
        campoValorDetalheTipo.sendKeys(OUTROS_TIPOS);
        campoValorDetalheTipo.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampooDetalhePeriodicidade);
        valorComboDetalhePeriodicidade.sendKeys(MENSAL_PRIORIDADES);
        valorComboDetalhePeriodicidade.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampoValor);
        detalhamentoValor.sendKeys(VALOR_DETALHAMENTO);
        SeleniumUtil.esperarElementoClicar(botaoNovoDetalhamento);
    }


    public void alterarRenda() {
        SeleniumUtil.esperarElementoClicar(campoAnoRenda);
        campoAnoRenda.clear();
        ano = localDate.getYear();
        campoAnoRenda.sendKeys(ano.toString());
        SeleniumUtil.esperarElementoClicar(campoMesRenda);
        campoMesRenda.clear();
        mes = (localDate.getMonthValue() + 1);
        campoMesRenda.sendKeys(mes.toString());
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
    }

    public void anoNaofinalizado() {
        SeleniumUtil.esperarElementoClicar(campoAnoRenda);
        campoAnoRenda.clear();
        Integer var = localDate.getYear();
        campoAnoRenda.sendKeys(var.toString());
        campoMesRenda.clear();
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
    }


    public void textValidacao(String text) {
        Assert.assertEquals(text, textDataRenda.getText());
        SeleniumUtil.esperarElementoClicar(botaoAccept);

    }

    public void botaoPesquisar() {
        SeleniumUtil.esperarElementoClicar(botaoPesquisar2);
        campoValorDetalheTipo.sendKeys(OUTROS_TIPOS);
        campoValorDetalheTipo.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(botaoIr);
    }

    public void salvarSemDetalhamento() {
        if (botaoAssumirAtendimento.isEnabled()) {
            SeleniumUtil.esperarElementoClicar(botaoAssumirAtendimento);
        }
        SeleniumUtil.esperarElementoClicar(botaoEditar);
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
        SeleniumUtil.esperarElementoClicar(botaoNovoDetalhamento);
        SeleniumUtil.esperarElementoClicar(clicarBotaoSalvar);
    }



    public void excluirRegistroDetalhamento() {
        SeleniumUtil.esperarElementoClicar(botaoExcluirDetalhamento);

        try {
            SeleniumUtil.esperaAlert();
        } catch (InterruptedException e) {
            LOGGER.error("Nâo esperou ou encontrou o ALERT.");
        }

        Alert alerta = DriverManager.getDriver().switchTo().alert();
        alerta.accept();
    }

    private void novoDetalhamento(Integer valor) {
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);

        SeleniumUtil.esperarElementoClicar(botaoEditar);
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
        SeleniumUtil.esperarElementoClicar(botaoNovoDetalhamento);
        SeleniumUtil.esperarElementoClicar(ClicarComboDetalheTipo);
        campoValorDetalheTipo.sendKeys(OUTROS_TIPOS);
        campoValorDetalheTipo.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampooDetalhePeriodicidade);
        valorComboDetalhePeriodicidade.sendKeys(MENSAL_PRIORIDADES);
        valorComboDetalhePeriodicidade.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampoValor);
        detalhamentoValor.clear();
        detalhamentoValor.sendKeys(valor.toString());
        SeleniumUtil.esperarElementoClicar(clicarBotaoSalvar);
    }

}


