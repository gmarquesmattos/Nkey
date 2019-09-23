package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaCorrentePage extends BasePage {


    private By textoNrConta = By.name("s_1_1_17_0");

    public ContaCorrentePage(WebDriver driver) {
        super(driver);
    }


    public String obterNumeroConta() {
        return obterValueElemento(textoNrConta);

    }

}
