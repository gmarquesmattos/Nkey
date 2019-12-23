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
    public static final String CPF_DIGITAL_0718 = retornarValorArquivoConfiguracao("cpf.digital.0718");
    public static final String CPF_NAO_DIGITAL_0718 = retornarValorArquivoConfiguracao("cpf.nao.digital.0718");
    public static  final String CPF_SOLUCOES_0718 = retornarValorArquivoConfiguracao("cpf.solucoes.0718");
    public static  final String CNPJ_SOLUCOES_0718 = retornarValorArquivoConfiguracao("cnpj.solucoes.0718");
    public static  final String CNPJ_SOLUCOES_0101 = retornarValorArquivoConfiguracao("cnpj.solucoes.0101");
    public static  final String CPF_SOLUCOES_0101 = retornarValorArquivoConfiguracao("cpf.solucoes.0101");
    public static  final String USUARIO_RESPONSAVEL_0718 = retornarValorArquivoConfiguracao("usuario.responsavel.0718");
    public static  final String USUARIO_RESPONSAVEL_0101 = retornarValorArquivoConfiguracao("usuario.responsavel.0101");
    public static  final String CONTA_0718 =  retornarValorArquivoConfiguracao("conta.0718");
    public static  final String CONTA_0101 =  retornarValorArquivoConfiguracao("conta.0101");
    public static  final String NUMERO_ATIVO_INVESTIMENTO =  retornarValorArquivoConfiguracao("numero.solucoes.diferente.poupanca0718");


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


}

