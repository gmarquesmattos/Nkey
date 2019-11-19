package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.ContaCorrentePage;

import pageObjects.resumo.SolucoesFinanceirasPjTelaRelacionamentoPage;

import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasPJTest extends BaseTest {
    @Test(dataProvider = "cnpjSolucaoFinanceiraCoop0718", retryAnalyzer = Retentativa.class)
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePJPage(String cnpj) {
        SolucoesFinanceirasPjTelaRelacionamentoPage solucoesFinanceirasPjTelaRelacionamentoPage = new SolucoesFinanceirasPjTelaRelacionamentoPage(cnpj);
        String contaPrincipalAssociado = solucoesFinanceirasPjTelaRelacionamentoPage.obterContaPrincipal();
        solucoesFinanceirasPjTelaRelacionamentoPage.clicarLinkSaldoContaPrincipal();
        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage();

        assertEquals(contaPrincipalAssociado, contaCorrentePFPage.obterNumeroConta());

    }

}
