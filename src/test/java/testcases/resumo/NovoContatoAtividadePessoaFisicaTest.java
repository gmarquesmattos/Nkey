package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.BarraBotoesTelaRelacionamentoPage;
import pageObjects.pessoa.DetalheDaPessoaFisicaPage;
import pageObjects.resumo.AtividadePessoaFisicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class NovoContatoAtividadePessoaFisicaTest  extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarNovaAtividadePessoaFisica(){

        AtividadePessoaFisicaPage atividadePessoaFisicaPage = new AtividadePessoaFisicaPage();
        DetalheDaPessoaFisicaPage detalheDaPessoaFisicaPage = new DetalheDaPessoaFisicaPage();
        atividadePessoaFisicaPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        new BarraBotoesTelaRelacionamentoPage().criarNovoContatoAtividade();
        atividadePessoaFisicaPage.adicionarNovaAtividade();
        atividadePessoaFisicaPage.escreverDescricaoAtividade();
        atividadePessoaFisicaPage.selecionarAgenciaAtividade();
        atividadePessoaFisicaPage.salvarAtividade();

        String textoDescricao = atividadePessoaFisicaPage.retornarTextoDescricaoAtividade();
        String descricaoEsperada = "[TESTE]-Nova Atividade Automacao PF";
        String cpf = detalheDaPessoaFisicaPage.retornarNumeroCpf();

        assertEquals(descricaoEsperada,textoDescricao);
        assertEquals(CPF_SOLUCOES_0718, cpf);

        atividadePessoaFisicaPage.pesquisarAtividade();
        atividadePessoaFisicaPage.selecionarResponsavelAtividade(USUARIO_RESPONSAVEL_0718);
        atividadePessoaFisicaPage.cancelarAtividade();
    }
}
