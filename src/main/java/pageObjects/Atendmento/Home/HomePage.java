package pageObjects.Atendmento.Home;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By menuSolicitacao = By.id("portal");
    private By menuServico = By.id("optService");
    private By botaoOK = By.id("btnProcessar");
    private By tituloPagina = By.id("left-sidebar-title-text");
    private By titulorodape = By.cssSelector("tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) font.COLORLABEL > span:nth-child(1)");


    public void clicarMenuServico() {
        clicar(menuServico);


    }

    public void clicarMenuSolicitacao() {
        clicar(menuSolicitacao);


    }

    public String getTituliPagina() {
        return obterTexto(tituloPagina);
    }


    public String getRodapePagina() {
        acessarFrame2();
        System.out.println(obterTexto(titulorodape));
        return obterTexto(titulorodape);
    }
}
