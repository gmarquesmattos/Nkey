package testcases.retaguarda.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.detalhamento.DetalhamentoPage;

public class DetalhamentoTest extends BaseTest {

    @Test
    public void deveriaPreencherDetalhamento() {
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);

        detalhamentoPage
                .preencherDetalhamento()
                .editarAtendimento()
                .apagarRegistro()
                .verificarTextoDoDetalhamento();
    }
}
