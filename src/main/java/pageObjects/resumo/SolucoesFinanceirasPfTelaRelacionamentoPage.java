package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

import java.util.ArrayList;

public class SolucoesFinanceirasPfTelaRelacionamentoPage extends BasePage {

	private By linkSaldoContaPrincipal = By.id("s_2_1_32_0");
	private By rotuloContaPrincipal = By.id("s_2_1_12_0");

	public SolucoesFinanceirasPfTelaRelacionamentoPage() {
		acessar();
	}

	public void pesquisarPessoaFisica(String cpf) {
		new PessoaFisicaPage(cpf).acessarNomeCompleto();
	}

	public void clicarLinkSaldoContaPrincipal() {
		clicar(linkSaldoContaPrincipal);
	}

	public ArrayList<String> obterDadosContaPrincipalAssociado(){
		ArrayList<String>dadosContaPrincipalAssociado = new ArrayList<>();
		dadosContaPrincipalAssociado.add(obterTexto(rotuloContaPrincipal).substring(1, 7));
		dadosContaPrincipalAssociado.add(obterTexto(rotuloContaPrincipal).substring(9,17).toLowerCase());
		return dadosContaPrincipalAssociado;
	}

	private void acessar(){
		HomePage homePage = new HomePage();
		homePage.acessarPessoaFisica();
	}

}
