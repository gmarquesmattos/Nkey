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

    public DetalhamentoPage novoDetalhamentoDuplicado() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(comboDetalheTipo);
        String TipoRendaEnv = obterValueElemento(textoTipoRendaEnv);
        escrever(seletorTipo, (TipoRendaEnv));
        clicarTab(seletorTipo);
        clicar(botaoSalvarDetalhamento);
        String textoJanela = obterTexto(janelaDialogo);
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        compararString(textoJanela,textoEsperado );
        clicar(botaoAccept);
        excluirRegistroDetalhamento();
        alterarRendaPage.apagarRegistro();
        return this;

    }

    public void TipoDuplicadoBotaoNovodetalhamento() {
        clicar(botaoNovoDetalhamento);
        clicar(comboDetalheTipo);
        escrever(seletorTipo, (OUTROS_TIPOS));
        clicarTab(seletorTipo);
        clicar(seletorPeriodicidade);
        escrever(textoPeriodicidade, (MENSAL_PRIORIDADES));
        clicarTab(textoPeriodicidade);
        clicar(textoValor);
        escrever(detalhamentoValor, (CAMPO_VALOR));
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
        String textoJanela = obterTexto(janelaDialogo);
        String textoEsperado = "'Periodicidade' é um campo obrigatório. Informe um valor para o campo. (SBL-DAT-00498)";
        compararString(textoJanela, textoEsperado);

    }

    public void excluirRegistroDetalhamento() {
        clicar(botaoExcluirDetalhamento);
        esperaAceitarAlert();

    }

}
