package pageObjects.retaguarda.rendaEnviada;

import base.BasePage;
import org.openqa.selenium.By;

public class RendaEnviadaPage extends BasePage {

    private By textoTipoRendaEnv = By.name("s_2_1_3_0");

    public RendaEnviadaPage() {

    }

    public String obterTipo() {

        return obterValueElemento(textoTipoRendaEnv);
    }

}
