package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class NovoContatoAtendimentoPfPage extends BasePage {

    private By botaoNovoContato =By.cssSelector("#S_A14_tile_3");
    private By botaoNovoContatoAtendimento =By.cssSelector("#BtnAtendimento");
    private By botaoNovoAtendimento =By.cssSelector("button[title='Atendimentos:Novo']");
    private By tabelaDescricaoAtendimento =By.id("1_s_1_l_Description");
    private By textoDescricaoAtendimento =By.id("1_Description");
    private By tabelaDescricaoAgencia=By.id("1_s_1_l_Sicredi_Division");
    private By botaoPicListAgencia =By.id("s_1_2_35_0_icon");
    private By botaoOkAgencia =By.cssSelector("button[title='Agência:OK']");
    private By botaoSalvarAtendimento =By.cssSelector("button[title='Atendimentos:Salvar']");
    private By botaoExcluirAtendimento =By.cssSelector("button[title='Atendimentos:Excluir']");

    public NovoContatoAtendimentoPfPage(){
        acessar();
    }

    public void pesquisarPessoaFisica(String cpf){
        new PessoaFisicaPage(cpf).acessarNomeCompleto();
    }
    public void criarNovoContato(){

        clicar(botaoNovoContato);
        clicar(botaoNovoContatoAtendimento);
    }
    public void criarNovoAtendimento(){

        clicar(botaoNovoAtendimento);

    }
    public void escreverAtendimento(){

        clicar(tabelaDescricaoAtendimento);
        escrever(textoDescricaoAtendimento,"Novo Atendimento Automação PF");

    }
    public void selecionarAgenciaAtendimento(){

        clicar(tabelaDescricaoAgencia);
        clicar(botaoPicListAgencia);
        clicar(botaoOkAgencia);

    }
    public void salvarAtendimento(){

        clicar(botaoSalvarAtendimento);

    }
    public String pesquisarAtendimento(){

        return obterTexto(tabelaDescricaoAtendimento);

    }

    public void excluirAtendimento(){

        clicar(botaoExcluirAtendimento);
        esperaAceitarAlert();

    }
    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();
    }
}
