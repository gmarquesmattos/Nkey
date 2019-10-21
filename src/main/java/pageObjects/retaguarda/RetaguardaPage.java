package pageObjects.retaguarda;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.home.HomePage;


public class RetaguardaPage extends BasePage {
    private By tabelaCategoria = By.xpath("//td[@id='1_s_2_l_SR_Type_New_']");
    private By seletorVisibilidade = By.name("s_vis_div");
    private By opcaoTodosMeusAtendimentos = By.xpath("//div[@id='_swecontent']//option[2]");


    public RetaguardaPage(WebDriver driver) {
        super(driver);
    }

    public RetaguardaPage acessarCadastroCanais() {
        HomePage homePO = new HomePage(driver);
        homePO.selecionarMenuHome();
        clicar(seletorVisibilidade);
        clicar(opcaoTodosMeusAtendimentos);
        return this;
    }

    public RetaguardaPage entrarRetarguarda() {
        clicar(tabelaCategoria);
        return this;

    }
}

