package pageObjects.pessoaFisica;

import base.BasePage;
import org.openqa.selenium.By;

public class ContaCorrentePFPO extends BasePage {
	
	public String obterNumeroConta() {
		
		String teste = obterValueElemento("s_1_1_17_0");
		System.out.println(teste);
		return obterTexto(By.name("s_1_1_17_0"));
	}

}
