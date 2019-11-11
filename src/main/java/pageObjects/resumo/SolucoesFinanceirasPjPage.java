package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;


public class SolucoesFinanceirasPjPage extends BasePage {
    private By linkSaldoContaPrincipal = By.id("s_15_1_32_0");
    private By rotuloContaPrincipal = By.id("s_15_1_19_0");

    public SolucoesFinanceirasPjPage() {
        acessar();
    }

    public void pesquisarPessoaJuridica(String cnpj) {
        new PessoaJuridicaPage(cnpj).acessarRazaoSocial();
    }

    public void clicarLinkSaldoContaPrincipal() {
        clicar(linkSaldoContaPrincipal);
    }

    public String obterContaPrincipal() {
        return obterTexto(rotuloContaPrincipal).substring(1, 7);
    }

    public String obterTipoContaPrincipal(){
        return obterTexto(rotuloContaPrincipal).substring(9,17).toLowerCase();
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaJuridica();
    }

}
