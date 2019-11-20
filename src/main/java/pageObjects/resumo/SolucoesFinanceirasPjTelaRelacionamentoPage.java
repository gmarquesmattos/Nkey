package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

public class SolucoesFinanceirasPjTelaRelacionamentoPage extends BasePage {
    private By linkSaldoContaPrincipal = By.id("s_15_1_32_0");
    private By rotuloContaPrincipal = By.id("s_15_1_19_0");

    public SolucoesFinanceirasPjTelaRelacionamentoPage(String cnpj) {
        acessar(cnpj);
    }

    public void clicarLinkSaldoContaPrincipal() {
        clicar(linkSaldoContaPrincipal);
    }

    public String obterContaPrincipal() {
        return obterTexto(rotuloContaPrincipal).substring(1, 7);
    }

    private void acessar(String cnpj) {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaJuridica();
        new PessoaJuridicaPage(cnpj)
                .acessarRazaoSocial();
    }

}
