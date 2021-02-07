package pageObjects.Negocio;

import base.BasePage;
import org.openqa.selenium.By;

public class NegocioPage extends BasePage {

    private By textoNegocio = By.xpath("//h1[contains(text(),'Negócios')]");
    private By botaoNovoNegocio = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[7]/div[2]/button[1]/span[1]");
    private By livkNegociacao = By.xpath("//div[@id='root']/main/section/div[9]/div[4]/div[2]/a/div/div/span");
    private By livkOportunidade = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[2]/a[1]/div[1]");
    private By comboFunil = By.xpath(" //div[@id='root']/main/section/div[7]/div/select");

    public String getTextoNegocio() {

        return obterTexto(textoNegocio);
    }

    public void clicarNovoNegocio() {

        clicar(botaoNovoNegocio);


    }

    public void clicarNaOportunidade() {
        clicar(livkOportunidade);


    }
public void escolherOpsCustom(String texto){

        selecionarValor(comboFunil,texto);
}
}
