package testcases.regraNegocio.cenariosNegativo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.RetaguardaPage;

public class CenarioNegativoTest extends BaseTest {

    @Test
    public void naoDeveSalvarComMesMaiorQueAtual() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.acessarCadastroCanais();
        retaguardaPage.preencherCooperativa();
        retaguardaPage.editarAtendimento();
        retaguardaPage.alterarRenda();
        retaguardaPage.textValidacao("O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)");
    }

    @Test
    public void naoDeveSalvarNaoFinalizado() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.acessarCadastroCanais();
        retaguardaPage.preencherCooperativa();
        retaguardaPage.editarAtendimento();
        retaguardaPage.anoNaofinalizado();
        retaguardaPage.textValidacao("Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)");
    }
}

