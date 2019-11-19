package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.lang.reflect.Method;

import static utils.CommonUtils.retornarValorArquivoConfiguracao;


@Listeners({ReportTest.class, ExtentITestListenerClassAdapter.class})
public abstract class BaseTest extends ReportTest {

    protected static final Logger LOGGER = LogManager.getLogger();
    static final String URL_BASE = retornarValorArquivoConfiguracao("url.base");
    public static final String CNPJ_DIGITAL_0718 = retornarValorArquivoConfiguracao("cnpj.digital.0718");
    public  static  final String CPF_SOLUCOES_0718 =retornarValorArquivoConfiguracao("cpf.solucoes.0718");


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser, Method method) throws Exception {
        DriverFactory.criarInstancia(browser);
        DriverManager.getDriver().get(URL_BASE);
        DriverManager.getDriver().manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void aposTeste() {
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

    @DataProvider(name = "cnpjDigitalCoop0718")
    public Object[][] cnpjDigitalCoop0718() {
        return new Object[][]{new Object[]{"24712637000179"}};

    }

    @DataProvider(name = "cnpjDigitalCoop0101")
    public Object[][] cnpjDigitalCopp0101() {
        return new Object[][]{new Object[]{"30659721000179"}};

    }

    @DataProvider(name = "cnpjSolucaoFinanceiraCoop0101")
    public Object[][] cnpjSolucaoFinanceiraCoop0101() {
        return new Object[][]{new Object[]{"23848798000121"}};
    }

    @DataProvider(name = "cnpjSolucaoFinanceiraCoop0718")
    public Object[][] cnpjSolucaoFinanceiraCopp0718() {
        return new Object[][]{new Object[]{"24712637000179"}};
    }


    @DataProvider(name = "cpfSolucaoFinanceiraCoop0101")
    public Object[][] cpfCoop0101() {
        return new Object[][]{new Object[]{"01779085052"}};
    }

    @DataProvider(name = "cpfResumo")
    public Object[][] cpfResumo() {
        return new Object[][]{new Object[]{"22661551808"}};
    }
}