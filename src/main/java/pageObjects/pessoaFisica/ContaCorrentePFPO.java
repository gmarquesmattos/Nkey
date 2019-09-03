package pageObjects.pessoaFisica;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContaCorrentePFPO extends BasePage {
	@FindBy(name = "s_1_1_17_0")
	WebElement numeroConta;

	public String obterNumeroConta() {
		return numeroConta.getAttribute("value");
	}

}
