package base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static driver.DriverManager.getDriver;

public class BasePage {

	private int tempo = 30;
	protected WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
	WaitAux waitAux = new WaitAux();
	WebElement elemento;

	public void escrever(By by, String texto) {
		waitAux.waitJQueryAndLoadPage();
		elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		elemento.clear();
		elemento.sendKeys(texto);
	}

	public void clicarLink(String link) {

		getDriver().findElement(By.linkText(link)).click();
	}

	public String obterTexto(By by) {
		
		waitAux.waitJQueryAndLoadPage();
		elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return elemento.getText();
	}
	public String obterValueElemento(String id) {
		return getDriver().findElement(By.name(id)).getAttribute("value");
	}

	public void clicar(By by) {
		waitAux.waitJQueryAndLoadPage();
		elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		elemento.click();

	}

	public void Enter() {

		waitAux.waitJQueryAndLoadPage();
		elemento.sendKeys(Keys.ENTER);

	}
}
