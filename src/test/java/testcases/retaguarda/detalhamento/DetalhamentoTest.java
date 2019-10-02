package testcases.retaguarda.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.detalhamento.DetalhamentoPage;

import static org.testng.AssertJUnit.assertEquals;

public class DetalhamentoTest extends BaseTest {

    @Test
    public void deveriaCriarNovoDetalhamento() {
        int valor = 200;
        new DetalhamentoPage(driver)
                .novoDetalhamento(valor);
    }

    @Test
    public void devePesquisarDetalhamento() {
        new DetalhamentoPage(driver)
                .pesquisarDetalhamento();
    }

    @Test
    public void naoDeveSalvarSemDetalhamento() {
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
        String textoObtido = detalhamentoPage.novoDetalhamentoDuplicado();
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void naoDeveSalvarComTiposDuplicadoBotaoDetalhamentoNovo() {
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        String textoObtido = detalhamentoPage.TipoDuplicadoBotaoNovodetalhamento();
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        assertEquals(textoEsperado, textoObtido);

    }

    @Test
    public void naoDeveSalvarValorIgualZero() {
        int valor = 0;
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        detalhamentoPage.inserirValor(valor);
        String textoObtido = detalhamentoPage.pegarMensagemJanelaDeErro();
        String textoEsperado = "[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. " +
                "Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521";
        assertEquals(textoEsperado, textoObtido);
    }

}


