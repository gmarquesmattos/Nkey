package pageObjects.Retaguarda;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetaguardaElementMap {

    @FindBy(id = "s_ssvctrl_tabView")
    WebElement menuAtendimentoRetaguarda;

    @FindBy(linkText = "Lista de atendimentos de retaguarda - cadastro canais")
    WebElement menuListaRetaguardaCadastroCanais;

    @FindBy(id = "s_vis_div")
    WebElement menuTodosMeusAtendimentos;

    @FindBy(xpath = "//div[@id='_swecontent']//option[2]")
    WebElement ClicarTodosMeusAtendimentos;

    @FindBy(id = "s_2_1_12_0_Ctrl")
    WebElement locatorPesquisar;

    @FindBy(id = "1_Sicredi_Organization")
    WebElement inserirCooperativa;


    @FindBy(id = "1_s_2_l_SR_Type_New_")
    WebElement categoriaRetaguarda;

    @FindBy(id = "s_2_1_9_0_Ctrl")
    WebElement realizarBusca;

    @FindBy(xpath = "//div[contains(text(),'Alterar renda?')]")
    WebElement locatorAlterarRenda;

    @FindBy(xpath = "//input[@name='s_3_1_1_0']")
    WebElement locatorAno;

    @FindBy(xpath = "//input[@name='s_3_1_2_0']")
    WebElement locatorMês;

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

    @FindBy(id = "s_1_1_6_0_Ctrl")
    WebElement botaoRetornarFila;

    @FindBy(id = "s_5_1_11_0_Ctrl")
    WebElement botaoNovoDetalhamento;


    @FindBy(id = "1_s_5_l_Sicredi_Tipo")
    WebElement ClicarComboDetalheTipo;

    @FindBy(id = "1_Sicredi_Tipo")
    WebElement campoValorDetalheTipo;

    @FindBy(name = "Outros")
    WebElement ClicarValorTipo;

    @FindBy(id = "1_s_5_l_Sicredi_Peridicidade")
    WebElement clicarCampooDetalhePeriodicidade;

    @FindBy(id = "s_5_2_32_0_icon")
    WebElement ClicarIconeDetalhePeriodicidade;

    @FindBy(id = "1_Sicredi_Peridicidade")
    WebElement valorComboDetalhePeriodicidade;

    @FindBy(id = "1_s_5_l_Sicredi_Valor")
    WebElement clicarCampoValor;

    @FindBy(id = "1_Sicredi_Valor")
    WebElement detalhamentoValor;

    @FindBy(id = "s_5_1_24_0_Ctrl")
    WebElement clicarBotaoSalvar;

    @FindBy(id = "s_5_1_10_0_Ctrl")
    WebElement botaoPesquisar;

    @FindBy(id = "s_5_1_7_0_Ctrl")
    WebElement botaoIr;

    @FindBy(id = "s_3_1_11_0_Ctrl")
    WebElement botaoApagar;

    @FindBy(id = "btn-accept")
    WebElement botaoAccept;

    @FindBy(id = "s_5_1_5_0_Ctrl")
    WebElement botaoExcluirDetalhamento;

}
