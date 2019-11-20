package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.pessoa.ContaCorrentePage;


import pageObjects.resumo.SolucoesFinanceirasPjPage;

import java.util.ArrayList;



public class SolucoesFinanceirasPJTest extends BaseTest {
    @Test(dataProvider = "cnpjSolucaoFinanceiraCoop0718", retryAnalyzer = Retentativa.class)
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePJPage(String cnpj) {
        SolucoesFinanceirasPjPage solucoesFinanceirasPjPage = new SolucoesFinanceirasPjPage();
        solucoesFinanceirasPjPage.pesquisarPessoaJuridica(cnpj);
        ArrayList<String> dadosContaPrincipal = solucoesFinanceirasPjPage.obterDadosContaPrincipalAssociado();
        solucoesFinanceirasPjPage.clicarLinkSaldoContaPrincipal();

        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage();
        ArrayList<String>dadosContaSolucoesFinanceiras = contaCorrentePFPage.obterDadosContaSolucoesFinanceirasAssociado();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEqualsNoOrder(dadosContaPrincipal.toArray(), dadosContaSolucoesFinanceiras.toArray());

        softAssert.assertAll();

    }

}
