package testcases.resumo;

import base.BaseTest;
import db.CamposBanco;
import db.DadosBasicosDb;
import org.testng.annotations.Test;
import pageObjects.resumo.DadosBasicosAssociadoPage;

import java.io.IOException;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class DadosBasicosAssociadoTest extends BaseTest {


    @Test
    public void deveriaVerificarNomeCompletoAssociado() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        dadosBasicosPage.acessarDadosBasicosAssociado();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.NOME_COMPLETO);

        String textoTela = obterTexto(rotuloNomeCompleto).trim();
        assertEquals(resultadoConsulta, textoTela);

    }

}
