package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.BarraBotoesTelaRelacionamentoPage;
import pageObjects.resumo.OportunidadePessoaFisicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class NovoContatoOportunidadePessoaFisicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarNovaContatoOportunidadePessoaFisica(){

        OportunidadePessoaFisicaPage  oportunidadePessoaFisicaPage = new OportunidadePessoaFisicaPage();
        oportunidadePessoaFisicaPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        new BarraBotoesTelaRelacionamentoPage().criarNovoContatoOportunidade();
        oportunidadePessoaFisicaPage.adicionarNovaOportunidade();
        oportunidadePessoaFisicaPage.selecionarAgenciaAtendimento();
        oportunidadePessoaFisicaPage.preencherDescricao();
        oportunidadePessoaFisicaPage.preencherGrupoProduto();
        oportunidadePessoaFisicaPage.salvarOportunidade();

        String textoDescricaoOportunidadeTela = oportunidadePessoaFisicaPage.retornarTextoDescricaoOportunidade();
        String descricaoEsperada = "[TESTE]-Nova oportunidade Automacao";

        assertEquals(descricaoEsperada, textoDescricaoOportunidadeTela);

        oportunidadePessoaFisicaPage.pesquisarOportunidade();
        oportunidadePessoaFisicaPage.selecionarResponsavelOportunidade(USUARIO_RESPONSAVEL_0718);
        oportunidadePessoaFisicaPage.excluirOportunidade();

    }
}
