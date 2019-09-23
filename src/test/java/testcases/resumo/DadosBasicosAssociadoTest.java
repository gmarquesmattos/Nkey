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
        String textoTela = dadosBasicosPage.obterNomeCompleto();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.NOME_COMPLETO);
        assertEquals(resultadoConsulta, textoTela);
    }
    @Test
    public void deveriaVerificarDataNascimento() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        String textoTela = dadosBasicosPage.obterDataNascimento();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.DATA_NASCIMENTO);
        assertEquals(resultadoConsulta, textoTela);
    }
    @Test
    public void deveriaVerificarEstadoCivil() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        String textoTela = dadosBasicosPage.obterEstadoCivil();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.ESTADO_CIVIL);
        assertEquals(resultadoConsulta, textoTela);
    }
    @Test
    public void deveriaVerificarCpf() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        String textoTela = dadosBasicosPage.obterCpf();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.CPF);
        assertEquals(resultadoConsulta, textoTela);
    }
    @Test
    public void deveriaVerificarRg() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        String textoTela = dadosBasicosPage.obterRg();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.RG);
        assertEquals(resultadoConsulta, textoTela);
    }
    @Test
    public void deveriaVerificarAssociadoDesde() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        String textoTela = dadosBasicosPage.obterAssociadoDesde();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.ASSOCIADO_DESDE);
        assertEquals(resultadoConsulta, textoTela);
    }
    public void deveriaVerificarGrupoEconomico() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        String textoTela = dadosBasicosPage.obterGrupoEconomico();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.GRUPO_ECONOMICO);
        assertEquals(resultadoConsulta, textoTela);
    }
    public void deveriaVerificarCbo() throws IOException, SQLException {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        String textoTela = dadosBasicosPage.obterCbo();

        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.CBO);
        assertEquals(resultadoConsulta, textoTela);
    }

}
