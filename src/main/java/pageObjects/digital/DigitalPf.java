package pageObjects.digital;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class DigitalPf extends BasePage {

    private By textoPlataformaDigital = By.id("SectionDigitalInfo");

    public DigitalPf(WebDriver driver) {
        super(driver);
        acessar();
    }

    public String indicativoPfDigital() {
        return obterTexto(textoPlataformaDigital);
    }

     private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
    }

    public void insereCpf(String CPF) {
        new PessoaFisicaPage(driver, CPF);
    }
}
