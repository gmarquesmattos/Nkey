package pageObjects.retaguarda.detalhamento;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

public class DetalhamentoPage extends BasePage {

    private static final String OUTROS_TIPOS = "outros";
    private static final String MENSAL_PRIORIDADES = "mensal";

    public DetalhamentoPage(WebDriver driver) {
        super(driver);
    }

    private By botaoPesquisarDetalhamento = By.id("s_5_1_10_0_Ctrl");
    private By botaoIr = By.id("s_5_1_7_0_Ctrl");
    private By botaoNovoDetalhamento = By.id("s_5_1_11_0_Ctrl");
    private By clicarComboDetalheTipo = By.id("1_s_5_l_Sicredi_Tipo");
    private By campoValorDetalheTipo = By.id("1_Sicredi_Tipo");
    private By clicarCampooDetalhePeriodicidade = By.id("1_s_5_l_Sicredi_Peridicidade");
    private By valorComboDetalhePeriodicidade = By.id("1_Sicredi_Peridicidade");
    private By detalhamentoValor = By.id("1_Sicredi_Valor");
    private By clicarBotaoSalvar = By.id("s_5_1_24_0_Ctrl");


    public DetalhamentoPage novoDetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.editarAlterarRenda()
                .editarAtendimento();
        clicar(botaoNovoDetalhamento);
        clicar(clicarComboDetalheTipo);
        escrever(campoValorDetalheTipo, (OUTROS_TIPOS));
        tab(campoValorDetalheTipo);
        clicar(clicarCampooDetalhePeriodicidade);
        escrever(valorComboDetalhePeriodicidade, (MENSAL_PRIORIDADES));
        tab(valorComboDetalhePeriodicidade);
        String valor = "2";
        escrever(detalhamentoValor, valor);
        clicar(clicarBotaoSalvar);

        alterarRendaPage.apagarRegistro();
        return this;
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
}
