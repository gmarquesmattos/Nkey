package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;


public class PessoaFisicaPage extends BasePage {

    private By botaoPesquisar = By.id("s_1_1_11_0_Ctrl");
    private By textoCpf = By.id("1_Social_Security_Number");
    private By textoNomeCompleto = By.name("Sicredi Nome Completo");

    public PessoaFisicaPage(String cpf) {
           pesquisarPessoa(cpf);
    }

    private void pesquisarPessoa(String cpf) {
        clicar(botaoPesquisar);
        escrever(textoCpf, cpf);
        entrar();
    }

    public void acessarNomeCompleto() {
        clicar(textoNomeCompleto);
    }
}