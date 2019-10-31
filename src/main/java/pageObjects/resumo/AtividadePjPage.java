package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class AtividadePjPage extends BasePage {

    private By botaoCriarAtividade =By.cssSelector("button[title='Atividades:Novo']");
    private By tabelaDescricaoatividade = By.id("1_s_1_l_Description");
    private By textoDescricaoAtividade = By.cssSelector("tr[role ='row'] input[class='siebui-list-ctrl siebui-ctrl-input siebui-align-left siebui-input-align-left s_1_2_44_0']");
    private By botaoSalvarAtividade = By.id("s_1_1_20_0_Ctrl");
    private By botaoExcluirAtividade = By.cssSelector("button[title='Atividades:Excluir']");

    public AtividadePjPage(WebDriver driver) {
        super(driver);
        acessar();

    }
    public void criarAtividade(){

        clicar(botaoCriarAtividade);
    }
    public void escreverAtividade(){

        clicar(tabelaDescricaoatividade);
        escrever(textoDescricaoAtividade,"Nova Atividade Automação Pj");

    }
    public void selecionarCoopAtividade(){



    }

    public void salvarAtividade() {

        clicar(botaoSalvarAtividade);
    }
    public void excluirAtividade(){

        clicar(botaoExcluirAtividade);

    }
    private void acessar() {
       HomePage homePage = new HomePage(driver);
       homePage.acessarPessoaJuridica();
       PessoaJuridicaPage pessoaJuridicaPage  = new PessoaJuridicaPage(driver);
       pessoaJuridicaPage.acessarAtividadePj();
    }
}
