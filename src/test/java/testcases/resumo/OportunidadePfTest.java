package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePage;

import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePfTest extends BaseTest {

    @Test
    public void deveriaCriarOportunidade() {
        OportunidadePage oportunidadePage = new OportunidadePage(driver);
        oportunidadePage.clicarNovaOportunidade();
        oportunidadePage.preencherGrupoProduto();
        oportunidadePage.preencherDescricao();
        oportunidadePage.salvarOportunidade();

        String textoDescricaoAtendimentoTela = oportunidadePage.pesquisarAtendimento();
        String descricaoEsperada = "Novo oportunidade Automacao";
        assertEquals(descricaoEsperada, textoDescricaoAtendimentoTela);

        oportunidadePage.clicarExcluirOportunidade();

    }
}
