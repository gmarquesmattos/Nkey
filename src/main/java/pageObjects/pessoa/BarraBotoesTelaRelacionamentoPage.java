package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;

public class BarraBotoesTelaRelacionamentoPage extends BasePage {

    private By linkEsteiraPS = By.cssSelector("#S_A14_tile_2");
    private By botaoNovoContato =By.cssSelector("#S_A14_tile_3");
    private By botaoNovoContatoAtendimento =By.cssSelector("#BtnAtendimento");
    private By botaoNovaOportunidade =By.cssSelector("#BtnOportunidade");
    private By botaoNovaAtividade =By.cssSelector("#BtnAtividade");

    public void  clicarLinkEsteiraPS() {
        clicarJavaScript(linkEsteiraPS);
    }

    public void criarNovoContatoAtendimento(){
        clicar(botaoNovoContato);
        clicar(botaoNovoContatoAtendimento);
    }

    public void criarNovoContatoOportunidade(){
        clicar(botaoNovoContato);
        clicar(botaoNovaOportunidade);
    }

    public void criarNovoContatoAtividade(){
        clicar(botaoNovoContato);
        clicar(botaoNovaAtividade);
    }
}
