package pageObjects.Retaguarda;

import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.home.HomePO;
import utils.SeleniumUtil;


public class RetaguardaPO extends RetaguardaElementMap {

    protected static final Logger LOGGER = LogManager.getLogger();

    public RetaguardaPO() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void preencherDetalhamento(int valor) {
        acessarCadastroCanais();
        preencherCooperativa();
        editarAtendimento();
        novoDetalhamento(valor);
    }

    public void acessarCadastroCanais() {
        HomePO homePO = new HomePO();
        homePO.selecionarMenuHome();
        SeleniumUtil.esperarElementoClicar(menuAtendimentoRetaguarda);
        SeleniumUtil.esperarElementoClicar(menuListaRetaguardaCadastroCanais);
        SeleniumUtil.esperarElementoClicar(menuTodosMeusAtendimentos);
        SeleniumUtil.esperarElementoClicar(ClicarTodosMeusAtendimentos);
        SeleniumUtil.esperarElementoClicar(locatorPesquisar);
    }

    public void preencherCooperativa() {

        SeleniumUtil.esperarElementoClicar(inserirCooperativa);
        inserirCooperativa.sendKeys("SICREDI PIONEIRA RS");
        SeleniumUtil.esperarElementoClicar(realizarBusca);
        SeleniumUtil.esperarElementoClicar(categoriaRetaguarda);
    }

    public void editarAtendimento() {
        if (botaoAssumirAtendimento.isEnabled()) {
            SeleniumUtil.esperarElementoClicar(botaoAssumirAtendimento);
        }
        SeleniumUtil.esperarElementoClicar(botaoEditar);
    }

    public void novoDetalhamento(int valor) {
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
        SeleniumUtil.esperarElementoClicar(botaoNovoDetalhamento);
        SeleniumUtil.esperarElementoClicar(ClicarComboDetalheTipo);
        campoValorDetalheTipo.sendKeys("outros");
        campoValorDetalheTipo.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampooDetalhePeriodicidade);
        valorComboDetalhePeriodicidade.sendKeys("mensal");
        valorComboDetalhePeriodicidade.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampoValor);
        detalhamentoValor.clear();
        detalhamentoValor.sendKeys("" + valor);
        SeleniumUtil.esperarElementoClicar(clicarBotaoSalvar);


    }

    public void novoDetalhamentoTipoDuplicado() {
        SeleniumUtil.esperarElementoClicar(botaoNovoDetalhamento);
        SeleniumUtil.esperarElementoClicar(ClicarComboDetalheTipo);
        campoValorDetalheTipo.sendKeys("outros");
        campoValorDetalheTipo.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampooDetalhePeriodicidade);
        valorComboDetalhePeriodicidade.sendKeys("mensal");
        valorComboDetalhePeriodicidade.sendKeys(Keys.TAB);
        SeleniumUtil.esperarElementoClicar(clicarCampoValor);
        detalhamentoValor.sendKeys("1200");
        SeleniumUtil.esperarElementoClicar(clicarBotaoSalvar);
    }

    public void alterarRenda(int ano, int mes) {
        SeleniumUtil.esperarElementoClicar(campoAnoRenda);
        campoAnoRenda.clear();
        campoAnoRenda.sendKeys("" + ano);
        SeleniumUtil.esperarElementoClicar(campoMesRenda);
        campoMesRenda.clear();
        campoMesRenda.sendKeys("" + mes);
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
    }


    public void anoNãofinalizado(int ano) {
        SeleniumUtil.esperarElementoClicar(campoAnoRenda);
        campoAnoRenda.clear();
        campoAnoRenda.sendKeys("" + ano);
        campoMesRenda.clear();
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
    }


    public void textValidacao(String text) {
        Assert.assertEquals(text, textDataRenda.getText());
        SeleniumUtil.esperarElementoClicar(botaoAccept);

    }

    public void botãoPesquisar() {
        SeleniumUtil.esperarElementoClicar(botaoPesquisar);
        campoValorDetalheTipo.sendKeys("outros");
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

    public void apagarRegistro() {
        SeleniumUtil.esperarElementoClicar(botaoApagar);
        try {
            SeleniumUtil.esperaAlert();
        } catch (InterruptedException e) {
            System.out.println("Nâo esperou ou encontrou o ALERT.");
        }

        Alert alerta = DriverManager.getDriver().switchTo().alert();
        alerta.accept();
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
}


