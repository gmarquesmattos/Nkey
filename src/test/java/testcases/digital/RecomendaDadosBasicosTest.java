package testcases.digital;

import base.BaseTest;
import base.MyRetry;
import org.testng.annotations.Test;
import pageObjects.digital.RecomendaDadosBasicosPage;
import pageObjects.pessoa.DetalhesDaPessoajuridicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class RecomendaDadosBasicosTest extends BaseTest {

    @Test(dataProvider = "cnpjDigital",retryAnalyzer = MyRetry.class)
    public void deveraComprarMensagemRecomendarDadosBasicosPessoaJuridica(String cnpjDigital) {
        DetalhesDaPessoajuridicaPage detalhesDaPessoajuridicaPage = new DetalhesDaPessoajuridicaPage(driver);
        detalhesDaPessoajuridicaPage.pesquisarPessoaJuridica(cnpjDigital);
        detalhesDaPessoajuridicaPage.clicarBotaoRecomendarPS();
        RecomendaDadosBasicosPage recomendaDadosBasicosPage = new RecomendaDadosBasicosPage(driver);
        String textoObtido = recomendaDadosBasicosPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }

}
