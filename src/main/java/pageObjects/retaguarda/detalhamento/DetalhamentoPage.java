package pageObjects.retaguarda.detalhamento;

import base.BasePage;
import org.openqa.selenium.*;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;


public class DetalhamentoPage extends BasePage {

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
        editarRenda();
    }

    public DetalhamentoPage novoDetalhamento() {
        adicionarDetalhamento();
        return this;
    }

    public DetalhamentoPage adicionarDetalhamento() {
        clicar(botaoNovoDetalhamento);
        return this;
    }

    public DetalhamentoPage inserirTipo(String tipoDetalhamento) {
        clicar(comboDetalheTipo);
        escrever(seletorTipo, tipoDetalhamento);
        return this;
    }

    public DetalhamentoPage inserirPeriodicidade() {
        clicarTab(seletorTipo);
        clicar(seletorPeriodicidade);
        escrever(textoPeriodicidade, (MENSAL_PRIORIDADES));
        clicarTab(textoPeriodicidade);

        return this;
    }

    public DetalhamentoPage inserirValor(Integer valor) {
        escrever(detalhamentoValor, valor.toString());

        return this;
    }

    public DetalhamentoPage salvarDetalhamento() {
        clicar(botaoSalvarDetalhamento);
        return this;
    }


    public DetalhamentoPage pesquisarDetalhamento() {

        clicar(botaoPesquisarDetalhamento);
        clicar(botaoIr);
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