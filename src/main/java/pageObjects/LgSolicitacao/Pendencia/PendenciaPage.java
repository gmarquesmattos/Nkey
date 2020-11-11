package pageObjects.LgSolicitacao.Pendencia;

import base.BasePage;
import org.openqa.selenium.By;

public class PendenciaPage extends BasePage {
    private By textoMinhasPendencias = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/fieldset[1]/legend[1]");


    public String getTextoMinhasPendencias() {

        System.out.println(obterTexto(textoMinhasPendencias));
        return obterTexto(textoMinhasPendencias);

    }


}
