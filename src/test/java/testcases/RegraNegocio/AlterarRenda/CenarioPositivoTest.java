package testcases.RegraNegocio.AlterarRenda;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Retaguarda.RetaguardaPO;


public class CenarioPositivoTest extends BaseTest {
    @Test
    public void mesMaior(){
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.acessarCadastroCanais();
        retaguardaPO.preencherCooperativa();
        retaguardaPO.editarAtendimento();
        retaguardaPO.alterarRenda(2017, 06);
    }
}
