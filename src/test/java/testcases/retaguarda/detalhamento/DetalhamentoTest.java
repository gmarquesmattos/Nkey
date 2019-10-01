package testcases.retaguarda.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;
import pageObjects.retaguarda.detalhamento.DetalhamentoPage;

import static org.testng.AssertJUnit.assertEquals;

public class DetalhamentoTest extends BaseTest {

    @Test
    public void deveriaCriarNovoDetalhamento() {
        int valor = 200;
        new AlterarRendaPage(driver)
                .acessar()
                .editar()
                .salvar();
        new DetalhamentoPage(driver)
                .novoDetalhamento(valor);
    }

    @Test
    public void devePesquisarDetalhamento() {
        new AlterarRendaPage(driver)
                .acessar()
                .editar()
                .salvar();
        new DetalhamentoPage(driver)
                .pesquisarDetalhamento();

    }

    @Test
    public void naoDeveSalvarSemDetalhamento() {
        new AlterarRendaPage(driver)
                .acessar()
                .editar()
                .salvar();
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver)
        .salvarSemDetalhamento();
        String textoObtido = detalhamentoPage.pegarMensagemJanelaDeErro();
        detalhamentoPage.excluirRegistroDetalhamento();
        String textoEsperado = "'Periodicidade' é um campo obrigatório. Informe um valor para o campo. (SBL-DAT-00498)";
        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void naoDeveSalvarComTiposDuplicado() {

        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        new AlterarRendaPage(driver)
                .acessar()
                .editar()
                .salvar();
        String textoObtido = detalhamentoPage.novoDetalhamentoDuplicado();
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void naoDeveSalvarComTiposDuplicadoBotaoDetalhamentoNovo() {
        new AlterarRendaPage(driver)
                .acessar()
                .editar()
                .salvar();
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        String textoObtido = detalhamentoPage.TipoDuplicadoBotaoNovodetalhamento();
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        assertEquals(textoEsperado, textoObtido);

    }

    @Test
    public void naoDeveSalvarValorIgualZero() {
        int valor = 0;
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        new AlterarRendaPage(driver)
                .acessar()
                .editar()
                .salvar();
        detalhamentoPage.inserirvalor(valor);
        String textoObtido = detalhamentoPage.pegarMensagemJanelaDeErro();
        String textoEsperado = "[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. " +
                "Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521";
        assertEquals(textoEsperado, textoObtido);
    }

}


