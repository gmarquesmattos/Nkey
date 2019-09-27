package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPage;


public class AtendimentoTest extends BaseTest {

    @Test
    public void deveCriaAtendimentoPf() {
        AtendimentoPage atendimentoPage = new AtendimentoPage(driver);
        atendimentoPage.clicarIrAtendimento();

    }
}
