package testcases.resumo;

import base.BaseTest;
import base.MyRetry;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePfPage;
import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePfTest extends BaseTest {

    @Test(retryAnalyzer = MyRetry.class, dataProvider = "cpfNaoDigital")
    public void deveriaCriarOportunidade(String cpf) {
        OportunidadePfPage oportunidadePage = new OportunidadePfPage(driver);
        oportunidadePage.pesquisarPessoaFisica(cpf);
        oportunidadePage.acessarOportunidade();
        oportunidadePage.adicionarNovaOportunidade();
        oportunidadePage.preencherGrupoProduto();
        oportunidadePage.preencherDescricao();
        oportunidadePage.selecionarAgenciaAtendimento();
        oportunidadePage.salvarOportunidade();
        String textoDescricaoAtendimentoTela = oportunidadePage.pesquisarOportunidade();
        String descricaoEsperada = "Novo oportunidade Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtendimentoTela);

        oportunidadePage.ExcluirOportunidade();

    }
}
