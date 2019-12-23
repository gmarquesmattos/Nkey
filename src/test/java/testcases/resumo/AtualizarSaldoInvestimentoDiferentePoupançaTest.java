package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.SolucoesFinanceirasPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.testng.AssertJUnit.assertEquals;

public class AtualizarSaldoInvestimentoDiferentePoupançaTest extends BaseTest {



    @Test//(retryAnalyzer = Retentativa.class)
    public void deveCompararDataAtualComDataAtualizacaoSaldo() {
        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage();
        solucoesFinanceirasPage.pesquisarSolucoesFinanceiras();
        solucoesFinanceirasPage.preencherNumeroSolucao(NUMERO_ATIVO_INVESTIMENTO);
        solucoesFinanceirasPage.clicarBotaoIr();
        solucoesFinanceirasPage.acessarNumerodaSolucao();
        solucoesFinanceirasPage.clicarBotaoAtualizarSaldo();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataAtualizacao = solucoesFinanceirasPage.obterDataAtualizacaoSaldoLca();
        String dataAtual = localDate.format(formatter);

        assertEquals(dataAtual,dataAtualizacao );

    }
}