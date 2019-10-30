package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaCorrentePage extends BasePage {

    private By textoNumeroConta = By.cssSelector("input[aria-label='Nº da conta']");

    public ContaCorrentePage(WebDriver driver) {
        super(driver);
    }

    public String obterNumeroConta() {
        return obterValueElemento(textoNumeroConta);
    }

}
