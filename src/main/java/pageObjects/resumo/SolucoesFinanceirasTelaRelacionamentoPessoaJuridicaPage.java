package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaJuridicaPage;

import java.util.ArrayList;

public class SolucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage extends BasePage {
    private By linkSaldoContaPrincipal = By.id("ExtratoDetalhes");
    private By rotuloContaPrincipal = By.id("ContaCorrenteField");

    public SolucoesFinanceirasTelaRelacionamentoPessoaJuridicaPage() {
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
