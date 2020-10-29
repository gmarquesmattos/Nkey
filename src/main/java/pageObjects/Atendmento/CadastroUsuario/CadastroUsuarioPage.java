package pageObjects.Atendmento.CadastroUsuario;

import base.BasePage;
import org.openqa.selenium.By;

public class CadastroUsuarioPage extends BasePage {
    private By tituloPagina = (By.id("title"));

    public String getTituloPagina() {
        SelectPopUpService();
        System.out.println("!@#$% " + obterTexto(tituloPagina));
        return obterTexto(tituloPagina);

    }

}
