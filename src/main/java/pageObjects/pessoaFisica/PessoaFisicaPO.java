package pageObjects.pessoaFisica;

import base.BasePage;
import org.openqa.selenium.By;

public class PessoaFisicaPO extends BasePage {


    public void pesquisar() {

        clicar(By.id("s_1_1_11_0_Ctrl"));
        escrever(By.id("1_Social_Security_Number"), "03401711970");
        Enter();
    }

    public void drillNomeCompleto() {

        clicar(By.name("Sicredi Nome Completo"));
    }

}

