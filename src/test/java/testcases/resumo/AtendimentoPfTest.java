package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPfPage;
import static org.testng.AssertJUnit.assertEquals;


public class AtendimentoPfTest extends BaseTest {


    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtendimentoPf() {
        AtendimentoPfPage atendimentoPage = new AtendimentoPfPage();
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
        atendimentoPage.selecionarResponsavelAtendimento();
        atendimentoPage.excluirAtendimento();
    }

}
