package testcases.digital;

import base.BaseTest;

import org.testng.annotations.Test;
import pageObjects.digital.DigitalPfPage;
import static org.testng.AssertJUnit.assertEquals;

public class PfDigitalTest extends BaseTest {

    @Test
    public void pessoaDigitalTelaDeRelacionamento() {
        DigitalPfPage digitalPfPage = new DigitalPfPage(driver);
        digitalPfPage.insereCpf("03334856020");
        String textoObtido = digitalPfPage.indicativoPfDigital();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar o atendimento acesse a Salesforce.";

        assertEquals(textoEsperado, textoObtido);

    }

    @Test
    public void pessoaNaoDigitalTelaRelacionamento() {
        DigitalPfPage digitalPfPage = new DigitalPfPage(driver);
        digitalPfPage.insereCpf("97452874820");
        String textoObtido = digitalPfPage.indicativoPfDigital();
        String textoEsperado = "";

        assertEquals(textoEsperado, textoObtido);

    }


}
