package testcases.retaguarda.rendaEnviada;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.alterarRenda.AlterarRendaPage;

public class RendaEnviadaPage extends  BaseTest {


        @Test
        public void RendaEnviada() {
            AlterarRendaPage alterarRendaPage = new AlterarRendaPage(driver);
            alterarRendaPage
                    .editarAlterarRenda();
        }
}
