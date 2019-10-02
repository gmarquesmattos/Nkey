package pageObjects.retaguarda.alterarRenda;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.retaguarda.RetaguardaPage;
import pageObjects.retaguarda.rendaEnviada.RendaEnviadaPage;

import java.time.LocalDate;

public class AlterarRendaPage extends BasePage {

    private LocalDate localDate = LocalDate.now();
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

    public AlterarRendaPage acessar() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.acessarCadastroCanais().preencherCooperativa();
        return this;
    }

    public AlterarRendaPage editar() {
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
        clicar(botaoEditar);
        return this;

    }

    public AlterarRendaPage salvar() {
        clicar(botaoSalvarRenda);
        return this;
    }

    public AlterarRendaPage insereMes(int mesInserido) {
        clicar(textoMesRenda);
        Integer obterMes = (localDate.getMonthValue() + mesInserido);
        escrever(textoMesRenda, obterMes.toString());
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
        Integer anoInserido = localDate.getYear();
        escrever(textoAnoRenda, anoInserido.toString());
        return this;
    }

    public void deletarRenda() {
        clicar(botaoApagar);
        esperaAceitarAlert();
    }

    }

