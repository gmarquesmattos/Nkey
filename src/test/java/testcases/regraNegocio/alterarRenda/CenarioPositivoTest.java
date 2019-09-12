package testcases.regraNegocio.alterarRenda;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.RetaguardaPage;


public class CenarioPositivoTest extends BaseTest {
    @Test
    public void deveSalvarComMesMaiorQueAtual() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.acessarCadastroCanais();
        retaguardaPage.preencherCooperativa();
        retaguardaPage.editarAtendimento();
        retaguardaPage.alterarRenda();
    }
}
