package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPjPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtendimentoPjTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class, dataProvider = "cnpjSolucaoFinanceiraCoop0718")
    public void deveCriarAtendimentoPj(String cnpj) {
        AtendimentoPjPage atendimentoPjPage = new AtendimentoPjPage();
        atendimentoPjPage.pesquisarPessoaJuridica(cnpj);
        atendimentoPjPage.acessarAtendimento();
        atendimentoPjPage.criarNovoAtendimento();
        atendimentoPjPage.escreverDescricaoAtendimento();
        atendimentoPjPage.selecionarAgenciaAtendimento();
        atendimentoPjPage.salvarAtendimento();
        String textoDescricaoAtendimentoPj = atendimentoPjPage.pesquisarAtendimentoPj();

        assertEquals("[TESTE]-Novo Atendimento Automacao PJ", textoDescricaoAtendimentoPj);

        atendimentoPjPage.excluirAtedimentoPj();
    }
}
