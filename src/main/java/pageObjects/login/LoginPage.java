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

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage realizaLoginPortal(String usuario, String senha) {
        escrever(textoUsuario,usuario);
        escrever(textoSenha,senha);
        clicar(botaoEntrar);
        return  this;
    }


}
