package testcases.resumo;

import base.BaseTest;
import db.CamposBanco;
import db.DadosBasicosDb;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.resumo.DadosBasicosAssociadoPage;

import java.io.IOException;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class DadosBasicosAssociadoTest extends BaseTest {
    String nomeCompletoTela;
    String dataNascimentoTela;
    String estadoCivilTela;
    String cpfTela;
    String rgTela;
    String associadoDesdeTela;
    String grupoEconomicoTela;
    String cboTela;
    String nomeCompletoBanco;
    String dataNascimentoBanco;
    String estadoCivilBanco;
    String cpfBanco;
    String rgBanco;
    String associadoDesdeBanco;
    String grupoEconomicoBanco;
    String cboBanco;

    @BeforeTest
    public void deveriaPegarAlgoTela() {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);

        nomeCompletoTela = dadosBasicosPage.obterValor(CamposBanco.NOME_COMPLETO);
        dataNascimentoTela = dadosBasicosPage.obterValor(CamposBanco.DATA_NASCIMENTO);
        estadoCivilTela = dadosBasicosPage.obterValor(CamposBanco.ESTADO_CIVIL);
        cpfTela = dadosBasicosPage.obterValor(CamposBanco.CPF);
        rgTela = dadosBasicosPage.obterValor(CamposBanco.RG);
        associadoDesdeTela = dadosBasicosPage.obterValor(CamposBanco.ASSOCIADO_DESDE);
        grupoEconomicoTela = dadosBasicosPage.obterValor(CamposBanco.GRUPO_ECONOMICO);
        cboTela = dadosBasicosPage.obterValor(CamposBanco.CBO);

    }

    @Test
    public void deveriaVerificarNomeCompletoAssociado() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        nomeCompletoBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.NOME_COMPLETO);
        assertEquals(nomeCompletoBanco, nomeCompletoTela);
    }

    @Test
    public void deveriaVerificarDataNascimento() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        dataNascimentoBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.DATA_NASCIMENTO);
        assertEquals(dataNascimentoBanco, dataNascimentoTela);
    }

    @Test
    public void deveriaVerificarEstadoCivil() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        estadoCivilBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.ESTADO_CIVIL);
        assertEquals(estadoCivilBanco, estadoCivilTela);
    }

    @Test
    public void deveriaVerificarCpf() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        cpfBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.CPF);
        assertEquals(cpfBanco, cpfTela);
    }

    @Test
    public void deveriaVerificarRg() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        rgBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.RG);
        assertEquals(rgBanco, rgTela);
    }

    @Test
    public void deveriaVerificarAssociadoDesde() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        associadoDesdeBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.ASSOCIADO_DESDE);
        assertEquals(associadoDesdeBanco, associadoDesdeTela);
    }

    @Test
    public void deveriaVerificarGrupoEconomico() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        grupoEconomicoBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.GRUPO_ECONOMICO);
        assertEquals(grupoEconomicoBanco, grupoEconomicoTela);
    }

    @Test
    public void deveriaVerificarCbo() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        cboBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.CBO);
        assertEquals(cboBanco, cboTela);
    }

}
