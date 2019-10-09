package testcases.resumo;

import base.BaseTest;
import db.DadosBasicosDb;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.resumo.DadosBasicosAssociadoPage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

public class DadosBasicosAssociadoTest extends BaseTest {

    @Test
    public void deveriaRetornarRotulosAssociadoTela() {

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        ArrayList<String> informacoesAssociadoBancoResumo = dadosBasicosDb.retornarDadosBasicosDb();

        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        ArrayList<String> informacoesAssociadoTelaResumo = dadosBasicosPage.obterValor();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEqualsNoOrder(informacoesAssociadoBancoResumo.toArray(),informacoesAssociadoTelaResumo.toArray());
        softAssert.assertAll();
    }
}




