package testcases.resumo;


import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePjPage;

import static org.testng.AssertJUnit.assertEquals;

public class AtividadePjTest extends BaseTest {

    @Test
    public void deveCriarAtividadePj(){
      AtividadePjPage atividadePjPage = new AtividadePjPage();
      atividadePjPage.criarAtividade();
      atividadePjPage.escreverAtividade();
      atividadePjPage.selecionarAgenciaAtividade();
      atividadePjPage.salvarAtividade();

      String textoDescricaoAtividadeTela = atividadePjPage.pesquisarAtividade();
      String descricaoEsperada = "Nova Atividade Automacao PJ";
      assertEquals(descricaoEsperada,textoDescricaoAtividadeTela);
      atividadePjPage.excluirAtividade();

   }
}
