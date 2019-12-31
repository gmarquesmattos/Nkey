package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePessoaFisicaPage;
import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePessoaFisicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarOportunidadePessoaFisica() {
        OportunidadePessoaFisicaPage oportunidadePessoaFisicaPage = new OportunidadePessoaFisicaPage();
        oportunidadePessoaFisicaPage.pesquisarPessoaFisica(CPF_JOAO_CATAVENTO);
        oportunidadePessoaFisicaPage.acessarOportunidade();
        oportunidadePessoaFisicaPage.adicionarNovaOportunidade();
        oportunidadePessoaFisicaPage.selecionarAgenciaAtendimento();
        oportunidadePessoaFisicaPage.preencherDescricao();
        oportunidadePessoaFisicaPage.preencherGrupoProduto();
        oportunidadePessoaFisicaPage.salvarOportunidade();
        String textoDescricaoOportunidadeTela = oportunidadePessoaFisicaPage.retornarTextoDescricaoOportunidade();
        String descricaoEsperada = "[TESTE]-Nova oportunidade Automacao";

        assertEquals(descricaoEsperada, textoDescricaoOportunidadeTela);

        oportunidadePessoaFisicaPage.pesquisarOportunidade();
        oportunidadePessoaFisicaPage.selecionarResponsavelOportunidade(USUARIO_RESPONSAVEL_PRODUCAO);
        oportunidadePessoaFisicaPage.cancelarOportunidade();

    }
}
