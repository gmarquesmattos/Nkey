package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class OportunidadePjPage extends BasePage {

    private By botaoIrParaAOportunidadePj = By.id("");
    private By botaoNovaOportunidadePj = By.id("s_1_1_8_0_Ctrl");
    private By tabelaAgenciaOportuniade = By.id("1_s_1_l_Sicredi_Agencia");
    private By textoAgenciaOportunidade = By.id("1_Sicredi_Agencia");
    private By tabelaDescricaoOportunidade = By.id("1_s_1_l_Name");
    private By textoDescricaoOportunidade = By.id("1_Name");
    private By botaoSalvarOportunidade = By.id("s_1_1_11_0_Ctrl");
    private By botaoExcluirOportunidade = By.id("s_1_1_3_0_Ctrl");

    public OportunidadePjPage(WebDriver driver) {
        super(driver);
    }

    public void criarNovoOportunidade() {
        clicar(botaoNovaOportunidadePj);
    }

    public void preencherAgenciaOportunidade() {
        clicar(tabelaAgenciaOportuniade);
        escrever(textoAgenciaOportunidade, "UA MANDAGUAÇU");
    }

    public void preencherDescriçãoOportunidade() {
        clicar(tabelaDescricaoOportunidade);
        escrever(textoDescricaoOportunidade, "Novo Oportunidade Automacao PJ");
    }

    public void salvarOportunidade() {
        clicar(botaoSalvarOportunidade);
    }

    public String pesquisarAtendimentoPj() {
        return obterTexto(tabelaDescricaoOportunidade);
    }

    public void excluirOportunidadePj() {
        clicar(botaoExcluirOportunidade);
        esperaAceitarAlert();
    }

    public void pesquisarPessoaJuridica(String cnpj) {
        new PessoaJuridicaPage(driver, cnpj).acessarRazaoSocial();
    }

    private OportunidadePjPage acessar() {
        new HomePage(driver)
                .acessarPessoaJuridica();
        clicar(botaoIrParaAOportunidadePj);
        return this;
    }


}