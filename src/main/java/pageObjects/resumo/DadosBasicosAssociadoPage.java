package pageObjects.resumo;

import base.BasePage;
import db.CamposPessoaFisica;
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

    public String obterValor(CamposPessoaFisica campo) {

        return obterTexto(retornarValorBy(campo)).trim();
    }

    private By retornarValorBy(CamposPessoaFisica campo) {
        By elemento = null;
        switch (campo) {
            case NOME_COMPLETO:
                elemento = rotuloNomeCompleto;
                break;
            case DATA_NASCIMENTO:
                elemento = rotuloDataNascimento;
                break;
            case ESTADO_CIVIL:
                elemento = rotuloEstadoCivil;
                break;
            case CPF:
                elemento = rotuloCpf;
                break;
            case RG:
                elemento= rotuloRg;
                break;
            case ASSOCIADO_DESDE:
                elemento = rotuloAssociadoDesde;
                break;
            case GRUPO_ECONOMICO:
                elemento =  rotuloGrupoEconomico;
                break;
            case CBO:
                elemento =  rotuloCbo;
                break;
        }
        return  elemento;

    }

    private DadosBasicosAssociadoPage acessarDadosBasicosAssociado() {
        HomePage pessoaFisica = new HomePage(driver);
        pessoaFisica.acessarPessoaFisica();

        new PessoaFisicaPage(driver);

        return this;
    }

}
