package testcases.retaguarda.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
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
        new DetalhamentoPage(driver)
                .pesquisarDetalhamento();

    }

    @Test
    public void naoDeveSalvarSemDetalhamento() {
        String textoEsperado = "'Periodicidade' é um campo obrigatório. Informe um valor para o campo. (SBL-DAT-00498)";
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        String textoObtido = detalhamentoPage.salvarSemDetalhamento();

        assertEquals(textoEsperado,textoObtido);
    }

    @Test
    public void naoDeveSalvarComTiposDuplicado() {
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        String textoObtido = detalhamentoPage.novoDetalhamentoDuplicado();

        assertEquals(textoEsperado,textoObtido);
    }

    @Test
    public void naoDeveSalvarComTiposDuplicadoBotaoDetalhamentoNovo() {
        String textoEsperado = "Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)";
        DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
        String textoObtido = detalhamentoPage.TipoDuplicadoBotaoNovodetalhamento();
        assertEquals(textoEsperado,textoObtido);

    }

   @Test
   public void naoDeveSalvarValorIgualZero() {
     String textoEsperado = "[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. " +
             "Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521";
       DetalhamentoPage detalhamentoPage = new DetalhamentoPage(driver);
       String textoObtido = detalhamentoPage.naoDeveSalvarValorIgualZero();
       assertEquals(textoEsperado,textoObtido);
  }

}


