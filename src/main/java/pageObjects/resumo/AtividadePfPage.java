package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class AtividadePfPage extends BasePage {

    private By botaoIrParaAtividade = By.id("s_13_1_0_0_Ctrl");
    private By botaoNovaAtividade = By.id("s_1_1_15_0_Ctrl");
    private By tabelaDescricaoAtividade = By.id("1_s_1_l_Description");
    private By textoDescricaoAtividade = By.id("1_Description");
    private By tabelaDescricaoAgencia = By.id("1_s_1_l_Sicredi_Division");
    private By textoAgencia = By.id("s_1_2_38_0_icon");
    private By botaoOk = By.id("s_3_1_63_0_Ctrl");
    private By botaoSalvarAtividade = By.id("s_1_1_20_0_Ctrl");
    private By botaoExcluirAtividade = By.id("s_1_1_4_0_Ctrl");

    public AtividadePfPage() {
            acessar();
    }

    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(cpf).acessarNomeCompleto();
    }

    public void acessarAtividade(){
        clicar(botaoIrParaAtividade);
    }

    public void adicionarNovaAtividade() {
        clicar(botaoNovaAtividade);
    }

    public void escreverDescricaoAtividade() {
        clicar(tabelaDescricaoAtividade);
        escrever(textoDescricaoAtividade, "Nova Atividade Automacao PF");
    }
    public void selecionarAgenciaAtividade() {
        clicar(tabelaDescricaoAgencia);
        clicar(textoAgencia);
        clicar(botaoOk);
    }
    public void salvarAtividade() {
        clicar(botaoSalvarAtividade);
    }

    public void excluirAtividade() {
        clicar(botaoExcluirAtividade);
        esperaAceitarAlert();
    }

    public String pesquisarAtividade() {
        return obterTexto(tabelaDescricaoAtividade);
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();
    }
}
