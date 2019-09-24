package pageObjects.retaguarda.alterarRenda;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.retaguarda.RetaguardaPage;
import pageObjects.retaguarda.rendaEnviada.RendaEnviadaPage;

import java.time.LocalDate;

public class AlterarRendaPage extends BasePage {


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
    private By janelaDialogo = By.id("_sweview_popup");

    public AlterarRendaPage(WebDriver driver) {
        super(driver);
        acessar();

    }


    public void acessar() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.acessarCadastroCanais().preencherCooperativa();

    }

    public AlterarRendaPage editar() {
        editarAtendimento();

        return this;
    }

    public AlterarRendaPage editarAtendimento() {
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
        clicar(botaoEditar);
        return this;
    }

    public void salvar() {
        clicar(botaoSalvarRenda);

        apagarRegistro();
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

    public String validaAnoMaiorQueAtual() {
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
        String texto = obterTexto(janelaDialogo);
        clicar(botaoAccept);
        clicar(botaoCancelar);
        return texto;

    }

    private void assumirAtendimento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage
                .editar();
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
    }

    public String anoNaofinalizado() {
        assumirAtendimento();
        clicar(botaoEditar);
        clicar(textoMesRenda);
        limparCampo(textoMesRenda);
        this.ano = localDate.getYear();
        escrever(textoAnoRenda, this.ano.toString());
        clicar(botaoSalvarRenda);
        return obterTexto(janelaDialogo);
    }

    public AlterarRendaPage apagarRegistro() {
        clicar(botaoApagar);
        esperaAceitarAlert();
        return this;
    }


}
