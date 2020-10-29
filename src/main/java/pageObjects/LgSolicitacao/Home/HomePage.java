package pageObjects.LgSolicitacao.Home;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage  extends BasePage {
    private By textoUsuarioLogado = By.id("navbar-user-name");



    public String getTextoUsuariologado(){

        System.out.println("@#$$$$$ "+ obterTexto(textoUsuarioLogado));
         return  obterTexto(textoUsuarioLogado);

    }



}
