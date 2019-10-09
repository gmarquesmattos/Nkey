package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.pessoa.ContaCorrentePage;
import pageObjects.resumo.SolucoesFinanceirasPage;

import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasTest extends BaseTest {



    @Test
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePage() {

        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage(driver);
        String contaPrincipalAssociado = solucoesFinanceirasPage.obterContaPrincipal();
        solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();

        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage(driver);
        String contaAssociado = contaCorrentePFPage.obterNumeroConta();

        assertEquals(contaPrincipalAssociado,contaAssociado);
    }

}
