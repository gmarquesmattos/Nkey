package testcases.Regressao;

import base.BaseTest;
import db.DadosBasicosDb;
import org.testng.annotations.Test;
import pageObjects.home.MenuLateralPO;
import pageObjects.pessoaFisica.DadosBasicosPO;
import pageObjects.pessoaFisica.PessoaFisicaPO;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class DadosBasicosTest extends BaseTest {


    @Test
    public void testConsultarDadosBasicos() {
        PessoaFisicaPO pessoaFisicaPage = new PessoaFisicaPO();
        DadosBasicosPO dadosBasicosPage = new DadosBasicosPO();
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();

        List<String> dadosPage = new ArrayList<String>();
        List<String> dadosDb = new ArrayList<String>();
        MenuLateralPO menuLateralPage = new MenuLateralPO();
        realizarLogin();
        menuLateralPage.acessarPessoaFisica();
        pessoaFisicaPage.pesquisar();
        pessoaFisicaPage.drillNomeCompleto();

        dadosDb = dadosBasicosDb.retornarDadosBasicosDb();
        dadosPage.add(dadosBasicosPage.obterNomeCompleto().trim());
        dadosPage.add(dadosBasicosPage.obterDataNascimento().trim());
        dadosPage.add(dadosBasicosPage.obterEstadoCivil().trim());
        dadosPage.add(dadosBasicosPage.obterCpf().trim());
        dadosPage.add(dadosBasicosPage.obterRg().trim());
        dadosPage.add(dadosBasicosPage.obterAssociadoDesde().trim());
        dadosPage.add(dadosBasicosPage.obterGrupoEconomico().trim());
        dadosPage.add(dadosBasicosPage.obterCbo().trim());

        for (int i = 0; i < dadosPage.size(); i++) {
            assertEquals(dadosDb.get(i), dadosPage.get(i));
        }
        assertEquals(8, dadosPage.size());
    }

}
