package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPessoaJuridicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtendimentoPessoaJuridicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtendimentoPessoaJuridica() {
        AtendimentoPessoaJuridicaPage atendimentoPessoaJuridicaPage = new AtendimentoPessoaJuridicaPage();
        atendimentoPessoaJuridicaPage.pesquisarPessoaJuridica(CNPJ_SOLUCOES_0718);
        atendimentoPessoaJuridicaPage.acessarAtendimento();
        atendimentoPessoaJuridicaPage.criarNovoAtendimento();
        atendimentoPessoaJuridicaPage.escreverDescricaoAtendimento();
        atendimentoPessoaJuridicaPage.selecionarAgenciaAtendimento();
        atendimentoPessoaJuridicaPage.salvarAtendimento();
        String textoDescricaoAtendimento = atendimentoPessoaJuridicaPage.retornarTextoDescricaoAtendimento();

        assertEquals("[TESTE]-Novo Atendimento Automacao PJ", textoDescricaoAtendimento);

        atendimentoPessoaJuridicaPage.pesquisarAtendimento();
        atendimentoPessoaJuridicaPage.selecionarResponsavelAtendimento(USUARIO_RESPONSAVEL_0718);
        atendimentoPessoaJuridicaPage.cancelarAtedimento();
    }
}
