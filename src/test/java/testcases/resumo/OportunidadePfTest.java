package testcases.resumo;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.resumo.OportunidadesPage;

public class OportunidadePfTest extends BaseTest {


    @Test
    public void DeveriaCriarOportunidade() {
        new OportunidadesPage(driver)
                .criarNovaOportunidade();


    }


}
