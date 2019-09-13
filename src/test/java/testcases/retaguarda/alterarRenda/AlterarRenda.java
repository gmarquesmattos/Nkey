package testcases.retaguarda.alterarRenda;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

public class AlterarRenda extends BaseTest {

    @Test
    public void deveriaEditarRenda() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage
                .editarAlterarRenda();
    }

    @Test
    public void deveSalvarComMesMenorQueAtual() {
        new AlterarRendaPage(driver)
                .alterarRendaValidaAnoMes(-2);

    }


}
