package pageObjects.resumo;

import base.BasePage;
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

    private DadosBasicosAssociadoPage acessarDadosBasicosAssociado() {
       HomePage pessoaFisica = new HomePage(driver);
        pessoaFisica.acessarPessoaFisica();

        PessoaFisicaPage pessoaFisicaPage = new PessoaFisicaPage(driver);
        pessoaFisicaPage.pesquisarPessoa()
                .acessarNomeCompleto();
        return this;
    }

    public String obterNomeCompleto(){
         return  obterTexto(rotuloNomeCompleto).trim();
    }
    public String obterDataNascimento(){
        return  obterTexto(rotuloDataNascimento).trim();
    }
    public String obterEstadoCivil(){
        return  obterTexto(rotuloEstadoCivil).trim();
    }
    public String obterCpf(){
        return  obterTexto(rotuloCpf).trim();
    }
    public String obterRg(){
        return  obterTexto(rotuloRg).trim();
    }
    public String obterAssociadoDesde(){
        return  obterTexto(rotuloAssociadoDesde).trim();
    }
    public String obterGrupoEconomico(){
        return  obterTexto(rotuloGrupoEconomico).trim();
    }
    public String obterCbo(){
        return  obterTexto(rotuloCbo).trim();
    }


}
