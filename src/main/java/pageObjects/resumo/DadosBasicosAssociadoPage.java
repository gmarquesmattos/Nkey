package pageObjects.resumo;

import base.BasePage;
import db.CamposBanco;
import db.DadosBasicosDb;
import org.apache.logging.log4j.util.SystemPropertiesPropertySource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.home.MenuLateralPage;
import pageObjects.pessoa.PessoaFisicaPage;

import java.io.IOException;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;

public class DadosBasicosAssociadoPage extends BasePage {

    private By rotuloNomeCompleto = By.id("s_6_1_17_0");
    private By rotuloDataNascimento = By.id("s_6_1_11_0");
    private By rotuloEstadoCivil = By.id("s_6_1_5_0");
    private By rotuloCpf = By.id("s_6_1_8_0");
    private By rotuloRg = By.id("s_6_1_12_0");
    private By rotuloAssociadoDesde = By.id("s_6_1_6_0");
    private By rotuloGrupoEconomico = By.id("s_6_1_9_0");
    private By rotuloCbo = By.id("s_6_1_7_0");

    public DadosBasicosAssociadoPage(WebDriver driver) {
        super(driver);
    }

    public DadosBasicosAssociadoPage acessarDadosBasicosAssociado() {
        MenuLateralPage menuLateralPage = new MenuLateralPage(driver);
        menuLateralPage.acessarPessoaFisica();

        PessoaFisicaPage pessoaFisicaPage = new PessoaFisicaPage(driver);
        pessoaFisicaPage.pesquisarPessoa()
                .acessarNomeCompleto();
        return this;
    }


    public DadosBasicosAssociadoPage verificarNomeCompleto() throws IOException, SQLException {
        DadosBasicosDb dadosBasicosDb = new DadosBasicosDb();
        String resultadoConsulta = dadosBasicosDb.retornarDadosBasicosDb(CamposBanco.NOME_COMPLETO);
        String textoTela = obterTexto(rotuloNomeCompleto).trim();
        assertEquals(resultadoConsulta, textoTela);
        return this;
    }
}
