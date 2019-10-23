package testcases.digital;

import base.BaseTest;
import javafx.application.Application;
import javafx.stage.Stage;
import org.testng.annotations.Test;
import pageObjects.digital.DigitalPfRecomendarPage;
import pageObjects.pessoa.PessoaFisicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class PfDigitalRecomendarTest extends BaseTest {

    @Test
    public void pfDigitalNaoDeveAcessarRecomendarPS() {
        DigitalPfRecomendarPage digitalPfRecomendarPage = new DigitalPfRecomendarPage(driver);
        digitalPfRecomendarPage.pesquisarPessoa("03334856020");
        digitalPfRecomendarPage.clicarBotaorecomendarPS();
        String textoObtido = digitalPfRecomendarPage.mensagemRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce. (SBL-APS-00802)";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void pfNaoDigitalDeveAcessarRecomendarPS() {
        DigitalPfRecomendarPage digitalPfRecomendarPage = new DigitalPfRecomendarPage(driver);
        digitalPfRecomendarPage.pesquisarPessoa("49086529020");
        digitalPfRecomendarPage.clicarBotaorecomendarPS();
        String textoObtido = digitalPfRecomendarPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }

    @Test
    public void pfDigitalNaoDeveAcessarRecomendarPSTelaRelacionamento() {
        DigitalPfRecomendarPage digitalPfRecomendarPage = new DigitalPfRecomendarPage(driver);
        new PessoaFisicaPage(driver, "03334856020");
        digitalPfRecomendarPage.clicarlinkEsteiraPS();
        String textoObtido = digitalPfRecomendarPage.esperaAceitarAlertRecomendar();
        String textoEsperado = "Este associado utiliza a Plataforma Digital. Para realizar a contratação de produtos e serviços, acesse a Salesforce!";

        assertEquals(textoEsperado, textoObtido);
    }

}