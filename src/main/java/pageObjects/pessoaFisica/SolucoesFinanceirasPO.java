package pageObjects.pessoaFisica;

import base.BasePage;
import org.openqa.selenium.By;

public class SolucoesFinanceirasPO extends BasePage {
	

	public void clicarLinkSaldoContaPrincipal() {
		
		clicar(By.id("s_2_1_32_0"));
	}
	
	public String obterContaPrincipal() {
		
		return obterTexto(By.id("s_2_1_12_0"));
	}
	

}
