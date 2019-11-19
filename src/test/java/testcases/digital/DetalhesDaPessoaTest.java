package testcases.digital;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.digital.RecomendaDadosBasicosPage;
import pageObjects.pessoa.DetalheDaPessoaFisicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class DetalhesDaPessoaTest extends BaseTest {

      @Test(dataProvider = "cpfDigital",retryAnalyzer = Retentativa.class)
    public void deveRetornarMensagemDigitalDetalhePessoa(String cpfDigital ) {
        DetalheDaPessoaFisicaPage detalheDaPessoaFisicaPage = new DetalheDaPessoaFisicaPage();
        detalheDaPessoaFisicaPage.pesquisarPessoaFisica(cpfDigital);
        detalheDaPessoaFisicaPage.clicarBotaoRecomendarPS();
        String textoObtido = detalheDaPessoaFisicaPage.mensagemBotaoRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce. (SBL-APS-00802)";

        assertEquals(textoEsperado, textoObtido);
    }

     @Test(dataProvider = "cpfNaoDigital",retryAnalyzer = Retentativa.class)
    public void deveRetornarNaoDigitalDetalhePessoa(String cpfNaoDigital ) {
        DetalheDaPessoaFisicaPage detalheDaPessoaFisicaPage = new DetalheDaPessoaFisicaPage();
        detalheDaPessoaFisicaPage.pesquisarPessoaFisica(cpfNaoDigital);
        detalheDaPessoaFisicaPage.clicarBotaoRecomendarPS();
        RecomendaDadosBasicosPage recomendaDadosBasicosPage = new RecomendaDadosBasicosPage();
        String textoObtido = recomendaDadosBasicosPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }
}