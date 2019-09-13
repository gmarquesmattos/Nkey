package testcases.retaguarda.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;
import pageObjects.retaguarda.detalhamento.DetalhamentoPage;

public class DetalhamentoTest extends BaseTest {

    @Test
    public void deveriaEditarRenda() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage
                .editarAlterarRenda()
                .editarAtendimento()
                .apagarRegistro();
    }

    @Test
    public void deveriaCriarNovoDetalhamento() {
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        detalhamentoPage
                .novoDetalhamento(2);
    }


    @Test
    public void devePesquisarDetalhamento() {
        AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
        alterarRendaPage
                .editarAlterarRenda()
                .editarAtendimento();
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        detalhamentoPage
                .pesquisarDetalhamento();

   }
}
