package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.pessoa.ContaCorrentePage;
import pageObjects.resumo.SolucoesFinanceirasTelaRelacionamentoPessoaFisicaPage;
import java.util.ArrayList;


public class SolucoesFinanceirasTelaRelacionamentoPessoaFisicaTest extends BaseTest {


    @Test//(retryAnalyzer = Retentativa.class)
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePage() {
        SolucoesFinanceirasTelaRelacionamentoPessoaFisicaPage solucoesFinanceirasTelaRelacionamentoPessoaFisicaPage = new SolucoesFinanceirasTelaRelacionamentoPessoaFisicaPage();
        solucoesFinanceirasTelaRelacionamentoPessoaFisicaPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        ArrayList<String>dadosContaPrincipal = solucoesFinanceirasTelaRelacionamentoPessoaFisicaPage.obterDadosContaPrincipalAssociado();
        solucoesFinanceirasTelaRelacionamentoPessoaFisicaPage.clicarLinkSaldoContaPrincipal();

        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage();
        ArrayList<String> dadosContaSolucoesFinanceiras = contaCorrentePFPage.obterDadosContaSolucoesFinanceirasAssociado();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEqualsNoOrder(dadosContaPrincipal.toArray(),dadosContaSolucoesFinanceiras.toArray());

        softAssert.assertAll();

    }

}
