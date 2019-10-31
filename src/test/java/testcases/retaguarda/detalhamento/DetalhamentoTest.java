package testcases.retaguarda.detalhamento;

import base.BaseTest;
import base.MyRetry;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;
import pageObjects.retaguarda.detalhamento.DetalhamentoPage;
import pageObjects.retaguarda.rendaEnviada.RendaEnviadaPage;

import static org.testng.AssertJUnit.assertEquals;

public class DetalhamentoTest extends BaseTest {

    @Test(retryAnalyzer = MyRetry.class)
    public void deveriaCriarNovoDetalhamento() {
        int valor = 200;
        new DetalhamentoPage(driver)
                .novoDetalhamento()
                .inserirTipo("outros")
                .inserirPeriodicidade()
                .inserirValor(valor)
                .salvarDetalhamento();
        new AlterarRendaPage(driver)
                .excluirRenda();
    }

    @Test(retryAnalyzer = MyRetry.class)
    public void deveriaPesquisarDetalhamento() {
        int valor = 200;
        new DetalhamentoPage(driver)
                .novoDetalhamento()
                .inserirTipo("outros")
                .inserirPeriodicidade()
                .inserirValor(valor)
                .salvarDetalhamento()
                .pesquisarDetalhamento();
        new AlterarRendaPage(driver)
                .excluirRenda();
    }

    @Test(retryAnalyzer = MyRetry.class)
    public void naoDeveSalvarSemDetalhamento() {
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver)
                .adicionarDetalhamento().salvarDetalhamento();

        String textoObtido = detalhamentoPage.pegarMensagemJanelaDeErro();
        detalhamentoPage.excluirRegistroDetalhamento();
        String textoEsperado = "'Periodicidade' é um campo obrigatório. Informe um valor para o campo. (SBL-DAT-00498)";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test(retryAnalyzer = MyRetry.class)
    public void naoDeveSalvarComTiposDuplicado() {
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        detalhamentoPage.novoDetalhamento();
        RendaEnviadaPage rendaEnviadaPage = new RendaEnviadaPage(driver);
        detalhamentoPage.inserirTipo(rendaEnviadaPage.obterTipo());
        detalhamentoPage.salvarDetalhamento();
        String textoObtido = detalhamentoPage.pegarMensagemJanelaDeErro();
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";

        assertEquals(textoEsperado, textoObtido);

        detalhamentoPage.excluirRegistroDetalhamento();
        new AlterarRendaPage(driver).excluirRenda();

    }

    @Test(retryAnalyzer = MyRetry.class)
    public void naoDeveSalvarComTiposDuplicadoBotaoDetalhamentoNovo() {
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        detalhamentoPage.novoDetalhamento();
        RendaEnviadaPage rendaEnviadaPage = new RendaEnviadaPage(driver);
        detalhamentoPage.inserirTipo(rendaEnviadaPage.obterTipo());
        detalhamentoPage.adicionarDetalhamento();
        String textoObtido = detalhamentoPage.pegarMensagemJanelaDeErro();
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";

        assertEquals(textoEsperado, textoObtido);

        detalhamentoPage.excluirRegistroDetalhamento();
        new AlterarRendaPage(driver).excluirRenda();
    }

    @Test(retryAnalyzer = MyRetry.class)
    public void naoDeveSalvarValorIgualZero() {
        int valor = 00;
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        detalhamentoPage.novoDetalhamento();
        detalhamentoPage.inserirTipo("outros");
        detalhamentoPage.inserirPeriodicidade();
        detalhamentoPage.inserirValor(valor);
        detalhamentoPage.salvarDetalhamento();
        String textoObtido = detalhamentoPage.pegarMensagemJanelaDeErro();
        String textoEsperado = "[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. " +
                "Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521";

        assertEquals(textoEsperado, textoObtido);

    }

}


