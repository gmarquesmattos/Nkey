package pageObjects.home;

import base.BasePage;
import org.openqa.selenium.By;

public class MenuLateralPO extends BasePage {
	


	public void acessarPessoaFisica() {		
						
		clicar(By.xpath("//button[@class='siebui-nav-hb-btn siebui-display']"));
		clicar(By.id("ui-id-99"));

	}

	public void acessarPessoaJuridica() {

	}

}
