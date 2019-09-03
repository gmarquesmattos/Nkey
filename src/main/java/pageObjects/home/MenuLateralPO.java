package pageObjects.home;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class MenuLateralPO extends BasePage {

	public MenuLateralPO() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public void acessarPessoaFisica() {
						
		clicar(By.xpath("//button[@class='siebui-nav-hb-btn siebui-display']"));
		clicar(By.id("ui-id-99"));

	}

	public void acessarPessoaJuridica() {

	}

}
