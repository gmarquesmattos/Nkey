package pageObjects.digital;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecomendaDadosBasicosPage extends BasePage {
    private By textoRecomenDadadosbasicos = By.cssSelector("div[class='siebui-applet-taskui-h']");

    public RecomendaDadosBasicosPage(WebDriver driver) {
        super(driver);
    }

    public String mensagemPaginaRecomendaDadosBasicos() {
        return obterTexto(textoRecomenDadadosbasicos);
    }
}
