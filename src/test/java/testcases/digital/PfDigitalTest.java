package testcases.digital;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.digital.DigitalPf;

import static org.testng.AssertJUnit.assertEquals;

public class PfDigitalTest extends BaseTest {

    @Test
    public void pessoaDigitalTelaDeRelacionamento() {
        DigitalPf digitalPf = new DigitalPf(driver);
        digitalPf.insereCpf("03334856020");
        String textoObtido = digitalPf.indicativoPfDigital();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar o atendimento acesse a Salesforce.";

        assertEquals(textoEsperado, textoObtido);

    }

    @Test
    public void pessoaNaoDigitalTelaRelacionamento() {
        DigitalPf digitalPf = new DigitalPf(driver);
        digitalPf.insereCpf("97452874820");
        String textoObtido = digitalPf.indicativoPfDigital();
        String textoEsperado = "";

        assertEquals(textoEsperado, textoObtido);

    }
}
