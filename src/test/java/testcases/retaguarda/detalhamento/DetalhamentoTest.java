package testcases.retaguarda.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import pageObjects.retaguarda.detalhamento.DetalhamentoPage;

public class DetalhamentoTest extends BaseTest {

    @Test
    public void deveriaCriarNovoDetalhamento() {
        new DetalhamentoPage(driver)
                .novoDetalhamento();
    }

    @Test
    public void devePesquisarDetalhamento() {
        new DetalhamentoPage(driver)
                .pesquisarDetalhamento();

    }

    @Test
    public void naoDeveSalvarSemDetalhamento() {
        new DetalhamentoPage(driver)
               .salvarSemDetalhamento();

    }


}
