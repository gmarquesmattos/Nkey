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

    public DetalhamentoPage novoDetalhamento(Integer valor) {
        editarRenda();
        preencherDetalhamento(valor);
        return this;
    }

    private void preencherDetalhamento(Integer valor) {
        adicionarDetalhamento();
        inserirTipo();
        inserirPeriodicidade();
        inserirValor(valor);
        salvarDetalhamento();

    }

    public void adicionarDetalhamento() {
        clicar(botaoNovoDetalhamento);
    }

    private void inserirTipo() {
        clicar(comboDetalheTipo);
        escrever(seletorTipo, (OUTROS_TIPOS));
    }

    public void inserirPeriodicidade() {
        clicarTab(seletorTipo);
        clicar(seletorPeriodicidade);
        escrever(textoPeriodicidade, (MENSAL_PRIORIDADES));
        clicarTab(textoPeriodicidade);
    }

    public void inserirValor(Integer valor){
        escrever(detalhamentoValor, valor.toString());

    }

    public void salvarDetalhamento(){
        clicar(botaoSalvarDetalhamento);
    }

    public String novoDetalhamentoDuplicado() {
        editarRenda();
        return preencheTipoDuplicado();

    }

    private String preencheTipoDuplicado() {
        incluirNovoDetalhamento();
        clicar(comboDetalheTipo);
        RendaEnviadaPage rendaEnviadaPage = new RendaEnviadaPage(driver);
        String TipoRendaEnviada = obterValueElemento(rendaEnviadaPage.tipoRendaEnviada());
        escrever(seletorTipo, (TipoRendaEnviada));
        salvarDetalhamento();
        String textoJanela = obterTexto(janelaDialogo);
        clicar(botaoAccept);
        excluirRegistroDetalhamento();

        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.deletarRenda();
        return textoJanela;
    }

    public void incluirNovoDetalhamento() {
        clicar(botaoNovoDetalhamento);

    }

      public String tipoDuplicadoBotaoNovodetalhamento() {
        editarRenda();
        return preencheTipoDuplicado();
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

    private void editarRenda() {
        new AlterarRendaPage(driver)
                .editar()
                .salvar();
    }
}