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
        alterarRendaPage.apagarRenda();
    }

    @Test
    public void deveriaSalvarComMesMenorQueAtual() {
        int mes = -2;
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.acessar();
        alterarRendaPage.editar();
        alterarRendaPage.insereMes(mes);
        alterarRendaPage.salvar();
        alterarRendaPage.apagarRenda();
    }

    @Test
    public void naoDeveSalvarComMesMaiorQueAtual() {
        int mes = 2;
        String textoEsperado = "O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)";
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.acessar();
        alterarRendaPage.editar();
        alterarRendaPage.insereMes(mes);
        alterarRendaPage.salvar();
        String textoObtido = alterarRendaPage.pegarMensagemJanelaDeErro();
        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void naoDeveSalvarNaoFinalizado() {
        String textoEsperado = "Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)";
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage.acessar();
        alterarRendaPage.editar();
        alterarRendaPage.insereAno();
        alterarRendaPage.salvar();
        String textoObtido = alterarRendaPage.pegarMensagemJanelaDeErro();
        assertEquals(textoEsperado, textoObtido);
    }
}
