package testcases.LGSolicitacao;

import base.BaseSolicitacaoTest;
import org.testng.annotations.Test;
import pageObjects.LgSolicitacao.Home.HomePage;

import static org.testng.Assert.assertEquals;

public class LgSolicitacaoTeste extends BaseSolicitacaoTest {


    @Test
    public void deveAcessarAplicação() {
        HomePage homePage = new HomePage();
        homePage.getTextoUsuariologado();

        esperar(6000);
        assertEquals(TEXTO_USUARIO_LOGIN, homePage.getTextoUsuariologado());

    }


}
