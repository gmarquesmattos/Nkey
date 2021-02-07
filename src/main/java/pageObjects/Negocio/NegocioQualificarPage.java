package pageObjects.Negocio;

import base.BasePage;
import org.openqa.selenium.By;

public class NegocioQualificarPage extends BasePage {
    private By botaoQualificar = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[11]/div[1]/div[1]/div[2]/div[1]/button[1]/span[1]");

    public void clicarBotaoQualificar() {
        clicar(botaoQualificar);


    }


}
