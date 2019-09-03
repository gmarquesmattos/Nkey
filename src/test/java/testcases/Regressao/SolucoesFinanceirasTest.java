package testcases.Regressao;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.home.MenuLateralPO;
import pageObjects.pessoaFisica.ContaCorrentePFPO;
import pageObjects.pessoaFisica.PessoaFisicaPO;
import pageObjects.pessoaFisica.SolucoesFinanceirasPO;

import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasTest extends BaseTest {
	
	private MenuLateralPO menuLateralPage = new MenuLateralPO();
//	private PessoaFisicaPO pessoaFisicaPage = new PessoaFisicaPO();
//	private SolucoesFinanceirasPO solucoesFinanceirasPage = new SolucoesFinanceirasPO();
//	private ContaCorrentePFPO contaCorrentePFPage = new ContaCorrentePFPO();
	
	@Test
	public void testLinkSaldoContaPrincipalPF() {
		menuLateralPage.acessarPessoaFisica();
//		pessoaFisicaPage.pesquisar();
//		pessoaFisicaPage.drillNomeCompleto();
//		solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();
//		String teste=contaCorrentePFPage.obterNumeroConta();
//		System.out.println(teste);
//		//assertEquals(solucoesFinanceirasPage.obterContaPrincipal().substring(1, 7), contaCorrentePFPage.obterNumeroConta()); ;
//
	}
		

}
