package pageObjects.digital;

import base.BasePage;
import base.Jquery;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class TelaDeRelacionamentoPage extends BasePage {

    private By linkEsteiraPS = By.cssSelector("#S_A14_tile_2");
    private By textoPlataformaDigital = By.id("SectionDigitalInfo");

    public TelaDeRelacionamentoPage(WebDriver driver) {
        super(driver);
        acessar();
    }

    public void clicarlinkEsteiraPS() {
        new Jquery();
        WebElement element = driver.findElement(linkEsteiraPS);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String esperaAceitarAlertRecomendar() {
        return esperaAceitarAlert();
    }

    public String indicativoPfDigital() {
        return obterTexto(textoPlataformaDigital);
    }

    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(driver, cpf).acessarNomeCompleto();
    }

    private void acessar() {
        HomePage homePage = new HomePage(driver);
        homePage.acessarPessoaFisica();
    }
}
