package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.home.HomePage;
import pageObjects.pessoa.ContaCorrentePage;
import pageObjects.pessoa.PessoaFisicaPage;
import pageObjects.pessoa.SolucoesFinanceirasPage;

import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasTest extends BaseTest {

    @Test
    public void testLinkSaldoContaPrincipalPF() {

        HomePage pessoaFisica = new HomePage(driver);

        pessoaFisica.acessarPessoaFisica();

        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage(driver);
       new PessoaFisicaPage(driver);


        solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();
        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage(driver);
        assertEquals(solucoesFinanceirasPage.obterContaPrincipal().substring(1, 7), contaCorrentePFPage.obterNumeroConta());
    }

}
