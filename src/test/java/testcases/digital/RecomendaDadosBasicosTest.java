package testcases.digital;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.digital.RecomendaDadosBasicosPage;
import pageObjects.pessoa.DetalhesDaPessoajuridicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class RecomendaDadosBasicosTest extends BaseTest {

    @Test(dataProvider = "cnpjDigital",retryAnalyzer = Retentativa.class)
    public void deveraRetornarMensagemRecomendarDadosBasicosPessoaJuridica(String cnpjDigital) {
        DetalhesDaPessoajuridicaPage detalhesDaPessoajuridicaPage = new DetalhesDaPessoajuridicaPage();
        detalhesDaPessoajuridicaPage.pesquisarPessoaJuridica(cnpjDigital);
        detalhesDaPessoajuridicaPage.clicarBotaoRecomendarPS();
        RecomendaDadosBasicosPage recomendaDadosBasicosPage = new RecomendaDadosBasicosPage();
        String textoObtido = recomendaDadosBasicosPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }

}
