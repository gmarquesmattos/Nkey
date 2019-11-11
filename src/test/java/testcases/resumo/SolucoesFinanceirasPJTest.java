package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.ContaCorrentePage;

import pageObjects.resumo.SolucoesFinanceirasPage;
import pageObjects.resumo.SolucoesFinanceirasPjPage;

import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasPJTest extends BaseTest {
    @Test(dataProvider = "cnpjSolucaoFinanceiraCoop0718", retryAnalyzer = Retentativa.class)
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePJPage(String cnpj) {
        SolucoesFinanceirasPjPage solucoesFinanceirasPjPage = new SolucoesFinanceirasPjPage();
        solucoesFinanceirasPjPage.pesquisarPessoaJuridica(cnpj);
        String contaPrincipalAssociado = solucoesFinanceirasPjPage.obterContaPrincipal();
        String tipoContaPrincipalAssociado = solucoesFinanceirasPjPage.obterTipoContaPrincipal();
        solucoesFinanceirasPjPage.clicarLinkSaldoContaPrincipal();

        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage();
        String contaAssociado = contaCorrentePFPage.obterNumeroConta();
        String tipoContaAssociado = contaCorrentePFPage.obterTipoConta();

        assertEquals(contaPrincipalAssociado, contaAssociado);
        assertEquals(tipoContaPrincipalAssociado,tipoContaAssociado);

    }

}
