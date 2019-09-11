package pageObjects.pessoa.fisica;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SolucoesFinanceirasPO extends BasePage {


    public SolucoesFinanceirasPO(WebDriver driver) {
        super(driver);
    }

    public void clicarLinkSaldoContaPrincipal() {

        clicar(By.id("s_2_1_32_0"));
    }

    public String obterContaPrincipal() {

        return obterTexto(By.id("s_2_1_12_0"));
    }


}
