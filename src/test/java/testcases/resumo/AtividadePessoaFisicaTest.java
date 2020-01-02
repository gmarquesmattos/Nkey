package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePessoaFisicaPage;
import static org.testng.AssertJUnit.assertEquals;

public class AtividadePessoaFisicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtividadePessoaFisica() {
        AtividadePessoaFisicaPage atividadePessoaFisicaPage = new AtividadePessoaFisicaPage();
        atividadePessoaFisicaPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        atividadePessoaFisicaPage.acessarAtividade();
        atividadePessoaFisicaPage.adicionarNovaAtividade();
        atividadePessoaFisicaPage.escreverDescricaoAtividade();
        atividadePessoaFisicaPage.selecionarAgenciaAtividade();
        atividadePessoaFisicaPage.salvarAtividade();
        String textoDescricaoAtividadeTela = atividadePessoaFisicaPage.retornarTextoDescricaoAtividade();
        String descricaoEsperada = "[TESTE]-Nova Atividade Automacao PF";

        assertEquals(descricaoEsperada, textoDescricaoAtividadeTela);

        atividadePessoaFisicaPage.pesquisarAtividade();
        atividadePessoaFisicaPage.selecionarResponsavelAtividade(USUARIO_RESPONSAVEL_0718);
        atividadePessoaFisicaPage.cancelarAtividade();
    }


}
