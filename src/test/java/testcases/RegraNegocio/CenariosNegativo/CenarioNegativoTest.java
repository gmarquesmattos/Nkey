


package testcases.RegraNegocio.CenariosNegativo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Retaguarda.RetaguardaPO;

public class CenarioNegativoTest extends BaseTest {
    @Test
    public void dataMaiorEnviada(){
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.acessarCadastroCanais();
        retaguardaPO.preencherCooperativa();
        retaguardaPO.editarAtendimento();
        retaguardaPO.alterarRenda(2019, 10);
        retaguardaPO.textValidacao("O periodo informado é maior que a data atual.(SBL-EXL-00151)(SBL-EXL-00151)");

    }
@Test
    public void anoNaoFinalizado(){
    realizarLogin();
    RetaguardaPO retaguardaPO = new RetaguardaPO();
    retaguardaPO.acessarCadastroCanais();
    retaguardaPO.preencherCooperativa();
    retaguardaPO.editarAtendimento();
    retaguardaPO.anoNãofinalizado(2019);
    retaguardaPO.textValidacao("Ano não fechado para lançamento de renda.(SBL-EXL-00151)(SBL-EXL-00151)");


}

}

