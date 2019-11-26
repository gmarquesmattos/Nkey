package pageObjects.digital;

import base.BasePage;
import org.openqa.selenium.By;


public class RecomendaDadosBasicosPage extends BasePage {
    private By textoRecomendarDadosbasicos = By.cssSelector("div[class='siebui-applet-taskui-h']");

       public String mensagemPaginaRecomendaDadosBasicos() {
        return obterTexto(textoRecomendarDadosbasicos);
    }
}
