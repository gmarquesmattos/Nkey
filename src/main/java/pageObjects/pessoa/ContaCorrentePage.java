package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;

public class ContaCorrentePage extends BasePage {

    private By textoNumeroConta = By.cssSelector("input[aria-label='Nº da conta']");

    public ContaCorrentePage() {

    }

    public String obterNumeroConta() {
        return obterValueElemento(textoNumeroConta);
    }

}
