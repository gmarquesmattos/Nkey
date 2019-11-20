package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.pessoa.ContaCorrentePage;
import pageObjects.resumo.SolucoesFinanceirasPage;
import java.util.ArrayList;



public class SolucoesFinanceirasTest extends BaseTest {


    @Test(retryAnalyzer = Retentativa.class, dataProvider = "cpfSolucaoFinanceiraCoop0718")
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePage(String cpf) {
        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage();
        solucoesFinanceirasPage.pesquisarPessoaFisica(cpf);
        ArrayList<String>dadosContaPrincipal = solucoesFinanceirasPage.obterDadosContaPrincipalAssociado();
        solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();

        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage();
        ArrayList<String>dadosContaSolucoesFinanceiras = contaCorrentePFPage.obterDadosContaSolucoesFinanceirasAssociado();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEqualsNoOrder(dadosContaPrincipal.toArray(), dadosContaSolucoesFinanceiras.toArray());

        softAssert.assertAll();
    }


}
