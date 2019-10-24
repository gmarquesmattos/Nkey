package testcases.digital;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.digital.TelaDeRelacionamentoPfPage;
import pageObjects.digital.TelaDeRelacionamentoPjPage;
import pageObjects.pessoa.PessoaFisicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class DetalhesDaPessoaTest extends BaseTest {

    @Test
    public void deveraCompararMensagemDigitalDetalhePessoa() {
        TelaDeRelacionamentoPfPage telaDeRelacionamentoPfPage = new TelaDeRelacionamentoPfPage(driver);
        String pfDigital = "03334856020";
        telaDeRelacionamentoPfPage.pesquisarPessoa(pfDigital);
        telaDeRelacionamentoPfPage.clicarBotaoRecomendarPS();
        String textoObtido = telaDeRelacionamentoPfPage.mensagemRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce. (SBL-APS-00802)";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void deveraCompararMensagemNaoDigitalDetalhePessoa() {
        TelaDeRelacionamentoPfPage telaDeRelacionamentoPfPage = new TelaDeRelacionamentoPfPage(driver);
        String pFNaoDigital = "49086529020";
        telaDeRelacionamentoPfPage.pesquisarPessoa(pFNaoDigital);
        telaDeRelacionamentoPfPage.clicarBotaoRecomendarPS();
        String textoObtido = telaDeRelacionamentoPfPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void deveraCompararMensagemPessoaDigitalTelaRelacionamento() {
        TelaDeRelacionamentoPfPage telaDeRelacionamentoPfPage = new TelaDeRelacionamentoPfPage(driver);
        String pFDigital = "03334856020";
        new PessoaFisicaPage(driver, pFDigital);
        telaDeRelacionamentoPfPage.clicarlinkEsteiraPS();
        String textoObtido = telaDeRelacionamentoPfPage.esperaAceitarAlertRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce!";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void deveraComprarMensagemRecomendarDadosBasicosPessoaJuridica() {
        TelaDeRelacionamentoPjPage telaDeRelacionamentoPjPage = new TelaDeRelacionamentoPjPage(driver);
        String cnpj = "09514327000156";
        telaDeRelacionamentoPjPage.pesquisarPj(cnpj);
        telaDeRelacionamentoPjPage.clicarBotaoRecomendarPs();
        String textoObtido = telaDeRelacionamentoPjPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void deveraComprarMensagemRecomendarResumoDadosBasicosPessoaJuridica() {
        TelaDeRelacionamentoPjPage telaDeRelacionamentoPjPage = new TelaDeRelacionamentoPjPage(driver);
        String cnpj = "09514327000156";
        telaDeRelacionamentoPjPage.pesquisarPj(cnpj);
        telaDeRelacionamentoPjPage.acessarRazaoSocial();
        telaDeRelacionamentoPjPage.clicarlinkEsteiraPS();
        String textoObtido = telaDeRelacionamentoPjPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
   }


}