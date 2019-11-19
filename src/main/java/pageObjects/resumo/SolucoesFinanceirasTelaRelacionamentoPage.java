package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class SolucoesFinanceirasTelaRelacionamentoPage extends BasePage {

	private By linkSaldoContaPrincipal = By.id("s_2_1_32_0");
	private By rotuloContaPrincipal = By.id("s_2_1_12_0");

	public SolucoesFinanceirasTelaRelacionamentoPage() {
		acessar();
	}

	public void pesquisarPessoaFisica(String cpf) {
		new PessoaFisicaPage(cpf).acessarNomeCompleto();
	}

	public void clicarLinkSaldoContaPrincipal() {
		clicar(linkSaldoContaPrincipal);
	}
	
	public String obterContaPrincipal() {
		return obterTexto(rotuloContaPrincipal).substring(1, 7);
	}

	private void acessar(){
		HomePage homePage = new HomePage();
		homePage.acessarPessoaFisica();
	}

}
