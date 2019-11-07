package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePfPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtividadePfTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class,dataProvider = "cpfSolucaoFinanceiraCoop0718")
    public void deveCriarAtividadePf(String cpf) {
        AtividadePfPage atividadePfPage = new AtividadePfPage();
        atividadePfPage.pesquisarPessoaFisica(cpf);
        atividadePfPage.acessarAtividade();
        atividadePfPage.adicionarNovaAtividade();
        atividadePfPage.escreverDescricaoAtividade();
        atividadePfPage.selecionarAgenciaAtividade();
        atividadePfPage.salvarAtividade();
        String textoDescricaoAtividadeTela = atividadePfPage.pesquisarAtividade();
        String descricaoEsperada = "Nova Atividade Automacao PF";

        assertEquals(descricaoEsperada, textoDescricaoAtividadeTela);

        atividadePfPage.excluirAtividade();
    }


}
