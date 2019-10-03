package testcases.retaguarda.alterarRenda;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

import static org.testng.AssertJUnit.assertEquals;

public class AlterarRendaTest extends BaseTest {


    @Test
    public void deveriaEditarRenda() {
        new AlterarRendaPage(driver)
                .editar()
                .salvar()
                .excluirRenda();
    }

    @Test
    public void deveriaSalvarComMesMenorQueAtual() {
        int mesMenorQueAtual = -2;
        new AlterarRendaPage(driver)
                .editar()
                .insereMes(mesMenorQueAtual)
                .salvar()
                .excluirRenda();
    }

    @Test
    public void naoDeveSalvarComMesMaiorQueAtual() {
        int mesMaiorQueAtual = 2;
        String textoObtido = new AlterarRendaPage(driver)
                .editar()
                .insereMes(mesMaiorQueAtual)
                .salvar()
                .pegarMensagemJanelaDeErro();

        String textoEsperado = "O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)";
        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void naoDeveSalvarNaoFinalizado() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver)
                .editar()
                .insereAno()
                .salvar();
        String textoEsperado = "Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)";
        String textoObtido = alterarRendaPage.pegarMensagemJanelaDeErro();
        assertEquals(textoEsperado, textoObtido);
    }
}
