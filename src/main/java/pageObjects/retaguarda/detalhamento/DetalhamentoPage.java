package pageObjects.retaguarda.detalhamento;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.*;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

public class DetalhamentoPage extends BasePage {

    private static final String OUTROS_TIPOS = "outros";
    private static final String MENSAL_PRIORIDADES = "mensal";
    private final String VALOR_DETALHAMENTO = "1200";
    private By botaoPesquisarDetalhamento = By.id("s_5_1_10_0_Ctrl");
    private By botaoIr = By.id("s_5_1_7_0_Ctrl");
    private By botaoNovoDetalhamento = By.id("s_5_1_11_0_Ctrl");
    private By clicarComboDetalheTipo = By.id("1_s_5_l_Sicredi_Tipo");
    private By campoValorDetalheTipo = By.id("1_Sicredi_Tipo");
    private By clicarCampooDetalhePeriodicidade = By.id("1_s_5_l_Sicredi_Peridicidade");
    private By valorComboDetalhePeriodicidade = By.id("1_Sicredi_Peridicidade");
    private By detalhamentoValor = By.id("1_Sicredi_Valor");
    private By botaoSalvarDetalhamento = By.id("s_5_1_24_0_Ctrl");
    private By clicarCampoValor = By.id("1_s_5_l_Sicredi_Valor");
    private By botaoExcluirDetalhamento = By.id("s_5_1_5_0_Ctrl");
    private By popup = By.id("_sweview_popup");
    private By botaoAccept = By.id("btn-accept");

    public DetalhamentoPage(WebDriver driver) {
        super(driver);
    }

    public DetalhamentoPage novoDetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(clicarComboDetalheTipo);
        escrever(campoValorDetalheTipo, (OUTROS_TIPOS));
        clicarTab(campoValorDetalheTipo);
        clicar(clicarCampooDetalhePeriodicidade);
        escrever(valorComboDetalhePeriodicidade, (MENSAL_PRIORIDADES));
        clicarTab(valorComboDetalhePeriodicidade);
        String valor = "2";
        escrever(detalhamentoValor, valor);
        clicar(botaoSalvarDetalhamento);
        alterarRendaPage.apagarRegistro();
        return this;
    }

    public DetalhamentoPage novoDetalhamentoDuplicado() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(clicarComboDetalheTipo);
        String stringTextoTipoRendaEnv = obterValueElemento("s_2_1_3_0");
        escrever(campoValorDetalheTipo, (stringTextoTipoRendaEnv));
        clicarTab(campoValorDetalheTipo);
        clicar(botaoSalvarDetalhamento);
        String Text = obterTexto(popup);
        compararString(Text, Text);
        clicar(botaoAccept);
        excluirRegistroDetalhamento();
        alterarRendaPage.apagarRegistro();
        return this;

    }

    public void TipoDuplicadoBotaoNovodetalhamento() {
        clicar(botaoNovoDetalhamento);
        clicar(clicarComboDetalheTipo);
        escrever(campoValorDetalheTipo, (OUTROS_TIPOS));
        clicarTab(campoValorDetalheTipo);
        clicar(clicarCampooDetalhePeriodicidade);
        escrever(valorComboDetalhePeriodicidade, (MENSAL_PRIORIDADES));
        clicarTab(valorComboDetalhePeriodicidade);
        clicar(clicarCampoValor);
        escrever(detalhamentoValor, (VALOR_DETALHAMENTO));
        clicar(botaoNovoDetalhamento);
    }

    public DetalhamentoPage pesquisarDetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage
                .editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoPesquisarDetalhamento);
        clicar(botaoIr);
        return this;
    }

    public void salvarSemDetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(botaoSalvarDetalhamento);
        String Text = obterTexto(popup);
        compararString(Text, Text);

    }

    public void excluirRegistroDetalhamento() {
        clicar(botaoExcluirDetalhamento);
        esperaAceitarAlert();

    }

}
