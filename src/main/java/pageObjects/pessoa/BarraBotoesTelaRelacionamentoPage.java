package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;

public class BarraBotoesTelaRelacionamentoPage extends BasePage {
    private By linkEsteiraPS = By.cssSelector("#S_A14_tile_2");
    private By botaoNovoContato =By.cssSelector("#S_A14_tile_3");
    private By botaoNovoContatoAtendimento =By.cssSelector("#BtnAtendimento");

    public BarraBotoesTelaRelacionamentoPage clicarLinkEsteiraPS() {
        clicarJavaScript(linkEsteiraPS);
        return this;
    }

    public BarraBotoesTelaRelacionamentoPage criarNovoContatoAtendimento(){
        clicar(botaoNovoContato);
        clicar(botaoNovoContatoAtendimento);
        return this;
    }
}
