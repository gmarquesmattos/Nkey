package pageObjects.Login;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By campoLogin = By.xpath("//input[@type='text']");
    private By campoSenha = By.xpath("//input[@type='password']");
    private By botaoLogin = By.xpath("//button[@type='button']");

  public LoginPage(String login,String senha){

      insereLogin(login);
      insereSenha(senha);
      clicarBotaoLogin();
  }

    public void insereLogin(String login) {
        escrever(campoLogin, login);
    }

    public void insereSenha(String senha) {
        escrever(campoSenha, senha);
    }

    public void clicarBotaoLogin() {
        clicar(botaoLogin);
    }
}
