package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPfPage;

import static org.testng.AssertJUnit.assertEquals;


public class AtendimentoPfTest extends BaseTest {


    @Test
    public void deveCriarAtendimentoPf() {
        AtendimentoPfPage atendimentoPage = new AtendimentoPfPage(driver);
        atendimentoPage.realizarNovoAtendimento();
        atendimentoPage.escreverDescricaoAtendimento();
        atendimentoPage.salvarAtendimento();
        String textoDescricaoAtendimentoTela = atendimentoPage.pesquisarAtendimento();
        String descricaoEsperada = "Novo Atendimento Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtendimentoTela);

        atendimentoPage.excluirAtendimento();
    }

}
