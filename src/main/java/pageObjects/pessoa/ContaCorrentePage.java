package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContaCorrentePage extends BasePage {


    private By textoNrConta = By.name("s_1_1_18_0");

    public ContaCorrentePage(WebDriver driver) {

        super(driver);
    }

    public String obterNumeroConta() {

        return obterValueElemento(textoNrConta);

    }

}
