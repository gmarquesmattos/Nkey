package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;

public class ContaCorrentePage extends BasePage {

    private By textoNumeroConta = By.cssSelector("input[aria-label='Nº da conta']");
    private By textoTipoConta = By.cssSelector("input[aria-label='Produto']");

    public ContaCorrentePage() {

    }

    public String obterNumeroConta() {
        return obterValorElemento(textoNumeroConta);
    }

    public String obterTipoConta(){
        return  obterValorElemento(textoTipoConta).substring(6,14);
    }

}
