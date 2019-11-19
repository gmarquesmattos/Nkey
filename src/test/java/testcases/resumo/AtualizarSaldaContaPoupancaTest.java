package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.SolucoesFinanceirasPage;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.testng.AssertJUnit.assertEquals;


public class AtualizarSaldaContaPoupancaTest extends BaseTest {
    private LocalDate localDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test(retryAnalyzer = Retentativa.class, dataProvider = "numeroSolucao")
    public void deveCompararDataAtualComDataAtualizacaoSaldo(String numeroSolucao) {
        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage();
        solucoesFinanceirasPage.pesquisarSolucoesFinanceiras();
        solucoesFinanceirasPage.preencherNumeroSolucao(numeroSolucao);
        solucoesFinanceirasPage.preencherTipo();
        solucoesFinanceirasPage.clicarBotaoIr();
        solucoesFinanceirasPage.acessarNumerodaSolucao();
        solucoesFinanceirasPage.clicarBotaoAtualizarSaldo();
        solucoesFinanceirasPage.obterDataAtualizacaoSaldo();

        assertEquals(solucoesFinanceirasPage.obterDataAtualizacaoSaldo(),localDate.format(formatter));



    }


}
