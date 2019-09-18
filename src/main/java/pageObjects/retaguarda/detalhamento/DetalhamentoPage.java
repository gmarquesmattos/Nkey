package pageObjects.retaguarda.detalhamento;

import base.BasePage;
import org.openqa.selenium.*;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

public class DetalhamentoPage extends BasePage {

    private static final String OUTROS_TIPOS = "outros";
    private static final String MENSAL_PRIORIDADES = "mensal";
    private final String CAMPO_VALOR = "1200";
    private By botaoPesquisarDetalhamento = By.id("s_5_1_10_0_Ctrl");
    private By botaoIr = By.id("s_5_1_7_0_Ctrl");
    private By botaoNovoDetalhamento = By.id("s_5_1_11_0_Ctrl");
    private By comboDetalheTipo = By.id("1_s_5_l_Sicredi_Tipo");
    private By seletorTipo = By.id("1_Sicredi_Tipo");
    private By seletorPeriodicidade = By.id("1_s_5_l_Sicredi_Peridicidade");
    private By textoPeriodicidade = By.id("1_Sicredi_Peridicidade");
    private By detalhamentoValor = By.id("1_Sicredi_Valor");
    private By botaoSalvarDetalhamento = By.id("s_5_1_24_0_Ctrl");
    private By textoValor = By.id("1_s_5_l_Sicredi_Valor");
    private By botaoExcluirDetalhamento = By.id("s_5_1_5_0_Ctrl");
    private By janelaDialogo = By.id("_sweview_popup");
    private By botaoAccept = By.id("btn-accept");
    private By textoTipoRendaEnv = By.name("s_2_1_3_0");

    public DetalhamentoPage(WebDriver driver) {
        super(driver);
    }

    public DetalhamentoPage novoDetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(comboDetalheTipo);
        escrever(seletorTipo, (OUTROS_TIPOS));
        clicarTab(seletorTipo);
        clicar(seletorPeriodicidade);
        escrever(textoPeriodicidade, (MENSAL_PRIORIDADES));
        clicarTab(textoPeriodicidade);
        String valor = "2";
        escrever(detalhamentoValor, valor);
        clicar(botaoSalvarDetalhamento);
        alterarRendaPage.apagarRegistro();
        return this;
    }

    public String novoDetalhamentoDuplicado() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(comboDetalheTipo);
        String TipoRendaEnviada = obterValueElemento(textoTipoRendaEnv);///////////////////////////////////////////////////
        escrever(seletorTipo, (TipoRendaEnviada));
        clicarTab(seletorTipo);
        clicar(botaoSalvarDetalhamento);
        String textoJanela = obterTexto(janelaDialogo);
        clicar(botaoAccept);
        excluirRegistroDetalhamento();
        alterarRendaPage.apagarRegistro();
        return textoJanela;

    }

    public String TipoDuplicadoBotaoNovodetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(comboDetalheTipo);
        String TipoRendaEnviada = obterValueElemento(textoTipoRendaEnv);///////////////////////////////////////////////////
        escrever(seletorTipo, (TipoRendaEnviada));
        clicarTab(seletorTipo);
        String textoJanela = obterTexto(janelaDialogo);
        clicar(botaoAccept);
        excluirRegistroDetalhamento();
        alterarRendaPage.apagarRegistro();
        return textoJanela;
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

    public String salvarSemDetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda().editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(botaoSalvarDetalhamento);
        return obterTexto(janelaDialogo);
    }

    private void excluirRegistroDetalhamento() {
        clicar(botaoExcluirDetalhamento);
        esperaAceitarAlert();
    }
}
