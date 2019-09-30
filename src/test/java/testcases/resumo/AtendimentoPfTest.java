package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPage;

import static org.testng.AssertJUnit.assertEquals;


public class AtendimentoPfTest extends BaseTest {


    @Test
    public void deveCriarAtendimentoPf() {
        AtendimentoPage atendimentoPage = new AtendimentoPage(driver);
        atendimentoPage.clicarNovoAtendimento();
        atendimentoPage.escreverDescricaoAtendimento();
        atendimentoPage.salvarAtendimento();
        String textoDescricaoAtendimentoTela = atendimentoPage.pesquisarAtendimento();

        assertEquals("Novo Atendimento Automacao", textoDescricaoAtendimentoTela);

        atendimentoPage.excluirAtendimento();

    }


}
