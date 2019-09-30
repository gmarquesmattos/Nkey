package testcases.retaguarda.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;
import pageObjects.retaguarda.detalhamento.DetalhamentoPage;

import static org.testng.AssertJUnit.assertEquals;

public class DetalhamentoTest extends BaseTest {

    @Test
    public void deveriaCriarNovoDetalhamento() {

        new DetalhamentoPage(driver)
                .novoDetalhamento();
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

        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        new AlterarRendaPage(driver)
                .acessar()
                .editar()
                .salvar();
        detalhamentoPage.salvarSemDetalhamento();
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
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        String textoObtido = detalhamentoPage.TipoDuplicadoBotaoNovodetalhamento();
        assertEquals(textoEsperado, textoObtido);

    }

    @Test
    public void naoDeveSalvarValorIgualZero() {
        String textoEsperado = "[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. " +
                "Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521";
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
     //   String textoObtido = detalhamentoPage.naoDeveSalvarValorIgualZero();
       // assertEquals(textoEsperado, textoObtido);
    }

}


