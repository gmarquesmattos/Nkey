package pageObjects.retaguarda.alterarRenda;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.retaguarda.RetaguardaPage;
import java.time.LocalDate;

public class AlterarRendaPage extends BasePage {

    public AlterarRendaPage(WebDriver driver) {
        super(driver);
    }

    private LocalDate localDate = LocalDate.now();
    private Integer ano;
    private Integer mes;
    private By botaoAssumirAtendimento = By.id("s_1_1_1_0_Ctrl");
    private By botaoEditar = By.id("s_3_1_13_0_Ctrl");
    private By botaoApagar = By.id("s_3_1_11_0_Ctrl");
    private By botaoSalvarRenda = By.id("s_6_1_13_0_Ctrl");
    private By textoAnoRenda = By.xpath("//input[@name='s_6_1_1_0']");
    private By textoMesRenda = By.xpath("//input[@name='s_6_1_2_0']");
    private By botaoAccept = By.id("btn-accept");
    private By botaoCancelar = By.id("s_6_1_11_0_Ctrl");
    private By textoAnoAltRenda = By.name("s_3_1_1_0");
    private By textoAnoRendaEnv = By.name("s_2_1_0_0");
    private By textoMesAlterarRenda = By.name("s_3_1_2_0");
    private By textoMesRendaEnv = By.name("s_2_1_1_0");
    private By textoTipoDetalhamento = By.id("1_s_5_l_Sicredi_Tipo");
    private By textoTipoRendaEnv = By.name("s_2_1_3_0");
    private By janelaDialogo = By.id("_sweview_popup");

    public AlterarRendaPage editarAlterarRenda() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage
                .acessarCadastroCanais()
                .preencherCooperativa();
        editarAtendimento();
        apagarRegistro();
        return this;
    }

    public AlterarRendaPage editarAtendimento() {
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
        clicar(botaoEditar);
        clicar(botaoSalvarRenda);
        String anoAlterarRenda = obterValueElemento(textoAnoAltRenda);
        String anoRendaEnv = obterValueElemento(textoAnoRendaEnv);
        compararString(anoAlterarRenda, anoRendaEnv);
        String mesAlterarRenda = obterValueElemento(textoMesAlterarRenda);
        String mesRendaEnv = obterValueElemento(textoMesRendaEnv);
        compararString(mesAlterarRenda, mesRendaEnv);
        String tipoDetalhamento;
        tipoDetalhamento = obterTexto((textoTipoDetalhamento));
        String tipoRendaEnv = obterValueElemento(textoTipoRendaEnv);
        compararString(tipoDetalhamento, tipoRendaEnv);
        return this;
    }

    public AlterarRendaPage ValidaAnoMes() {
        int mes = -2;
        assumirAtendimento();
        clicar(botaoEditar);
        clicar(textoAnoRenda);
        ano = localDate.getYear();
        escrever(textoAnoRenda, ano.toString());
        clicar(textoMesRenda);
        this.mes = (localDate.getMonthValue() + mes);
        escrever(textoMesRenda, this.mes.toString());
        clicar(botaoSalvarRenda);
        apagarRegistro();
        return this;
    }

    public AlterarRendaPage validaAnoMaiorQueAtual() {
        int mes = 2;
        assumirAtendimento();
        clicar(botaoEditar);
        clicar(textoAnoRenda);
        ano = localDate.getYear();
        escrever(textoAnoRenda, ano.toString());
        clicar(textoMesRenda);
        this.mes = (localDate.getMonthValue() + mes);
        escrever(textoMesRenda, this.mes.toString());
        clicar(botaoSalvarRenda);

        String textoEsperado = "O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)";
        String textoJanela = obterTexto(janelaDialogo);
        compararString(textoEsperado, textoJanela);
        clicar(botaoAccept);
        clicar(botaoCancelar);
        return this;
    }

    private void assumirAtendimento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage
                .editarAlterarRenda();
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
    }

    public AlterarRendaPage anoNaofinalizado() {
        assumirAtendimento();
        clicar(botaoEditar);
        clicar(textoMesRenda);
        limparCampo(textoMesRenda);
        this.ano = localDate.getYear();
        escrever(textoAnoRenda, this.ano.toString());
        clicar(botaoSalvarRenda);
        String texto = obterTexto(janelaDialogo);
        String texto2 = "Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)";
        compararString(texto2, texto);
        return this;
    }

    public AlterarRendaPage apagarRegistro() {
        clicar(botaoApagar);
        esperaAceitarAlert();
        return this;
    }
}
