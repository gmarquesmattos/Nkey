package testcases.Atividade;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Atividade.AtividadePage;
import pageObjects.Home.HomePage;
import pageObjects.Telefonar.TelefonarPage;

import static org.testng.Assert.assertEquals;


public class AtividadeTeste extends BaseTest {


    @Test
    public void deveLogarNoPortalVendas() {
        HomePage homePage = new HomePage();

        assertEquals(TITULO_HOME_ATIVIDADE, homePage.getTextoAtividade());


    }

    @Test
    public void deveCriarNovaAtividadeEConcluirAtividade() {
        HomePage homePage = new HomePage();
        homePage.clicarBotaoNovaAtividade();
        AtividadePage atividadePage = new AtividadePage();
        atividadePage.escolherOpcaoNegocio(HORA_INICIO, HORA_FIM, DESC);
        assertEquals(ATIVIDADE_SALVA_COM_SUCESSO, atividadePage.getTextoSalvoComSucesso());
        homePage.clicarLinkConcluirAtividade();
        TelefonarPage telefonarPage = new TelefonarPage();
        telefonarPage.inserirConclusao(TEXTO_CONCLUIR);

    }
@Test
    public void nãoDeveCriarAtividadeComCampoNegocioVazio(){
    HomePage homePage = new HomePage();
    homePage.clicarBotaoNovaAtividade();
    AtividadePage atividadePage = new AtividadePage();
    atividadePage.salvarSemCampoNegocio(HORA_INICIO, HORA_FIM, DESC);

    assertEquals(TEXTO_NEGOCIO_OBRIGATORIO, atividadePage.getTextoNegocioObrigatorio());


}
    @Test
    public void nãoDeveCriarAtividadeComCampoDataVazio(){
        HomePage homePage = new HomePage();
        homePage.clicarBotaoNovaAtividade();
        AtividadePage atividadePage = new AtividadePage();
        atividadePage.salvarSemCampoData(HORA_INICIO, HORA_FIM, DESC);

        assertEquals(TEXTO_DATA_OBRIGATORIO, atividadePage.getTextoNegocioObrigatorio());


    }

    @Test
    public void nãoDeveCriarAtividadeComCampoFormaContatoVazio(){
        HomePage homePage = new HomePage();
        homePage.clicarBotaoNovaAtividade();
        AtividadePage atividadePage = new AtividadePage();
        atividadePage.salvarSemCampoFormaContato(HORA_INICIO, HORA_FIM, DESC);

        assertEquals(TEXTO_FORMA_CONTATO, atividadePage.getTextoNegocioObrigatorio());


    }


}










