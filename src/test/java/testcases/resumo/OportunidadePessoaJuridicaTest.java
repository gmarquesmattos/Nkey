package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadePessoaJuridicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class OportunidadePessoaJuridicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarOportunidadePessoaJuridica() {
        OportunidadePessoaJuridicaPage oportunidadePessoaJuridicaPage = new OportunidadePessoaJuridicaPage();
        oportunidadePessoaJuridicaPage.pesquisarPessoaJuridica(CNPJ_SOLUCOES_0718);
        oportunidadePessoaJuridicaPage.acessarOportunidade();
        oportunidadePessoaJuridicaPage.adicionarNovaOportunidade();
        oportunidadePessoaJuridicaPage.selecionarAgenciaOportunidade();
        oportunidadePessoaJuridicaPage.preencherDescricao();
        oportunidadePessoaJuridicaPage.preencherGrupoProduto();
        oportunidadePessoaJuridicaPage.salvarOportunidade();
        String textoDescricaoAtendimentoPj = oportunidadePessoaJuridicaPage.pesquisarAtendimento();

        assertEquals("[TESTE]-Nova Oportunidade Automacao PJ", textoDescricaoAtendimentoPj);

        oportunidadePessoaJuridicaPage.pesquisarOportunidade();
        oportunidadePessoaJuridicaPage.selecionarResponsavelOportunidade(USUARIO_RESPONSAVEL_0718);
        oportunidadePessoaJuridicaPage.cancelarOportunidade();


    }
}
