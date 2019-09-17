package testcases.retaguarda.alterarRenda;

import base.BaseTest;
import org.testng.annotations.Test;
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
                .ValidaAnoMes();

    }


    @Test
    public void naoDeveSalvarComMesMaiorQueAtual() {
        new AlterarRendaPage(driver)
                .validaAnoMaiorQueAtual();

    }

    @Test
    public void naoDeveSalvarNaoFinalizado() {

        new AlterarRendaPage(driver)
                .anoNaofinalizado();

    }


}
