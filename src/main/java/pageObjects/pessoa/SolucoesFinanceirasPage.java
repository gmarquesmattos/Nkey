package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;

public class SolucoesFinanceirasPage extends BasePage {

    private By botaoPesquisarSolucoesFinanceiras = By.cssSelector("button[title = 'Soluções financeiras:Pesquisar']");
    private By textoTipoSolucoesFinanceiras = By.id("1_s_1_l_Account_Type");
    private By campoTipoSolucoesFinanceiras = By.id("1_Account_Type");
    private By botaoIr = By.cssSelector("button[title = 'Soluções financeiras:Ir']");
    private By tabelaNumeroSolucao = By.name("Sicredi Account Number Calc");
    private By botaoAtualizarSaldo = By.cssSelector("button[title='Atualizar saldo']");
    private By tabelaNumeroDaSolucao = By.id("1_s_1_l_Account_Number");
    private By textoNumeroDaSolucao = By.id("1_Account_Number");
    private By textoDataAtualizacaoSaldo = By.name("s_1_1_14_0");

    public SolucoesFinanceirasPage() {
        acessar();
    }

    public void pesquisarSolucoesFinanceiras() {
        clicar(botaoPesquisarSolucoesFinanceiras);
    }

    public void preencherNumeroSolucao(String numeroConta) {
        clicar(tabelaNumeroDaSolucao);
        escrever(textoNumeroDaSolucao, numeroConta);
    }

    public void preencherTipo() {
        clicar(textoTipoSolucoesFinanceiras);
        escrever(campoTipoSolucoesFinanceiras, "poupa");
        clicarTab();
    }

    public void clicarBotaoIr() {
        clicar(botaoIr);
    }

    public void acessarNumerodaSolucao() {
        clicar(tabelaNumeroSolucao);
    }

    public void clicarBotaoAtualizarSaldo() {
        clicar(botaoAtualizarSaldo);
    }

    public String obterDataAtualizacaoSaldo() {
        return obterValueElemento(textoDataAtualizacaoSaldo);
    }

    public void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarSolucoesFinanceiras();
    }

}
