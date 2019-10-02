package pageObjects.retaguarda.detalhamento;

import base.BasePage;
import org.openqa.selenium.*;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;
import pageObjects.retaguarda.rendaEnviada.RendaEnviadaPage;

public class DetalhamentoPage extends BasePage {

    private static final String OUTROS_TIPOS = "outros";
    private static final String MENSAL_PRIORIDADES = "mensal";
    private By botaoPesquisarDetalhamento = By.id("s_5_1_10_0_Ctrl");
    private By botaoIr = By.id("s_5_1_7_0_Ctrl");
    private By botaoNovoDetalhamento = By.id("s_5_1_11_0_Ctrl");
    private By comboDetalheTipo = By.id("1_s_5_l_Sicredi_Tipo");
    private By seletorTipo = By.id("1_Sicredi_Tipo");
    private By seletorPeriodicidade = By.id("1_s_5_l_Sicredi_Peridicidade");
    private By textoPeriodicidade = By.id("1_Sicredi_Peridicidade");
    private By detalhamentoValor = By.id("1_Sicredi_Valor");
    private By botaoSalvarDetalhamento = By.id("s_5_1_24_0_Ctrl");
    private By botaoExcluirDetalhamento = By.id("s_5_1_5_0_Ctrl");
    private By janelaDialogo = By.id("_sweview_popup");
    private By botaoAccept = By.id("btn-accept");

    public DetalhamentoPage(WebDriver driver) {
        super(driver);
    }

    public DetalhamentoPage novoDetalhamento(int valor) {
        editarRenda();
        preencherDetalhamento(valor);
        new AlterarRendaPage(driver).deletarRenda();
        return this;
    }

    private void preencherDetalhamento(Integer valor) {
        clicar(botaoNovoDetalhamento);
        clicar(comboDetalheTipo);
        escrever(seletorTipo, (OUTROS_TIPOS));
        clicarTab(seletorTipo);
        clicar(seletorPeriodicidade);
        escrever(textoPeriodicidade, (MENSAL_PRIORIDADES));
        clicarTab(textoPeriodicidade);
        escrever(detalhamentoValor, valor.toString());
        clicar(botaoSalvarDetalhamento);

    }

    public String novoDetalhamentoDuplicado() {
        editarRenda();
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        RendaEnviadaPage rendaEnviadaPage = new RendaEnviadaPage(driver);
        String textoJanela = preencheTipoDuplicado(alterarRendaPage, rendaEnviadaPage, botaoSalvarDetalhamento);
        return textoJanela;

    }

    public String preencheTipoDuplicado(AlterarRendaPage alterarRendaPage, RendaEnviadaPage rendaEnviadaPage, By botaoSalvarDetalhamento) {
        clicar(botaoNovoDetalhamento);
        clicar(comboDetalheTipo);
        String TipoRendaEnviada = obterValueElemento(rendaEnviadaPage.tipoRendaEnviada());
        escrever(seletorTipo, (TipoRendaEnviada));
        clicar(botaoSalvarDetalhamento);
        String textoJanela = obterTexto(janelaDialogo);
        clicar(botaoAccept);
        excluirRegistroDetalhamento();
        alterarRendaPage.deletarRenda();
        return textoJanela;
    }

    public String TipoDuplicadoBotaoNovodetalhamento() {
        editarRenda();
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        RendaEnviadaPage rendaEnviadaPage = new RendaEnviadaPage(driver);
        String textoJanela = preencheTipoDuplicado(alterarRendaPage, rendaEnviadaPage, botaoNovoDetalhamento);
        return textoJanela;
    }

    public DetalhamentoPage pesquisarDetalhamento() {
        editarRenda();
        clicar(botaoPesquisarDetalhamento);
        clicar(botaoIr);
        return this;
    }

    public DetalhamentoPage salvarSemDetalhamento() {
        editarRenda();
        clicar(botaoNovoDetalhamento);
        clicar(botaoSalvarDetalhamento);
        return this;
    }

    public DetalhamentoPage excluirRegistroDetalhamento() {
        clicar(botaoExcluirDetalhamento);
        esperaAceitarAlert();
        return this;
    }

    public String pegarMensagemJanelaDeErro() {
        String texto = obterTexto(janelaDialogo);
        clicar(botaoAccept);
        return texto;
    }

    public DetalhamentoPage inserirValor(int valor) {
        editarRenda();
        preencherDetalhamento(valor);
        return this;
    }

    private void editarRenda() {
        new AlterarRendaPage(driver)
                .editar()
                .salvar();
    }
}