package testcases.retaguarda.alterarRenda;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.RetaguardaPage;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

public class AlterarRendaTest extends BaseTest {

    @Test
    public void deveriaEditarRenda() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage
                .editarAlterarRenda();
    }

    @Test
    public void deveriaSalvarComMesMenorQueAtual() {
        new AlterarRendaPage(driver)
                .alterarRendaValidaAnoMes(-2);

    }


    @Test
    public void naoDeveSalvarRendaMesAnoMaiorAtual() {
        new AlterarRendaPage(driver)
                .naoSalvaraRendaMesAnoMaiorAtual(2,"O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)","O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)");

    }

    @Test
    public void naoDeveSalvarNaoFinalizado() {
        new AlterarRendaPage(driver)
       .anoNaofinalizado("Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)","Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)");

    }


}
