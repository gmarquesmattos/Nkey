package pageObjects.retaguarda.rendaEnviada;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RendaEnviadaPage extends BasePage {

    private By textoTipoRendaEnv = By.name("s_2_1_3_0");

    public RendaEnviadaPage(WebDriver driver) {
        super(driver);
    }

    public String obterTipo() {

        return obterValueElemento(textoTipoRendaEnv);
    }

}
