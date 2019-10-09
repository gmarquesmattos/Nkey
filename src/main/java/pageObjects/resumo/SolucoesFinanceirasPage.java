package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

import java.util.concurrent.TimeUnit;

public class SolucoesFinanceirasPage extends BasePage {

	private By linkSaldoContaPrincipal = By.id("s_2_1_32_0");
	private By rotuloContaPrincipal = By.id("s_2_1_12_0");

	public SolucoesFinanceirasPage(WebDriver driver) {
		super(driver);
		acessar();
	}

	private SolucoesFinanceirasPage acessar(){
		HomePage homePage = new HomePage(driver);
		homePage.acessarPessoaFisica();
		new PessoaFisicaPage(driver);
		return this;
	}

	public void clicarLinkSaldoContaPrincipal() {
		clicar(linkSaldoContaPrincipal);
	}
	
	public String obterContaPrincipal() {
		return obterTexto(rotuloContaPrincipal).substring(1, 7);
	}
	

}
