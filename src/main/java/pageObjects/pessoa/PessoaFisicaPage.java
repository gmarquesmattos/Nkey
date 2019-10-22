package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PessoaFisicaPage extends BasePage {

    private By botaoPesquisar = By.id("s_1_1_11_0_Ctrl");
    private By textoCpf = By.id("1_Social_Security_Number");
    private By textoNomeCompleto = By.name("Sicredi Nome Completo");

    public PessoaFisicaPage(WebDriver driver, String cpf ) {
        super(driver);
        pesquisarPessoa(cpf);
        acessarNomeCompleto();
    }

    private void pesquisarPessoa(String cpf) {
        clicar(botaoPesquisar);
        escrever(textoCpf, cpf);
        entrar();
    }

    private void acessarNomeCompleto() {
        clicar(textoNomeCompleto);
    }

}

