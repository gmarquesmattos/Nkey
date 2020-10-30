package pageObjects.LgSolicitacao.Home;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private By textoUsuarioLogado = By.id("navbar-user-name");
    private By menuLaretalServico = By.id("optService");
    private By BotaoBeneSaasAdmBeneficio = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[1]/div[1]/div[2]/span[1]");
    private By BotaoComponentesAdmBeneficio = By.id("btnActionService8450");
    private By BotaoComponentesAssociacao = By.xpath("//div[@id='btnActionService8451']");


    public String getTextoUsuariologado() {

        System.out.println("@#$$$$$ " + obterTexto(textoUsuarioLogado));
        return obterTexto(textoUsuarioLogado);

    }

    public void acessarMenuServico() {
        clicar(menuLaretalServico);
    }

    public void acessarBeneficiosAdm() {
        moverMouse(BotaoBeneSaasAdmBeneficio);
        clicar(BotaoComponentesAdmBeneficio);

    }

    public void acessarMenuAssociacao() {
        clicar(BotaoComponentesAssociacao);

    }
}
