package pageObjects.retaguarda.alterarRenda;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.retaguarda.RetaguardaPage;
import utils.SeleniumUtil;

public class AlterarRendaPage extends BasePage {

public AlterarRendaPage(WebDriver driver)  {
    super(driver);
}
    private By botaoAssumirAtendimento = By.id("s_1_1_1_0_Ctrl");
    private By botaoEditar = By.id("s_3_1_13_0_Ctrl");
    private By botaoApagar = By.id("s_3_1_11_0_Ctrl");
    private By botaoPesquisarDetalhamento = By.id("s_5_1_10_0_Ctrl");
    private By botaoSalvarRenda = By.id("s_6_1_13_0_Ctrl");

    public AlterarRendaPage editarAlterarRenda() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage
                .acessarCadastroCanais()
                .preencherCooperativa()
                .obterValueElemento("s_2_1_3_0");

        return this;
    }

    public AlterarRendaPage editarAtendimento() {
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
        clicar(botaoEditar);
        clicar(botaoSalvarRenda);
        return this;
    }

    public AlterarRendaPage apagarRegistro() {
        clicar(botaoApagar);
        try {
            SeleniumUtil.esperaAlert();
        } catch (InterruptedException e) {
            LOGGER.error("Nâo esperou ou encontrou o ALERT.");
        }
        Alert alerta = DriverManager.getDriver().switchTo().alert();
        alerta.accept();
        return this;
   }
}
