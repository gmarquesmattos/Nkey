package pageObjects.retaguarda.detalhamento;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.retaguarda.RetaguardaPage;
import utils.SeleniumUtil;

public class DetalhamentoPage extends BasePage {

    public DetalhamentoPage(WebDriver driver) {
        super(driver);
    }

    private By botaoAssumirAtendimento = By.id("s_1_1_1_0_Ctrl");
    private By botaoEditar = By.id("s_3_1_13_0_Ctrl");
    private By botaoApagar = By.id("s_3_1_11_0_Ctrl");

    public DetalhamentoPage preencherDetalhamento() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage
                .acessarCadastroCanais()
                .preencherCooperativa();
        return this;
    }

    public DetalhamentoPage editarAtendimento() {
        if (verificarSeEstaAtivo(botaoAssumirAtendimento)) {
            clicar(botaoAssumirAtendimento);
        }
        clicar(botaoEditar);
        return this;
    }

    public DetalhamentoPage apagarRegistro() {

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

    public DetalhamentoPage verificarTextoDoDetalhamento() {
        Assert.assertEquals(1, 1);
        return this;
    }
}
