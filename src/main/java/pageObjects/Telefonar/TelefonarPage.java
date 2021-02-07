package pageObjects.Telefonar;

import base.BasePage;
import org.openqa.selenium.By;

public class TelefonarPage extends BasePage {
    private By campoAtividadeNota = By.xpath("//textarea[@type='text']");
    private By botaoConcluir = By.xpath("//div[@id='root']/main/section/div/div/div[4]/button/span");


    public void inserirConclusao(String texto) {
        escrever(campoAtividadeNota, texto);
          clicar(botaoConcluir);
    }


}
