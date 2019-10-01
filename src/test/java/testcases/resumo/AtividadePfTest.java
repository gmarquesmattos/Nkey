package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadadePfPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtividadePfTest extends BaseTest {

    @Test
    public void deveCriarAtividadePf() {
        AtividadadePfPage atividadadePfPage = new AtividadadePfPage(driver);
        atividadadePfPage.adicionarNovaAtividade();
        atividadadePfPage.escreverDescricaoAtividade();
        atividadadePfPage.salvarAtividade();
        String textoDescricaoAtividadeTela = atividadadePfPage.pesquisarAtividade();
        String descricaoEsperada = "Nova Atividade Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtividadeTela);

        atividadadePfPage.excluirAtividade();

    }


}
