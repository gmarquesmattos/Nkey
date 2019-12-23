package testcases.resumo;


import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePessoaJuridicaPage;
import static org.testng.AssertJUnit.assertEquals;

public class AtividadePessoaJuridicaTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtividadePessoaJuridica(){
      AtividadePessoaJuridicaPage atividadePessoaJuridicaPage = new AtividadePessoaJuridicaPage();
      atividadePessoaJuridicaPage.pesquisarPessoaJuridica(CNPJ_SOLUCOES_0718);
      atividadePessoaJuridicaPage.acessarAtividade();
      atividadePessoaJuridicaPage.criarAtividade();
      atividadePessoaJuridicaPage.escreverAtividade();
      atividadePessoaJuridicaPage.selecionarAgenciaAtividade();
      atividadePessoaJuridicaPage.salvarAtividade();
      String textoDescricaoAtividadeTela = atividadePessoaJuridicaPage.retornarTextoDescricaoAtividade();
      String descricaoEsperada = "[TESTE]-Nova Atividade Automacao PJ";

      assertEquals(descricaoEsperada,textoDescricaoAtividadeTela);

      atividadePessoaJuridicaPage.pesquisarAtividade();
      atividadePessoaJuridicaPage.selecionarResponsavelAtividade(USUARIO_RESPONSAVEL_0718);
      atividadePessoaJuridicaPage.excluirAtividade();

   }
}
