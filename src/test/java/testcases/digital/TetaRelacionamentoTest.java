package testcases.digital;

import base.BaseTest;
import base.MyRetry;
import org.testng.annotations.Test;
import pageObjects.digital.TelaDeRelacionamentoPage;

import static org.testng.AssertJUnit.assertEquals;

public class TetaRelacionamentoTest extends BaseTest {

    @Test(dataProvider = "cpfDigital",retryAnalyzer = MyRetry.class)
    public void deveraCompararMensagemPessoaDigital(String cpfDigital) {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage(driver);
        telaDeRelacionamentoPage.pesquisarPessoaFisica(cpfDigital);
        String textoObtido = telaDeRelacionamentoPage.indicativoPfDigital();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar o atendimento acesse a Salesforce.";

        assertEquals(textoEsperado, textoObtido);

    }

    @Test(dataProvider = "cpfNaoDigital",retryAnalyzer = MyRetry.class)
    public void deveraCompararMensagemPessoaNaoDigital(String cpfNaoDigital) {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage(driver);
        telaDeRelacionamentoPage.pesquisarPessoaFisica(cpfNaoDigital);
        String textoObtido = telaDeRelacionamentoPage.indicativoPfDigital();
        String textoEsperado = "";

        assertEquals(textoEsperado, textoObtido);

    }
    @Test(dataProvider = "cpfDigital",retryAnalyzer = MyRetry.class)
    public void deveraCompararMensagemPessoaDigitalTelaRelacionamento(String cpfDigital) {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage(driver);
        telaDeRelacionamentoPage.pesquisarPessoaFisica(cpfDigital);
        telaDeRelacionamentoPage.clicarlinkEsteiraPS();
        String textoObtido = telaDeRelacionamentoPage.esperaAceitarAlertRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce!";

        assertEquals(textoEsperado, textoObtido);
    }
}
