package testcases.digital;

import base.BaseTest;

import org.testng.annotations.Test;
import pageObjects.digital.DigitalPfPage;
import static org.testng.AssertJUnit.assertEquals;

public class PfDigitalTest extends BaseTest {

    @Test
    public void deveraCompararMensagemPessoaDigital() {
        DigitalPfPage digitalPfPage = new DigitalPfPage(driver);
        String pfDigital ="03334856020";
        digitalPfPage.pesquisar(pfDigital);
        String textoObtido = digitalPfPage.indicativoPfDigital();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar o atendimento acesse a Salesforce.";

        assertEquals(textoEsperado, textoObtido);

    }

    @Test
    public void deveraCompararMensagemPessoaNaoDigital() {
        DigitalPfPage digitalPfPage = new DigitalPfPage(driver);
        String pFNaoDigital = "97452874820";
        digitalPfPage.pesquisar(pFNaoDigital);
        String textoObtido = digitalPfPage.indicativoPfDigital();
        String textoEsperado = "";

        assertEquals(textoEsperado, textoObtido);

    }
}
