package testcases.resumo;


import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePjPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtividadePjTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveCriarAtividadePj(){
      AtividadePjPage atividadePjPage = new AtividadePjPage();
      atividadePjPage.pesquisarPessoaJuridica(CNPJ_SOLUCOES_0718);
      atividadePjPage.acessarAtividade();
      atividadePjPage.criarAtividade();
      atividadePjPage.escreverAtividade();
      atividadePjPage.selecionarAgenciaAtividade();
      atividadePjPage.salvarAtividade();

      String textoDescricaoAtividadeTela = atividadePjPage.pesquisarAtividade();
      String descricaoEsperada = "[TESTE]-Nova Atividade Automacao PJ";

      assertEquals(descricaoEsperada,textoDescricaoAtividadeTela);

      atividadePjPage.excluirAtividade();

   }
}
