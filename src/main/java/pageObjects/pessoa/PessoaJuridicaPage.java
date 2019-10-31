package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PessoaJuridicaPage extends BasePage {

    private By botaoPesquisarPj = By.id("s_1_1_6_0_Ctrl");
    private By textoPj = By.id("1_Sicredi_CNPJ_Mascara");
    private By textoRazaoSocialPj = By.name("Name");
    private By botaoIrPj = By.id("s_1_1_5_0_Ctrl");

    public PessoaJuridicaPage(WebDriver driver, String cnpj) {
        super(driver);
        pesquisarPessoa(cnpj);

    }

    public void pesquisarPessoa(String cnpj) {
        clicar(botaoPesquisarPj);
        escrever(textoPj, cnpj);
        clicar(botaoIrPj);
    }

    public void acessarRazaoSocial() {
        clicar(textoRazaoSocialPj);
    }
}
