package pageObjects.Atendmento;

import base.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By campoLogin = By.id("cdusuario");
    private By campoSenha = By.id("cdsenha");
    private By botaoLogin = By.id("btnLogin");

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
