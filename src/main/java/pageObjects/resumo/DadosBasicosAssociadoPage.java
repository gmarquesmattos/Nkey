package pageObjects.resumo;

import base.BasePage;
import db.CamposBanco;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

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
        acessarDadosBasicosAssociado();
    }

    public String obterValor(CamposBanco campo) {

        return obterTexto(retornarValorBy(campo)).trim();
    }

    private By retornarValorBy(CamposBanco campo) {

        switch (campo) {
            case NOME_COMPLETO:
                return rotuloNomeCompleto;
            case DATA_NASCIMENTO:
                return rotuloDataNascimento;
            case ESTADO_CIVIL:
                return rotuloEstadoCivil;
            case CPF:
                return rotuloCpf;
            case RG:
                return rotuloRg;
            case ASSOCIADO_DESDE:
                return rotuloAssociadoDesde;
            case GRUPO_ECONOMICO:
                return rotuloGrupoEconomico;
            case CBO:
                return rotuloCbo;
            default:
                By naoDefinido = null;
                return naoDefinido;


        }

    }

    private DadosBasicosAssociadoPage acessarDadosBasicosAssociado() {
        HomePage pessoaFisica = new HomePage(driver);
        pessoaFisica.acessarPessoaFisica();

        PessoaFisicaPage pessoaFisicaPage = new PessoaFisicaPage(driver);
        pessoaFisicaPage.pesquisarPessoa()
                .acessarNomeCompleto();
        return this;
    }

}
