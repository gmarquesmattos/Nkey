package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePjPage;

import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePjTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class, dataProvider = "cnpjSolucaoFinanceiraCoop0718")
    public void deveCriarOportunidadePj(String cnpj) {
        OportunidadePjPage oportunidadePjPage = new OportunidadePjPage();
        oportunidadePjPage.pesquisarPessoaJuridica(cnpj);
        oportunidadePjPage.acessarOportunidade();
        oportunidadePjPage.adicionarNovaOportunidade();
        oportunidadePjPage.selecionarAgenciaOportunidade();
        oportunidadePjPage.preencherDescricao();
        oportunidadePjPage.preencherGrupoProduto();
        oportunidadePjPage.salvarOportunidade();
        String textoDescricaoAtendimentoPj = oportunidadePjPage.pesquisarAtendimentoPj();

        assertEquals("[TESTE]-Nova Oportunidade Automacao PJ", textoDescricaoAtendimentoPj);

        oportunidadePjPage.excluirOportunidadePj();


    }
}
