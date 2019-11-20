package pageObjects.digital;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;

public class TelaDeRelacionamentoPage extends BasePage {

    private By linkEsteiraPS = By.cssSelector("#S_A14_tile_2");
    private By textoPlataformaDigital = By.id("SectionDigitalInfo");

    public TelaDeRelacionamentoPage() {
             acessar();
    }

    public void clicarlinkEsteiraPS() {
        clicarJavaScript(linkEsteiraPS);
    }

    public String esperaAceitarAlertRecomendar() {
        return esperaAceitarAlert();
    }

    public String indicativoPfDigital() {
        return obterTexto(textoPlataformaDigital);
    }

    public void pesquisarPessoaFisica(String cpf)
    {
        new PessoaFisicaPage(cpf).acessarNomeCompleto();
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();
    }
}
