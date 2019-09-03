package testcases.Regressao;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.home.MenuLateralPO;
import pageObjects.pessoaFisica.ContaCorrentePFPO;
import pageObjects.pessoaFisica.PessoaFisicaPO;
import pageObjects.pessoaFisica.SolucoesFinanceirasPO;

import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasTest extends BaseTest {

    @Test
    public void testLinkSaldoContaPrincipalPF() {
        realizarLogin();
        MenuLateralPO menuLateralPage = new MenuLateralPO();
        menuLateralPage.acessarPessoaFisica();

		PessoaFisicaPO pessoaFisicaPage = new PessoaFisicaPO();
        pessoaFisicaPage.pesquisar();
        pessoaFisicaPage.drillNomeCompleto();

		SolucoesFinanceirasPO solucoesFinanceirasPage = new SolucoesFinanceirasPO();
        solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();

		ContaCorrentePFPO contaCorrentePFPage = new ContaCorrentePFPO();
        String teste = contaCorrentePFPage.obterNumeroConta();
        System.out.println(teste);
        assertEquals(solucoesFinanceirasPage.obterContaPrincipal().substring(1, 7), contaCorrentePFPage.obterNumeroConta());


    }


}
