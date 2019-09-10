


package testcases.RegraNegocio.CenariosNegativo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Retaguarda.RetaguardaPO;

import java.time.LocalDate;

public class CenarioNegativoTest extends BaseTest {


    @Test
    public void naoDeveSalvarComMesMaiorQueAtual() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.acessarCadastroCanais();
        retaguardaPO.preencherCooperativa();
        retaguardaPO.editarAtendimento();
        retaguardaPO.alterarRenda();
        retaguardaPO.textValidacao("O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)");

    }

    @Test
    public void naoDeveSalvarNaoFinalizado() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.acessarCadastroCanais();
        retaguardaPO.preencherCooperativa();
        retaguardaPO.editarAtendimento();
        retaguardaPO.anoNaofinalizado();
        retaguardaPO.textValidacao("Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)");
    }
}

