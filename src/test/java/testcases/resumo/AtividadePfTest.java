package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePfPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtividadePfTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtividadePf() {
        AtividadePfPage atividadePfPage = new AtividadePfPage();
        atividadePfPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        atividadePfPage.acessarAtividade();
        atividadePfPage.adicionarNovaAtividade();
        atividadePfPage.escreverDescricaoAtividade();
        atividadePfPage.selecionarAgenciaAtividade();
        atividadePfPage.salvarAtividade();
        String textoDescricaoAtividadeTela = atividadePfPage.pesquisarAtividade();
        String descricaoEsperada = "[TESTE]-Nova Atividade Automacao PF";

        assertEquals(descricaoEsperada, textoDescricaoAtividadeTela);

        atividadePfPage.excluirAtividade();
    }


}
