package pageObjects.retaguarda.alterarRenda;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.Alert;
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
        String stringTextoAnoAltRenda = obterValueElemento("s_3_1_1_0");
        String stringTextoAnoRendaEnv = obterValueElemento("s_2_1_0_0");
        compararString(stringTextoAnoAltRenda, stringTextoAnoRendaEnv);
        String stringTextoMesAlterarRenda = obterValueElemento("s_3_1_2_0");
        String stringTextoMesRendaEnv = obterValueElemento("s_2_1_1_0");
        compararString(stringTextoMesAlterarRenda, stringTextoMesRendaEnv);
        String stringTextoTipoDetalhamento = obterTexto(By.id("1_s_5_l_Sicredi_Tipo"));
        String stringTextoTipoRendaEnv = obterValueElemento("s_2_1_3_0");
        compararString(stringTextoTipoDetalhamento, stringTextoTipoRendaEnv);
        return this;
    }

    public AlterarRendaPage alterarRendaValidaAnoMes(int mes) {

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

    public AlterarRendaPage naoSalvaraRendaMesAnoMaiorAtual(int mes2, String textoPopup, String textoEsperado) {
        assumirAtendimento();
        clicar(botaoEditar);
        clicar(textoAnoRenda);
        ano = localDate.getYear();
        escrever(textoAnoRenda, ano.toString());
        clicar(textoMesRenda);
        this.mes = (localDate.getMonthValue() + mes2);
        escrever(textoMesRenda, this.mes.toString());
        clicar(botaoSalvarRenda);
        compararString(textoPopup, textoEsperado);
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

    public AlterarRendaPage anoNaofinalizado(String textoPopup, String textoEsperado) {
        assumirAtendimento();
        clicar(botaoEditar);
        clicar(textoMesRenda);
        delete(textoMesRenda);
        this.ano = localDate.getYear();
        escrever(textoAnoRenda, this.ano.toString());


        compararString(textoPopup, textoEsperado);
        clicar(botaoSalvarRenda);
        return this;
    }

    public AlterarRendaPage apagarRegistro() {
        clicar(botaoApagar);
        try {
            BasePage.esperaAlert();
        } catch (InterruptedException e) {
            LOGGER.error("Nâo esperou ou encontrou o ALERT.");
        }
        Alert alerta = DriverManager.getDriver().switchTo().alert();
        alerta.accept();
        return this;
    }
}
