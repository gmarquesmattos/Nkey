package pageObjects.login;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.AbstractPageObject;

public class LoginPO extends AbstractPageObject {

    protected WebDriver driver;

    @FindBy(id = "fieldUser")
    WebElement user;

    @FindBy(id = "fieldPassword")
    WebElement pass;

    @FindBy(id = "btnSubmit")
    WebElement login;

    public LoginPO() {
        driver = DriverManager.getDriver();
    }

    public void preencheUsuario(String usuario) {
        user.sendKeys(usuario);
    }

    public void preencheSenha(String senha) {
        pass.sendKeys(senha);
    }

    public void clicaBotaoLogin() {
        login.click();
    }

    public void realizaLoginPortal(String usuario, String senha) {
        preencheUsuario(usuario);
        preencheSenha(senha);
        clicaBotaoLogin();
    }


}
