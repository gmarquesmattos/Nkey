package testcases.regressao;

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

       // realizarLogin();
        MenuLateralPO menuLateralPage = new MenuLateralPO(driver);
        SolucoesFinanceirasPO solucoesFinanceirasPage = new SolucoesFinanceirasPO(driver);
        PessoaFisicaPO pessoaFisicaPage = new PessoaFisicaPO(driver);
        menuLateralPage.acessarPessoaFisica();
        pessoaFisicaPage.pesquisar();
        pessoaFisicaPage.drillNomeCompleto();
        solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();
        ContaCorrentePFPO contaCorrentePFPage = new ContaCorrentePFPO(driver);
        assertEquals(solucoesFinanceirasPage.obterContaPrincipal().substring(1, 7), contaCorrentePFPage.obterNumeroConta());
    }

}
