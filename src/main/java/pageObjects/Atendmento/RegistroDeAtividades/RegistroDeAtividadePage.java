package pageObjects.Atendmento.RegistroDeAtividades;

import base.BasePage;
import org.openqa.selenium.By;

public class RegistroDeAtividadePage extends BasePage {

    private By campoDescricao = By.id("dsacompanhamento");
    private By botaoSalvar = By.id("btnEditAcompanhamento");
    private By botaoOk = By.xpath("//button[@id='btnOK']/font");
    private By TextoModal = By.xpath("//div[contains(text(),'Registro inserido com sucesso.')]");

    public String escreverNoCampoRegistrarAtividade() {
        escrever(campoDescricao, "TESTE_REGISTRO_ATIVIDADE_AUTOMAÇÃO");
        clicar(botaoSalvar);
        String texto = obterTexto(TextoModal);
        clicar(botaoOk);

        return texto;

    }

}
