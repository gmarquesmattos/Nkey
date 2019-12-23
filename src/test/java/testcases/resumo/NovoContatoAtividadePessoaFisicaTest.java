package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.BarraBotoesTelaRelacionamentoPage;
import pageObjects.resumo.AtividadePessoaFisicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class NovoContatoAtividadePessoaFisicaTest  extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarNovaAtividadePessoaFisica(){

        AtividadePessoaFisicaPage atividadePessoaFisicaPage = new AtividadePessoaFisicaPage();
        atividadePessoaFisicaPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        new BarraBotoesTelaRelacionamentoPage().criarNovoContatoAtividade();
        atividadePessoaFisicaPage.adicionarNovaAtividade();
        atividadePessoaFisicaPage.escreverDescricaoAtividade();
        atividadePessoaFisicaPage.selecionarAgenciaAtividade();
        atividadePessoaFisicaPage.salvarAtividade();

        String textoDescricao = atividadePessoaFisicaPage.retornarTextoDescricaoAtividade();
        String descricaoEsperada = "[TESTE]-Nova Atividade Automacao PF";

        assertEquals(descricaoEsperada,textoDescricao);

        atividadePessoaFisicaPage.pesquisarAtividade();
        atividadePessoaFisicaPage.selecionarResponsavelAtividade(USUARIO_RESPONSAVEL_0718);
        atividadePessoaFisicaPage.excluirAtividade();
    }
}
