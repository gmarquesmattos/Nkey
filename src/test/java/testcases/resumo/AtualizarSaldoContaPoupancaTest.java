package testcases.resumo;

import base.BaseTest;
import base.DataUtil;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.SolucoesFinanceirasPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.testng.AssertJUnit.assertEquals;


public class AtualizarSaldoContaPoupancaTest extends BaseTest {


    @Test(retryAnalyzer = Retentativa.class)
    public void deveCompararDataAtualComDataAtualizacaoSaldo() {
        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage();
        solucoesFinanceirasPage.pesquisarSolucoesFinanceiras();
        solucoesFinanceirasPage.preencherNumeroSolucao(CONTA_0718);
        solucoesFinanceirasPage.preencherTipo();
        solucoesFinanceirasPage.clicarBotaoIr();
        solucoesFinanceirasPage.acessarNumerodaSolucao();
        solucoesFinanceirasPage.clicarBotaoAtualizarSaldo();

        String dataAtualizacao = solucoesFinanceirasPage.obterDataAtualizacaoSaldoPoupanca();
        DataUtil dataUtil = new DataUtil();

        assertEquals(dataUtil.ObterDataAtual(), dataAtualizacao);


    }


}
