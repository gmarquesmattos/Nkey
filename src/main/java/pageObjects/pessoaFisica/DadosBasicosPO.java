package pageObjects.pessoaFisica;

import base.BasePage;
import org.openqa.selenium.By;

public class DadosBasicosPO extends BasePage {


    public String obterNomeCompleto() {

        return obterTexto(By.id("s_6_1_17_0"));

    }

    public String obterDataNascimento() {

        return obterTexto(By.id("s_6_1_11_0"));

    }

    public String obterEstadoCivil() {

        return obterTexto(By.id("s_6_1_5_0"));

    }

    public String obterCpf() {

        return obterTexto(By.id("s_6_1_8_0"));

    }

    public String obterRg() {

        return obterTexto(By.id("s_6_1_12_0"));

    }

    public String obterAssociadoDesde() {

        return obterTexto(By.id("s_6_1_6_0"));

    }

    public String obterGrupoEconomico() {

        return obterTexto(By.id("s_6_1_9_0"));

    }

    public String obterCbo() {

        return obterTexto(By.id("s_6_1_7_0"));

    }

}
