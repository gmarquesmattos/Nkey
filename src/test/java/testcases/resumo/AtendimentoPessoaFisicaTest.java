package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPessoaFisicaPage;
import static org.testng.AssertJUnit.assertEquals;


public class AtendimentoPessoaFisicaTest extends BaseTest {


    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtendimentoPessoaFisica() {
        AtendimentoPessoaFisicaPage atendimentoPessoaFisicaPage = new AtendimentoPessoaFisicaPage();
        atendimentoPessoaFisicaPage.pesquisarPessoaFisica(CPF_JOAO_CATAVENTO);
        atendimentoPessoaFisicaPage.acessarAtendimento();
        atendimentoPessoaFisicaPage.realizarNovoAtendimento();
        atendimentoPessoaFisicaPage.escreverDescricaoAtendimento();
        atendimentoPessoaFisicaPage.selecionarAgenciaAtendimento();
        atendimentoPessoaFisicaPage.salvarAtendimento();
        String textoDescricaoAtendimentoTela = atendimentoPessoaFisicaPage.retornarTextoDescricaoAtendimento();
        String descricaoEsperada = "[TESTE]-Novo Atendimento Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtendimentoTela);

        atendimentoPessoaFisicaPage.pesquisarAtendimento();
        atendimentoPessoaFisicaPage.selecionarResponsavelAtendimento(USUARIO_RESPONSAVEL_PRODUCAO);
        atendimentoPessoaFisicaPage.cancelarAtendimento();
    }

}
