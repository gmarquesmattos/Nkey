package pageObjects.retaguarda.rendaEnviada;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RendaEnviadaPage extends BasePage {

    private By textoTipoRendaEnv = By.name("s_2_1_3_0");
    private By textoAnoRendaEnv = By.name("s_2_1_0_0");
    private By textoMesRendaEnv = By.name("s_2_1_1_0");

    public RendaEnviadaPage(WebDriver driver) {
        super(driver);
    }

    public By tipoRendaEnviada() {return textoTipoRendaEnv;}

    public By anoRendaEnviada() {return textoAnoRendaEnv;}

    public By mesRendaEnviada() {return textoMesRendaEnv;}


}