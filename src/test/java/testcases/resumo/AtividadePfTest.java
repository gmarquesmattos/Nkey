package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePfPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtividadePfTest extends BaseTest {

    @Test
    public void deveCriarAtividadePf() {
        AtividadePfPage atividadePfPage = new AtividadePfPage(driver);
        atividadePfPage.adicionarNovaAtividade();
        atividadePfPage.escreverDescricaoAtividade();
        atividadePfPage.salvarAtividade();
        String textoDescricaoAtividadeTela = atividadePfPage.pesquisarAtividade();
        String descricaoEsperada = "Nova Atividade Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtividadeTela);

        atividadePfPage.excluirAtividade();

    }


}
