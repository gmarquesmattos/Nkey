package testcases.LGSolicitacao;

import base.BaseSolicitacaoTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LgSolicitacao.Home.HomePage;
import pageObjects.LgSolicitacao.Pendencia.PendenciaPage;
import pageObjects.LgSolicitacao.Solicitacao.SolicitacaoPage;

import static org.testng.Assert.assertEquals;

public class LgSolicitacaoTeste extends BaseSolicitacaoTest {
    String numChamado;

    @Test
    public void deveAcessarAplicacao() {
        HomePage homePage = new HomePage();
        homePage.getTextoUsuariologado();

        esperar(6000);
        assertEquals(TEXTO_USUARIO_LOGIN, homePage.getTextoUsuariologado());

    }

    @Test
    public void deveAcessarCriarAtendimento() {
        HomePage homePage = new HomePage();
        homePage.acessarMenuServico();
        esperar(2000);
        homePage.acessarBeneficiosAdm();
        esperar(2000);
        homePage.acessarMenuAssociacao();
        homePage.escreverAbrirChamado(TEXTO_REGISTRO_CHAMADO);
        esperar(5000);
        numChamado = homePage.getNumeroChamado();


    }

    @Test
    public void deveAcessarSolicitacoes() {
        HomePage homePage = new HomePage();
        homePage.clicarMenuSolicitacao();
        SolicitacaoPage solicitacaoPage = new SolicitacaoPage();
        solicitacaoPage.getTextoMinhasSolicitacoes();

        Assert.assertTrue(solicitacaoPage.getTextoMinhasSolicitacoes().contains(TEXTO_MINHAS_SOLICITACOES));
        solicitacaoPage.clicarLinkAbrirChamado();
    }

    @Test
    public void deveAcessarPendencias() {
        HomePage homePage = new HomePage();
        homePage.clicarMenuPendencia();
        PendenciaPage pendenciaPage = new PendenciaPage();
        pendenciaPage.getTextoMinhasPendencias();

        Assert.assertTrue(pendenciaPage.getTextoMinhasPendencias().contains(TEXTO_MINHAS_PENDENCIAS));

    }

    @Test
    public void deveExibirCatalogoDeServicos() {
        HomePage homePage = new HomePage();
        assertEquals(TEXTO_BENEFICIOS_SAAS,homePage.getTextoServicoBeneficioSaaS());
        assertEquals(TEXTO_BENEFICIOS_SAAS_CONFIGURACAO,homePage.getTextoBenefícioSaaSConfiguracoes());
        assertEquals(TEXTO_FPW_REPORTS,homePage.getTextoFpwReports());
        assertEquals(GEN_TE_AGREGA_AUTOATENDIMENTO,homePage.getTextoGenAgregaAutoatendimento());
        assertEquals(GEN_TE_FLUI_WORKFLOW,homePage.getTextoGenFluiWorkflow());
        assertEquals(GEN_TE_MOBILE_AUTOATENDIMENTO,homePage.getTextoGenMobileAutoAtendimento());
        assertEquals(GEN_TE_RECEBE_FOLHA_PAGAMENTO,homePage.getTextoGenFolhaPagamento());
        assertEquals(SA3,homePage.getTextoSA3());
        assertEquals(SOC,homePage.getTextoSoc());
        assertEquals(TABELAS_GENERICAS,homePage.getTextoTabelaGenericas());

    }


    @Test
    public void deveExibirAtendimento() {
        deveAcessarCriarAtendimento();
        HomePage homePage = new HomePage();
        homePage.clicarMenuSolicitacao();
        SolicitacaoPage solicitacaoPage = new SolicitacaoPage();
        solicitacaoPage.escreverChamado(numChamado);
        esperar(30000);
        solicitacaoPage.clicarLinkAbrirChamado();
        solicitacaoPage.clicarAtendimento(TEXTO_DESCRICAO_ATIVIDADE);

        assertEquals(TEXTO_REGISTRO_SALVO_COM_SUCESSO, solicitacaoPage.getTextoRegistroSalvoComSucesso());

    }


}
