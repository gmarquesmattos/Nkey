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

import java.time.LocalDate;
import java.time.Year;


public class RetaguardaPO extends RetaguardaElementMap {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String OUTROS_TIPOS = "outros";
    private static final String MENSAL_PRIORIDADES = "mensal";
    private static final String VALOR_DETALHAMENTO = "1200";
    private LocalDate localDate = LocalDate.now();
    Integer ano;
    Integer mes;

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
        mes = (localDate.getMonthValue() + 2);
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
        SeleniumUtil.esperarElementoClicar(botaoPesquisar);
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

    public void apagarRegistro() {
        SeleniumUtil.esperarElementoClicar(botaoApagar);
        try {
            SeleniumUtil.esperaAlert();
        } catch (InterruptedException e) {
            LOGGER.error("Nâo esperou ou encontrou o ALERT.");
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

    private void novoDetalhamento(Integer valor) {
        SeleniumUtil.esperarElementoClicar(botaoSalvarRenda);
        apagarRegistro();
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


