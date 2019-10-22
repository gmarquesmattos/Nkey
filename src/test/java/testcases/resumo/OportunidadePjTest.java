package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPjPage;
import pageObjects.resumo.OportunidadePjPage;

import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePjTest extends BaseTest {

    @Test
    public void deveriaCriarOportunidadePj() {
        AtendimentoPjPage atendimentoPjPage = new AtendimentoPjPage(driver);
        atendimentoPjPage.irParaOportunidade();
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