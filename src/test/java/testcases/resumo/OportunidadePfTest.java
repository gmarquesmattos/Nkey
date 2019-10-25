package testcases.resumo;

import base.BaseTest;
import base.MyRetry;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePfPage;
import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePfTest extends BaseTest {

    @Test(retryAnalyzer = MyRetry.class)
    public void deveriaCriarOportunidade() {
        OportunidadePfPage oportunidadePage = new OportunidadePfPage(driver);
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
