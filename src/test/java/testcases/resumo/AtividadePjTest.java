package testcases.resumo;


import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtividadePjPage;

public class AtividadePjTest extends BaseTest {

    @Test
    public void deveCriarAtividadePj(){
      AtividadePjPage atividadePjPage = new AtividadePjPage(driver);
      atividadePjPage.criarAtividade();
      atividadePjPage.escreverAtividade();
      atividadePjPage.salvarAtividade();

   //   atividadePjPage.excluirAtividade();

    }
}
