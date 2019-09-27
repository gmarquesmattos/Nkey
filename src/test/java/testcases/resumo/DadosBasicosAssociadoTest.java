package testcases.resumo;

import base.BaseTest;
import db.CamposPessoaFisica;
import db.DadosBasicosDb;
import org.testng.annotations.*;
import pageObjects.resumo.DadosBasicosAssociadoPage;

import java.io.IOException;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class DadosBasicosAssociadoTest extends BaseTest {

    @Test
    public void deveriaPegarAlgoTela() {
        DadosBasicosAssociadoPage dadosBasicosPage = new DadosBasicosAssociadoPage(driver);
        for (CamposPessoaFisica campo : CamposPessoaFisica.values()) {
            campo.setCampo(dadosBasicosPage.obterValor(campo));
        }
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarNomeCompletoAssociado() throws IOException, SQLException {
        String nomeCompletoTela = CamposPessoaFisica.NOME_COMPLETO.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String nomeCompletoBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.NOME_COMPLETO);

        assertEquals(nomeCompletoBanco, nomeCompletoTela);
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarDataNascimento() throws IOException, SQLException {
        String dataNascimentoTela = CamposPessoaFisica.DATA_NASCIMENTO.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String dataNascimentoBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.DATA_NASCIMENTO);

        assertEquals(dataNascimentoBanco, dataNascimentoTela);
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarEstadoCivil() throws IOException, SQLException {
        String estadoCivilTela = CamposPessoaFisica.ESTADO_CIVIL.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String estadoCivilBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.ESTADO_CIVIL);

        assertEquals(estadoCivilBanco, estadoCivilTela);
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarCpf() throws IOException, SQLException {
        String cpfTela = CamposPessoaFisica.CPF.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String cpfBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.CPF);

        assertEquals(cpfBanco, cpfTela);
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarRg() throws IOException, SQLException {
        String rgTela = CamposPessoaFisica.RG.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String rgBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.RG);

        assertEquals(rgBanco, rgTela);
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarAssociadoDesde() throws IOException, SQLException {
        String associadoDesdeTela = CamposPessoaFisica.ASSOCIADO_DESDE.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String associadoDesdeBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.ASSOCIADO_DESDE);

        assertEquals(associadoDesdeBanco, associadoDesdeTela);
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarGrupoEconomico() throws IOException, SQLException {
        String grupoEconomicoTela = CamposPessoaFisica.GRUPO_ECONOMICO.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String grupoEconomicoBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.GRUPO_ECONOMICO);

        assertEquals(grupoEconomicoBanco, grupoEconomicoTela);
    }

    @AfterTest(alwaysRun = true)
    public void deveriaVerificarCbo() throws IOException, SQLException {
        String cboTela = CamposPessoaFisica.CBO.getCampo();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String cboBanco = dadosBasicosDb.retornarDadosBasicosDb(CamposPessoaFisica.CBO);

        assertEquals(cboBanco, cboTela);
    }

}
