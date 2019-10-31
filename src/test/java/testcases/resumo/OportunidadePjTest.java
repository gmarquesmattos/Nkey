package testcases.resumo;

import base.BaseTest;
import base.MyRetry;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPjPage;
import pageObjects.resumo.OportunidadePjPage;

import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePjTest extends BaseTest {

    @Test(retryAnalyzer = MyRetry.class, dataProvider = "cnpjDigital")
    public void deveriaCriarOportunidadePj(String cnpj) {
        OportunidadePjPage oportunidadePjPage = new OportunidadePjPage(driver);
        oportunidadePjPage.pesquisarPessoaJuridica(cnpj);
        oportunidadePjPage.acessarOportunidade();
        oportunidadePjPage.adicionarNovaOportunidade();
        oportunidadePjPage.selecionarAgenciaOportunidade();
        oportunidadePjPage.preencherDescricao();
        oportunidadePjPage.preencherGrupoProduto();
        oportunidadePjPage.salvarOportunidade();
        String textoDescricaoAtendimentoPj = oportunidadePjPage.pesquisarAtendimentoPj();

        assertEquals("Nova Oportunidade Automacao PJ", textoDescricaoAtendimentoPj);

        oportunidadePjPage.excluirOportunidadePj();


    }
}
