package testcases.resumo;

import base.BaseTest;
import base.DataUtil;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.SolucoesFinanceirasPage;
import static org.testng.AssertJUnit.assertEquals;

public class AtualizarSaldoInvestimentoDiferentePoupancaTest extends BaseTest {



    @Test(retryAnalyzer = Retentativa.class)
    public void deveCompararDataAtualComDataAtualizacaoSaldo() {
        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage();
        solucoesFinanceirasPage.pesquisarSolucoesFinanceiras();
        solucoesFinanceirasPage.preencherNumeroSolucao(NUMERO_ATIVO_INVESTIMENTO);
        solucoesFinanceirasPage.clicarBotaoIr();
        solucoesFinanceirasPage.acessarNumerodaSolucao();
        solucoesFinanceirasPage.clicarBotaoAtualizarSaldo();

        String dataAtualizacao = solucoesFinanceirasPage.obterDataAtualizacaoSaldo();
        DataUtil dataUtil = new DataUtil();

        assertEquals(dataUtil.ObterDataAtual(),dataAtualizacao);

    }
}