package testcases.digital;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.digital.RecomendaDadosBasicosPage;
import pageObjects.pessoa.DetalhesDaPessoajuridicaPage;

import static org.testng.AssertJUnit.assertEquals;

public class RecomendaDadosBasicosTest extends BaseTest {

    @Test(retryAnalyzer = Retentativa.class)
    public void deveRetornarMensagemRecomendarDadosBasicosPessoaJuridica() {
        DetalhesDaPessoajuridicaPage detalhesDaPessoajuridicaPage = new DetalhesDaPessoajuridicaPage();
        detalhesDaPessoajuridicaPage.pesquisarPessoaJuridica(CNPJ_DIGITAL_0718);
        detalhesDaPessoajuridicaPage.clicarBotaoRecomendarPS();
        RecomendaDadosBasicosPage recomendaDadosBasicosPage = new RecomendaDadosBasicosPage();
        String textoObtido = recomendaDadosBasicosPage.mensagemPaginaRecomendaDadosBasicos();
        String textoEsperado = "Sicredi RecomendaDados básicos";

        assertEquals(textoEsperado, textoObtido);
    }

}
