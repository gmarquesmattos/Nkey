package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PessoaJuridicaPage extends BasePage {

    private By botaoPesquisarPj = By.id("s_1_1_6_0_Ctrl");
    private By seletorPj = By.id("s_vis_div");
    private By seletorTodasasPessoasPj = By.xpath("//option[contains(text(),'Todas as pessoas jurídicas')]");
    private By textoPj = By.id("1_Sicredi_CNPJ_Mascara");
    private By textoNomePj = By.name("Name");
    private By botaoirPj = By.id("s_1_1_5_0_Ctrl");

    public PessoaJuridicaPage(WebDriver driver) {
        super(driver);
        todasasContas();
        pesquisarPessoa();
        acessarRazaoSocial();

    }

    public void todasasContas() {

        clicar(seletorPj);
        clicar(seletorTodasasPessoasPj);
    }

    public void pesquisarPessoa() {

        clicar(botaoPesquisarPj);
        escrever(textoPj, "09514327000156");
        clicar(botaoirPj);
    }

    public void acessarRazaoSocial() {

        clicar(textoNomePj);
    }
}
