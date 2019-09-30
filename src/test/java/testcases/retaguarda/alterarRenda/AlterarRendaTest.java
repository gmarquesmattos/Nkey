package testcases.retaguarda.alterarRenda;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

import static org.testng.AssertJUnit.assertEquals;

public class AlterarRendaTest extends BaseTest {

    @Test
    public void deveriaEditarRenda() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.acessar();
        alterarRendaPage.editar();
        alterarRendaPage.salvar();
    }

    @Test
    public void deveriaSalvarComMesMenorQueAtual() {

        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.acessar();
        alterarRendaPage.editar();
        alterarRendaPage.insereMes(-2);
        alterarRendaPage.salvar();
    }

    @Test
    public void naoDeveSalvarComMesMaiorQueAtual() {
        String textoEsperado = "O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)";

        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        String textoObtido = alterarRendaPage.validaAnoMaiorQueAtual();

        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void naoDeveSalvarNaoFinalizado() {
        String textoEsperado = "Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)";
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        String textoObtido = alterarRendaPage.anoNaofinalizado();
        assertEquals(textoEsperado, textoObtido);
    }
}
