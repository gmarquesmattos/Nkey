package pageObjects.login;

import base.BasePage;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    private By textoUsuario = By.id("fieldUser");
    private By textoSenha = By.id("fieldPassword");
    private By botaoEntrar = By.id("btnSubmit");
    protected static final String USUARIO_TESTE = "karine_bonjour";
    protected static final String SENHA_TESTE = "teste123";


    public LoginPage(WebDriver driver) {

        super(driver);
        realizaLoginPortal();
    }

    private void realizaLoginPortal() {
        escrever(textoUsuario,USUARIO_TESTE);
        escrever(textoSenha,SENHA_TESTE);
        clicar(botaoEntrar);

    }



}
