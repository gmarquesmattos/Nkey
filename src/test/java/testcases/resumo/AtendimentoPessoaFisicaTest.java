package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPessoaFisicaPage;
import static org.testng.AssertJUnit.assertEquals;


public class AtendimentoPessoaFisicaTest extends BaseTest {


    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtendimentoPessoaFisica() {
        AtendimentoPessoaFisicaPage atendimentoPage = new AtendimentoPessoaFisicaPage();
        atendimentoPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        atendimentoPage.acessarAtendimento();
        atendimentoPage.realizarNovoAtendimento();
        atendimentoPage.escreverDescricaoAtendimento();
        atendimentoPage.selecionarAgenciaAtendimento();
        atendimentoPage.salvarAtendimento();
        String textoDescricaoAtendimentoTela = atendimentoPage.retornarTextoDescricaoAtendimento();
        String descricaoEsperada = "[TESTE]-Novo Atendimento Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtendimentoTela);

        atendimentoPage.pesquisarAtendimento();
        atendimentoPage.selecionarResponsavelAtendimento(USUARIO_RESPONSAVEL);
        atendimentoPage.excluirAtendimento();
    }

}
