package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.home.HomePage;
import pageObjects.pessoa.ContaCorrentePFPO;
import pageObjects.pessoa.PessoaFisicaPage;
import pageObjects.pessoa.SolucoesFinanceirasPO;

import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasTest extends BaseTest {

    @Test
    public void testLinkSaldoContaPrincipalPF() {

        HomePage pessoaFisica = new HomePage(driver);
        SolucoesFinanceirasPO solucoesFinanceirasPage = new SolucoesFinanceirasPO(driver);
        PessoaFisicaPage pessoaFisicaPage = new PessoaFisicaPage(driver);
        pessoaFisica.acessarPessoaFisica();
        pessoaFisicaPage.pesquisarPessoa().acessarNomeCompleto();
        solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();
        ContaCorrentePFPO contaCorrentePFPage = new ContaCorrentePFPO(driver);
        assertEquals(solucoesFinanceirasPage.obterContaPrincipal().substring(1, 7), contaCorrentePFPage.obterNumeroConta());
    }

}
