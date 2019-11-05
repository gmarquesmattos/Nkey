package testcases.resumo;

import base.BaseTest;
import base.Tentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePfPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtividadePfTest extends BaseTest {

    @Test(retryAnalyzer = Tentativa.class,dataProvider = "cpfNaoDigital")
    public void deveCriarAtividadePf(String cpf) {
        AtividadePfPage atividadePfPage = new AtividadePfPage(driver);
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
