package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPjPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtendimentoPjTest extends BaseTest {

    @Test
    public void deveCriarAtendimentoPj() {
        AtendimentoPjPage atendimentoPjPage = new AtendimentoPjPage(driver);
        atendimentoPjPage.irParaAtendimentoPJ();
        atendimentoPjPage.criarNovoAtendimento();
        atendimentoPjPage.escreverDescricaoAtendimento();
        atendimentoPjPage.selecionarAgenciaAtendimento();
        atendimentoPjPage.salvarAtendimento();
        String textoDescricaoAtendimentoPj = atendimentoPjPage.pesquisarAtendimentoPj();
        assertEquals("Novo Atendimento Automacao PJ", textoDescricaoAtendimentoPj);
        atendimentoPjPage.excluirAtedimentoPj();
    }
}
