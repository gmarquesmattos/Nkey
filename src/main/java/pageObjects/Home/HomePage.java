package pageObjects.Home;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By campoLogin = By.xpath("//h1[contains(text(),'Atividades')]");
    private By botaoAtividade = By.xpath("//div[@id='root']/main/section/div[2]/button/span");
    private By linkAtendimento = By.xpath("//div[@id='root']/main/section/div[4]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/h5");
    private By botaoConcluir = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[4]/button[1]/span[1]");
    private By botaoContatos = By.xpath("//body/div[@id='root']/main[1]/aside[1]/ul[1]/li[2]/a[1]/div[1]/*[1]");
    private By botaoEmpresa = By.xpath("//body/div[@id='root']/main[1]/aside[1]/ul[1]/li[3]/a[1]/div[1]/*[1]");
    private By botaoNegocio = By.xpath("//body/div[@id='root']/main[1]/aside[1]/ul[1]/li[4]/a[1]/div[1]/*[1]");


    public String getTextoAtividade() {
        System.out.println(obterTexto(campoLogin));
        return obterTexto(campoLogin);

    }

    public void clicarBotaoNovaAtividade() {
        clicar(botaoAtividade);


    }

    public void clicarLinkConcluirAtividade() {
        clicar(linkAtendimento);

    }

    public void clicarMenuContatos() {

        clicar(botaoContatos);
    }

    public void clicarBotaoEmpresa() {

        clicar(botaoEmpresa);
    }

    public void clicarBotaoNegocio() {

        clicar(botaoNegocio);
    }

}
