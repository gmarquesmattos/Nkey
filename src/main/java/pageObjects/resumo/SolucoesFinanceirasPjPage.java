package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;
import java.util.ArrayList;


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

    public ArrayList<String> obterDadosContaPrincipalAssociado(){
        ArrayList<String>dadosContaPrincipalAssociado = new ArrayList<>();
        dadosContaPrincipalAssociado.add(obterTexto(rotuloContaPrincipal).substring(1, 7));
        dadosContaPrincipalAssociado.add(obterTexto(rotuloContaPrincipal).substring(9,17).toLowerCase());
        return dadosContaPrincipalAssociado;
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaJuridica();
    }

}
