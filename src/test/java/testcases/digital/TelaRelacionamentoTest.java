package testcases.digital;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.digital.TelaDeRelacionamentoPage;

import static org.testng.AssertJUnit.assertEquals;

public class TelaRelacionamentoTest extends BaseTest {

    @Test(dataProvider = "cpfDigital",retryAnalyzer = Retentativa.class)
    public void deveCompararMensagemPessoaDigital(String cpfDigital) {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage();
        telaDeRelacionamentoPage.pesquisarPessoaFisica(cpfDigital);
        String textoObtido = telaDeRelacionamentoPage.indicativoPfDigital();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar o atendimento acesse a Salesforce.";

        assertEquals(textoEsperado, textoObtido);

    }

    @Test(dataProvider = "cpfNaoDigital",retryAnalyzer = Retentativa.class)
    public void deveCompararMensagemPessoaNaoDigital(String cpfNaoDigital) {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage();
        telaDeRelacionamentoPage.pesquisarPessoaFisica(cpfNaoDigital);
        String textoObtido = telaDeRelacionamentoPage.indicativoPfDigital();
        String textoEsperado = "";

        assertEquals(textoEsperado, textoObtido);

    }
    @Test(dataProvider = "cpfDigital",retryAnalyzer = Retentativa.class)
    public void deveRetornarMensagemPessoaDigitalTelaRelacionamento(String cpfDigital) {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage();
        telaDeRelacionamentoPage.pesquisarPessoaFisica(cpfDigital);
        telaDeRelacionamentoPage.clicarlinkEsteiraPS();
        String textoObtido = telaDeRelacionamentoPage.esperaAceitarAlertRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce!";

        assertEquals(textoEsperado, textoObtido);
    }
}
