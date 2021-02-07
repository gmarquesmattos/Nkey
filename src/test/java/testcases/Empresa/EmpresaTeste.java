package testcases.Empresa;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Empresa.EmpresaPage;
import pageObjects.Home.HomePage;

import javax.swing.*;

import static org.testng.Assert.assertEquals;

public class EmpresaTeste extends BaseTest {


    @Test
    public void deveAcesarMenuEmpresa() {
        HomePage homePage = new HomePage();
        homePage.clicarBotaoEmpresa();
        EmpresaPage empresaPage = new EmpresaPage();

        assertEquals(TEXTO_TITULO_EMPRESA, empresaPage.getTextoEmpresa());

    }

    @Test
    public void deveAcessarTelaNovaEmpresa() {
        HomePage homePage = new HomePage();
        homePage.clicarBotaoEmpresa();
        EmpresaPage empresaPage = new EmpresaPage();
        empresaPage.clicarNovaEmpresa();
        assertEquals(TEXTO_NOVA_EMPRESA, empresaPage.getTextoModalEmpresa());


    }

    @Test
    public void deveCriarNovaEmpresa() {
        HomePage homePage = new HomePage();
        homePage.clicarBotaoEmpresa();
        EmpresaPage empresaPage = new EmpresaPage();
        empresaPage.clicarNovaEmpresa();
        empresaPage.CadastroNovaEmpresa(NOME_EMPRESA,VALOR_SEGMENTO,SITE,EMAIL,TELEFONE_PRINCIPAL,TELEFONE_SECUNDARIO,TELEFONE_WHATSAPP,TEXTO_RAZAO_SOCIAL,ENDERECO,NUMERO,COMPLE,BAIRRO,CIDADE,ESTADO,TEXTO_OBS);
        empresaPage.clicarBotaoSalvar();
        assertEquals(TEXTO_EMPRESA_SALVA, empresaPage.getTextoEmpresaSalvaComSucesso());


    }
    @Test
    public void NaoDeveCriarNovaEmpresaSemNome() {
        HomePage homePage = new HomePage();
        homePage.clicarBotaoEmpresa();
        EmpresaPage empresaPage = new EmpresaPage();
        empresaPage.clicarNovaEmpresa();
        esperar(3000);
        empresaPage.CadastroNovaEmpresaSemNome(NOME_EMPRESA, VALOR_SEGMENTO,SITE,EMAIL,TELEFONE_PRINCIPAL,TELEFONE_SECUNDARIO,TELEFONE_WHATSAPP,TEXTO_RAZAO_SOCIAL,ENDERECO,NUMERO,COMPLE,BAIRRO,CIDADE,ESTADO,TEXTO_OBS);
        empresaPage.clicarBotaoSalvar();
        assertEquals(TEXTO_EMPRESA_NAO_SALVA, empresaPage.getTextoEmpresaNaoSalva());


    }

}