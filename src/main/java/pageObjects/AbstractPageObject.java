package pageObjects;

import driver.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import base.BaseTest;

import static utils.CommonUtils.retornarValorArquivoConfiguracao;

public abstract class AbstractPageObject extends BaseTest {

    protected AbstractPageObject() {
        int timeout = Integer.parseInt(retornarValorArquivoConfiguracao("timeout"));
        PageFactory.initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(), timeout), this);
    }

}
