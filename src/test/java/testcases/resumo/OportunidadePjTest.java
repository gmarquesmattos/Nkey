package testcases.resumo;

import base.BaseTest;
import base.MyRetry;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPjPage;
import pageObjects.resumo.OportunidadePjPage;

import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePjTest extends BaseTest {

    @Test(retryAnalyzer = MyRetry.class)
    public void deveriaCriarOportunidadePj() {
        AtendimentoPjPage atendimentoPjPage = new AtendimentoPjPage(driver);
        OportunidadePjPage oportunidadePjPage = new OportunidadePjPage(driver);
        oportunidadePjPage.criarNovoOportunidade();
        oportunidadePjPage.preencherAgenciaOportunidade();
        oportunidadePjPage.preencherDescriçãoOportunidade();
        oportunidadePjPage.salvarOportunidade();
        String textoDescricaoAtendimentoPj = oportunidadePjPage.pesquisarAtendimentoPj();
        assertEquals("Novo Oportunidade Automacao PJ", textoDescricaoAtendimentoPj);
        oportunidadePjPage.excluirOportunidadePj();


    }
}
