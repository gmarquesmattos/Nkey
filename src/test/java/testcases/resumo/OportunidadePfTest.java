package testcases.resumo;

import base.BaseTest;
import base.Tentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePfPage;
import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePfTest extends BaseTest {

    @Test(retryAnalyzer = Tentativa.class, dataProvider = "cpfNaoDigital")
    public void deveriaCriarOportunidade(String cpf) {
        OportunidadePfPage oportunidadePage = new OportunidadePfPage(driver);
        oportunidadePage.pesquisarPessoaFisica(cpf);
        oportunidadePage.acessarOportunidade();
        oportunidadePage.adicionarNovaOportunidade();
        oportunidadePage.selecionarAgenciaAtendimento();
        oportunidadePage.preencherDescricao();
        oportunidadePage.preencherGrupoProduto();
        oportunidadePage.salvarOportunidade();
        String textoDescricaoAtendimentoTela = oportunidadePage.pesquisarTextoDescricaoOportunidade();
        String descricaoEsperada = "Nova oportunidade Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtendimentoTela);

        oportunidadePage.ExcluirOportunidade();

    }
}
