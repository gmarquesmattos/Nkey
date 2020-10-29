package pageObjects.Atendmento.LogExecucaoEtapas;

import base.BasePage;
import org.openqa.selenium.By;

public class LogExecucaoEtapaPage extends BasePage {
    private By textoLogAlteracaoEtapa = By.id("divReplyLog");
    private By botaoFechar = By.id("btnCloseWindow2");

public String getTextoTrocaEtapa(){

  //  acessarFrame2();
    System.out.println("@@@@@@@@" + obterTexto(textoLogAlteracaoEtapa));
    return obterTexto(textoLogAlteracaoEtapa);
}

public void fecharPagLog(){

    clicar(botaoFechar);
}


}
