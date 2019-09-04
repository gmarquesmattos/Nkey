package pageObjects.pessoaFisica;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContaCorrentePFPO extends BasePage {

	public ContaCorrentePFPO() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	@FindBy(how = How.NAME, using = "s_1_1_17_0")
	WebElement numeroConta;

	public String obterNumeroConta() {
		return numeroConta.getAttribute("value");
	}

}
