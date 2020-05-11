package testcases.digital;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.digital.TelaDeRelacionamentoPage;
import pageObjects.pessoa.BarraBotoesTelaRelacionamentoPage;
import static org.testng.AssertJUnit.assertEquals;

public class TelaRelacionamentoTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCompararMensagemPessoaDigital() {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage();
        telaDeRelacionamentoPage.pesquisarPessoaFisica(CPF_DIGITAL_0718);
        String textoObtido = telaDeRelacionamentoPage.indicativoPfDigital();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar o atendimento acesse a Salesforce.";

        assertEquals(textoEsperado, textoObtido);

    }

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCompararMensagemPessoaNaoDigital() {
        TelaDeRelacionamentoPage telaDeRelacionamentoPage = new TelaDeRelacionamentoPage();
        telaDeRelacionamentoPage.pesquisarPessoaFisica(CPF_NAO_DIGITAL_0718);
        String textoObtido = telaDeRelacionamentoPage.indicativoPfDigital();
        String textoEsperado = "";

        assertEquals(textoEsperado, textoObtido);

    }

}
