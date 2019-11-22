package testcases.resumo;

import base.BaseTest;
import database.DadosBasicosDb;
import org.testng.asserts.SoftAssert;
import pageObjects.resumo.DadosBasicosAssociadoPage;
import java.util.ArrayList;

public class DadosBasicosAssociadoTest extends BaseTest {

  //  @Test(retryAnalyzer = Retentativa.class,dataProvider = "cpfNaoDigital")
    public void deveRetornarRotulosAssociadoTela(String cpf) {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        ArrayList<String> informacoesAssociadoBancoResumo = dadosBasicosDb.retornarDadosBasicosDb(cpf);

        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage();
        dadosBasicosPage.pesquisarPessoaFisica(cpf);
        ArrayList<String> informacoesAssociadoTelaResumo = dadosBasicosPage.obterValor();
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEqualsNoOrder(informacoesAssociadoBancoResumo.toArray(), informacoesAssociadoTelaResumo.toArray());

        softAssert.assertAll();
    }
}




