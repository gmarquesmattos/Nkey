package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SolucoesFinanceirasPage extends BasePage {

	private By linkSaldoContaPrincipal = By.id("s_2_1_32_0");
	private By rotuloContaPrincipal = By.id("s_2_1_12_0");

	public SolucoesFinanceirasPage(WebDriver driver) {
		super(driver);

		}

	public void clicarLinkSaldoContaPrincipal() {
		
		clicar(linkSaldoContaPrincipal);
	}
	
	public String obterContaPrincipal() {
		
		return obterTexto(rotuloContaPrincipal);
	}
	

}
