package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;

public class FrameInvestimentosPosicaoConsolidadaPage extends BasePage {

    private By textoNumeroTituloInvestimentos = By.xpath("//tr[@class= 'ui-widget-content ui-datatable-even ui-datatable-selectable']/td/span");

    public void acessarFrameInvestimentos(){
        acessarFrame();
    }

    public String obterNumeroTitulo(){
    return   obterTexto(textoNumeroTituloInvestimentos);
    }
}
