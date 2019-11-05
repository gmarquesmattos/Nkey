package testcases.resumo;

import base.BaseTest;
import base.Tentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPjPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtendimentoPjTest extends BaseTest {

    @Test(retryAnalyzer = Tentativa.class, dataProvider = "cnpjDigital")
    public void deveCriarAtendimentoPj(String cnpj) {
        AtendimentoPjPage atendimentoPjPage = new AtendimentoPjPage(driver);
        atendimentoPjPage.pesquisarPessoaJuridica(cnpj);
        atendimentoPjPage.acessarAtendimento();
        atendimentoPjPage.criarNovoAtendimento();
        atendimentoPjPage.escreverDescricaoAtendimento();
        atendimentoPjPage.selecionarAgenciaAtendimento();
        atendimentoPjPage.salvarAtendimento();
        String textoDescricaoAtendimentoPj = atendimentoPjPage.pesquisarAtendimentoPj();

        assertEquals("Novo Atendimento Automacao PJ", textoDescricaoAtendimentoPj);

        atendimentoPjPage.excluirAtedimentoPj();
    }
}
