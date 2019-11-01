package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class AtividadePjPage extends BasePage {

    private By botaoIrParaAtividade =By.cssSelector("button[title='Atividades:Ir para']");
    private By botaoCriarAtividade =By.cssSelector("button[title='Atividades:Novo']");
    private By tabelaDescricaoAtividade =By.id("1_s_1_l_Description");
    private By textoDescricaoAtividade =By.id("1_Description");

    private By  tabelaDescricaoAgencia=By.id("1_s_1_l_Sicredi_Division");
    private By botaopiclistAgencia =By.id("s_1_2_38_0_icon");
    private By botaoOkAgencia =By.cssSelector("button[title='Agência:OK']");
    private By botaoSalvarAtividade =By.cssSelector("button[title='Atividades:Salvar']");
    private By botaoExcluirAtividade =By.cssSelector("button[title='Atividades:Excluir']");

    public AtividadePjPage(WebDriver driver) {
        super(driver);
        acessar();
        clicar(botaoIrParaAtividade);

    }
    public void criarAtividade(){

        clicar(botaoCriarAtividade);

    }
    public void escreverAtividade() {

       clicar(tabelaDescricaoAtividade);
       escrever(textoDescricaoAtividade,"Nova Atividade Automacao PJ");

    }
    public void selecionarAgenciaAtividade(){

        clicar(tabelaDescricaoAgencia);
        clicar(botaopiclistAgencia);
        clicar(botaoOkAgencia);
    }
    public void salvarAtividade(){

        clicar(botaoSalvarAtividade);

    }

    public String pesquisarAtividade() {
        return obterTexto(tabelaDescricaoAtividade);
    }
    public void excluirAtividade(){

        clicar(botaoExcluirAtividade);
        esperaAceitarAlert();
    }

    private void acessar() {
       HomePage homePage = new HomePage(driver);
       homePage.acessarPessoaJuridica();
       PessoaJuridicaPage pessoaJuridicaPage = new PessoaJuridicaPage(driver,"09514327000156");
       pessoaJuridicaPage.acessarRazaoSocial();

    }


}
