package testcases.digital;

import base.BaseTest;
import pageObjects.digital.RecomendaDadosBasicosPage;
import pageObjects.pessoa.DetalheDaPessoaFisicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class DetalhesDaPessoaTest extends BaseTest {

    //  @Test(dataProvider = "cpfDigital",retryAnalyzer = MyRetry.class)
    public void deveraRetornarMensagemDigitalDetalhePessoa(String cpfDigital ) {
        DetalheDaPessoaFisicaPage detalheDaPessoaFisicaPage = new DetalheDaPessoaFisicaPage(driver);
        detalheDaPessoaFisicaPage.pesquisarPessoaFisica(cpfDigital);
        detalheDaPessoaFisicaPage.clicarBotaoRecomendarPS();
        String textoObtido = detalheDaPessoaFisicaPage.mensagemBotaoRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce. (SBL-APS-00802)";

        assertEquals(textoEsperado, textoObtido);
    }

    // @Test(dataProvider = "cpfNaoDigital",retryAnalyzer = MyRetry.class)
    public void deveraRetornarNaoDigitalDetalhePessoa(String cpfNaoDigital ) {
        DetalheDaPessoaFisicaPage detalheDaPessoaFisicaPage = new DetalheDaPessoaFisicaPage(driver);
        detalheDaPessoaFisicaPage.pesquisarPessoaFisica(cpfNaoDigital);
        detalheDaPessoaFisicaPage.clicarBotaoRecomendarPS();
        RecomendaDadosBasicosPage recomendaDadosBasicosPage = new RecomendaDadosBasicosPage(driver);
        String textoObtido = recomendaDadosBasicosPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }
}