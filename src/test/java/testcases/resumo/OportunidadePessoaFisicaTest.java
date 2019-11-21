package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePessoaFisicaPage;
import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePessoaFisicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarOportunidadePessoaFisica() {
        OportunidadePessoaFisicaPage oportunidadePage = new OportunidadePessoaFisicaPage();
        oportunidadePage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        oportunidadePage.acessarOportunidade();
        oportunidadePage.adicionarNovaOportunidade();
        oportunidadePage.selecionarAgenciaAtendimento();
        oportunidadePage.preencherDescricao();
        oportunidadePage.preencherGrupoProduto();
        oportunidadePage.salvarOportunidade();
        String textoDescricaoOportunidadeTela = oportunidadePage.retornarTextoDescricaoOportunidade();
        String descricaoEsperada = "[TESTE]-Nova oportunidade Automacao";

        assertEquals(descricaoEsperada, textoDescricaoOportunidadeTela);

        oportunidadePage.pesquisarOportunidade();
        oportunidadePage.selecionarResponsavelOportunidade(USUARIO_RESPONSAVEL);
        oportunidadePage.ExcluirOportunidade();

    }
}
