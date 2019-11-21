package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPessoaJuridicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtendimentoPessoaJuridicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtendimentoPessoaJuridica() {
        AtendimentoPessoaJuridicaPage atendimentoPjPage = new AtendimentoPessoaJuridicaPage();
        atendimentoPjPage.pesquisarPessoaJuridica(CNPJ_SOLUCOES_0718);
        atendimentoPjPage.acessarAtendimento();
        atendimentoPjPage.criarNovoAtendimento();
        atendimentoPjPage.escreverDescricaoAtendimento();
        atendimentoPjPage.selecionarAgenciaAtendimento();
        atendimentoPjPage.salvarAtendimento();
        String textoDescricaoAtendimento = atendimentoPjPage.retornarTextoDescricaoAtendimento();

        assertEquals("[TESTE]-Novo Atendimento Automacao PJ", textoDescricaoAtendimento);

        atendimentoPjPage.pesquisarAtendimento();
        atendimentoPjPage.selecionarResponsavelAtendimento(USUARIO_RESPONSAVEL);
        atendimentoPjPage.excluirAtedimento();
    }
}
