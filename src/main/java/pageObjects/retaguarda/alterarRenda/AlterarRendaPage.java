package pageObjects.retaguarda.alterarRenda;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.retaguarda.RetaguardaPage;

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
    }

    public void acessar() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.acessarCadastroCanais().preencherCooperativa();
    }

    public AlterarRendaPage editar() {
        verificaBotaoAssumirAtendimentoDisponivel();
        return this;
    }

    public AlterarRendaPage verificaBotaoAssumirAtendimentoDisponivel() {
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
        clicar(botaoEditar);
        return this;
    }

    public void salvar() {
        clicar(botaoSalvarRenda);
    }

    public AlterarRendaPage insereMes(int mes) {
        clicar(textoMesRenda);
        this.mes = (localDate.getMonthValue() + mes);
        escrever(textoMesRenda, this.mes.toString());

        return this;
    }


    public String pegarMensagemJanelaDeErro() {
        String texto = obterTexto(janelaDialogo);
        clicar(botaoAccept);
        clicar(botaoCancelar);
        return texto;

    }

    public AlterarRendaPage insereAno() {
        clicar(textoMesRenda);
        limparCampo(textoMesRenda);
        this.ano = localDate.getYear();
        escrever(textoAnoRenda, this.ano.toString());
        return this;
    }

    public AlterarRendaPage apagarRenda() {
        clicar(botaoApagar);
        esperaAceitarAlert();
        return this;
    }


}
