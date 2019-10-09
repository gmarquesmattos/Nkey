package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

import java.util.ArrayList;

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
        acessar();
    }

    public ArrayList<String> obterValor() {

        ArrayList<String> informacoesResumoAssociado = new ArrayList<String>();
        informacoesResumoAssociado.add(obterTexto(rotuloNomeCompleto).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloDataNascimento).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloEstadoCivil).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloCpf).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloRg).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloAssociadoDesde).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloGrupoEconomico).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloCbo).trim());

        return informacoesResumoAssociado;
    }

    private DadosBasicosAssociadoPage acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
        new PessoaFisicaPage(driver);
        return this;
    }

}
