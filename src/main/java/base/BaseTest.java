package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import static utils.CommonUtils.retornarValorArquivoConfiguracao;


@Listeners({ReportTest.class, ExtentITestListenerClassAdapter.class})
public abstract class BaseTest extends ReportTest {

    protected static final Logger LOGGER = LogManager.getLogger();
    static final String URL_BASE = retornarValorArquivoConfiguracao("url.base");

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser, Method method) throws Exception {
        DriverFactory.criarInstancia(browser);
        DriverManager.getDriver().get(URL_BASE);
        DriverManager.getDriver().manage().window().maximize();


    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }

    @DataProvider(name = "cpfNaoDigital")
    public Object[][] cpfNaoDigital() {
        return new Object[][]{new Object[]{"97452874820"}};
    }

    @DataProvider(name = "cpfDigital")
    public Object[][] cpfDigital() {
        return new Object[][]{new Object[]{"03334856020"}};
    }

    @DataProvider(name = "cnpjDigital")
    public Object[][] cnpjDigital() {
        return new Object[][]{new Object[]{"09514327000156"}};

    }
    @DataProvider(name = "cnpjSolucaoFinanceira")
    public Object[][] cnpjSolucaoFinanceira() {
        return new Object[][]{new Object[]{"24712637000179"}};
    }

    @DataProvider(name = "cpfSolucaoFinanceira")
    public Object[][] cpfSolucaoFinanceira() {
        return new Object[][]{new Object[]{"97452874820"}};
    }

    @DataProvider(name = "cpfResumo")
    public Object[][] cpfResumo() {
        return new Object[][]{new Object[]{"22661551808"}};
    }


}