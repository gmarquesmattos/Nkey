package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;

public class BarraBotoesTelaRelacionamento extends BasePage {
    private By linkEsteiraPS = By.cssSelector("#S_A14_tile_2");
    private By botaoNovoContato =By.cssSelector("#S_A14_tile_3");
    private By botaoNovoContatoAtendimento =By.cssSelector("#BtnAtendimento");

    public BarraBotoesTelaRelacionamento clicarLinkEsteiraPS() {
        clicarJavaScript(linkEsteiraPS);
        return this;
    }

    public BarraBotoesTelaRelacionamento criarNovoContatoAtendimento(){
        clicar(botaoNovoContato);
        clicar(botaoNovoContatoAtendimento);
        return this;
    }
}
