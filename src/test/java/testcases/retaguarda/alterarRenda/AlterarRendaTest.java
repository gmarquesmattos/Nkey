package testcases.retaguarda.alterarRenda;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

import static org.testng.AssertJUnit.assertEquals;

public class AlterarRendaTest extends BaseTest {


     @Test(retryAnalyzer = Retentativa.class)
    public void deveEditarRenda() {
        new AlterarRendaPage()
                .editar()
                .salvar()
                .excluirRenda();
    }

    @Test(retryAnalyzer = Retentativa.class)
    public void deveSalvarComMesMenorQueAtual() {
        int mesMenorQueAtual = -2;
        new AlterarRendaPage()
                .editar()
                .insereMes(mesMenorQueAtual)
                .salvar()
                .excluirRenda();
    }

    @Test(retryAnalyzer = Retentativa.class)
    public void naoDeveSalvarComMesMaiorQueAtual() {
        int mesMaiorQueAtual = 1;
        String textoObtido = new AlterarRendaPage()
                .editar()
                .insereMes(mesMaiorQueAtual)
                .salvar()
                .pegarMensagemJanelaDeErro();

        String textoEsperado = "O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test(retryAnalyzer = Retentativa.class)
    public void naoDeveSalvarNaoFinalizado() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage()
                .editar()
                .insereAno()
                .salvar();

        String textoEsperado = "Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)";
        String textoObtido = alterarRendaPage.pegarMensagemJanelaDeErro();

        assertEquals(textoEsperado, textoObtido);
    }
}
