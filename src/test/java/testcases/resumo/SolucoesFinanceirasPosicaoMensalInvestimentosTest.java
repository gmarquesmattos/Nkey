package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.pessoa.FrameInvestimentosPosicaoConsolidadaPage;
import pageObjects.pessoa.SolucoesFinanceirasPage;

import static org.testng.Assert.assertEquals;

public class SolucoesFinanceirasPosicaoMensalInvestimentosTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void  deveConsultarPaginaJavaPosicaoMensalInvestimentos(){

        SolucoesFinanceirasPage solucoesFinanceirasPage = new SolucoesFinanceirasPage();
        FrameInvestimentosPosicaoConsolidadaPage frameSolucoesFinanceirasPage = new FrameInvestimentosPosicaoConsolidadaPage();
        solucoesFinanceirasPage.pesquisarSolucoesFinanceiras();
        solucoesFinanceirasPage.preencherNumeroSolucao(NUMERO_ATIVO_INVESTIMENTO);
        solucoesFinanceirasPage.clicarBotaoIr();
        solucoesFinanceirasPage.acessarNumerodaSolucao();
        frameSolucoesFinanceirasPage.acessarFrameInvestimentos();
        String numeroTitulo = frameSolucoesFinanceirasPage.obterNumeroTitulo();
        assertEquals(numeroTitulo,"1801506988-9");


    }
}
