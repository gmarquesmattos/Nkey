package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.pessoa.BarraBotoesTelaRelacionamentoPage;
import pageObjects.resumo.AtendimentoPessoaFisicaPage;
import static org.testng.AssertJUnit.assertEquals;

public class NovoContatoAtendimentoPessoaFisicaTest extends BaseTest {

    @Test (retryAnalyzer = Retentativa.class)
    public void deveCriarNovoContatoAtendimentoPessoaFisica(){
        AtendimentoPessoaFisicaPage atendimentoPessoaFisicaPage = new AtendimentoPessoaFisicaPage();
        atendimentoPessoaFisicaPage.pesquisarPessoaFisica(CPF_SOLUCOES_0718);
        new BarraBotoesTelaRelacionamentoPage().criarNovoContatoAtendimento();
        atendimentoPessoaFisicaPage.realizarNovoAtendimento();
        atendimentoPessoaFisicaPage.escreverDescricaoAtendimento();
        atendimentoPessoaFisicaPage.selecionarAgenciaAtendimento();
        atendimentoPessoaFisicaPage.salvarAtendimento();
        String textoDescricao = atendimentoPessoaFisicaPage.retornarTextoDescricaoAtendimento();
        String descricaoEsperada = "[TESTE]-Novo Atendimento Automacao";

        assertEquals(descricaoEsperada,textoDescricao);

        atendimentoPessoaFisicaPage.pesquisarAtendimento();
        atendimentoPessoaFisicaPage.selecionarResponsavelAtendimento(USUARIO_RESPONSAVEL_0718);

         atendimentoPessoaFisicaPage.cancelarAtendimento();

    }
}
