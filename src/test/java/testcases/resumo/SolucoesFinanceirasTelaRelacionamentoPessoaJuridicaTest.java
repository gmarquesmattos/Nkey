package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.pessoa.ContaCorrentePage;
import pageObjects.resumo.SolucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage;
import java.util.ArrayList;


public class SolucoesFinanceirasTelaRelacionamentoPessoaJuridicaTest extends BaseTest {
    
    @Test//(retryAnalyzer = Retentativa.class)
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePJPage() {
        SolucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage solucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage = new SolucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage();
        solucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage.pesquisarPessoaJuridica(CNPJ_SOLUCOES_0718);
        ArrayList<String> dadosContaPrincipal = solucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage.obterDadosContaPrincipalAssociado();
        solucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage.clicarLinkSaldoContaPrincipal();

        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage();
        ArrayList<String>dadosContaSolucoesFinanceiras = contaCorrentePFPage.obterDadosContaSolucoesFinanceirasAssociado();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEqualsNoOrder(dadosContaPrincipal.toArray(), dadosContaSolucoesFinanceiras.toArray());

        softAssert.assertAll();


    }

}
