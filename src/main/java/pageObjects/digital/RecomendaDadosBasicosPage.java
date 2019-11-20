package pageObjects.digital;

import base.BasePage;
import org.openqa.selenium.By;


public class RecomendaDadosBasicosPage extends BasePage {
    private By textoRecomenDadadosbasicos = By.cssSelector("div[class='siebui-applet-taskui-h']");

    public RecomendaDadosBasicosPage() {
        }

    public String mensagemPaginaRecomendaDadosBasicos() {
        return obterTexto(textoRecomenDadadosbasicos);
    }
}
