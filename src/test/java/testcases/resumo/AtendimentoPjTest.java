package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPjPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtendimentoPjTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtendimentoPj() {
        AtendimentoPjPage atendimentoPjPage = new AtendimentoPjPage();
        atendimentoPjPage.pesquisarPessoaJuridica(CNPJ_SOLUCOES_0718);
        atendimentoPjPage.acessarAtendimento();
        atendimentoPjPage.criarNovoAtendimento();
        atendimentoPjPage.escreverDescricaoAtendimento();
        atendimentoPjPage.selecionarAgenciaAtendimento();
        atendimentoPjPage.salvarAtendimento();
        String textoDescricaoAtendimentoPj = atendimentoPjPage.pesquisarAtendimentoPj();

        assertEquals("[TESTE]-Novo Atendimento Automacao PJ", textoDescricaoAtendimentoPj);

        atendimentoPjPage.pesquisarAtendimento();
        atendimentoPjPage.selecionarResponsavelAtendimento();
        atendimentoPjPage.excluirAtedimentoPj();
    }
}
