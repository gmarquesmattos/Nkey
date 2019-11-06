package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.ContaCorrentePage;
import pageObjects.resumo.SolucoesFinanceirasPage;
import static org.testng.AssertJUnit.assertEquals;

public class SolucoesFinanceirasTest extends BaseTest {


    @Test(retryAnalyzer = Retentativa.class, dataProvider = "cpfResumo")
    public void deveCompararContaDaPaginaSolucoesFinanceirasComContaCorrentePage(String cpf) {
        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage(driver);
        solucoesFinanceirasPage.pesquisarPessoaFisica(cpf);
        String contaPrincipalAssociado = solucoesFinanceirasPage.obterContaPrincipal();
        solucoesFinanceirasPage.clicarLinkSaldoContaPrincipal();

        ContaCorrentePage contaCorrentePFPage = new ContaCorrentePage(driver);
        String contaAssociado = contaCorrentePFPage.obterNumeroConta();

        assertEquals(contaPrincipalAssociado, contaAssociado);
    }

}
