package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContaCorrentePFPO extends BasePage {

    public ContaCorrentePFPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.NAME, using = "s_1_1_17_0")
    WebElement numeroConta;

    public String obterNumeroConta() {
        return numeroConta.getAttribute("value");
    }

}
