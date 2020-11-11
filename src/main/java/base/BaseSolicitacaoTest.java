package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pageObjects.Atendmento.LoginPage;

import java.lang.reflect.Method;

import static utils.CommonUtils.retornarValorArquivoConfiguracao;


@Listeners({ReportTest.class, ExtentITestListenerClassAdapter.class})
public abstract class BaseSolicitacaoTest extends ReportTest {

    protected static final Logger LOGGER = LogManager.getLogger();
    static final String URL_BASE = retornarValorArquivoConfiguracao("urlSolicitacao.base");

    public static final String USUARIO_LOGIN = "silvio.ferreira@stone.com.br";
    public static final String USUARIO_SENHA= "123";
    public static final String TEXTO_USUARIO_LOGIN= "SILVIO FERREIRA";
    public static final String TEXTO_MINHAS_SOLICITACOES= "MINHAS SOLICITAÇÕES";
    public static final String TEXTO_MINHAS_PENDENCIAS= "MINHAS PENDÊNCIAS";
    public static final String TEXTO_DESCRICAO_ATIVIDADE= "AUT#_AUT#_AUT#_AUT#_AUT#";
    public static final String TEXTO_REGISTRO_SALVO_COM_SUCESSO= "Registro inserido com sucesso.";
    public static final String TEXTO_REGISTRO_CHAMADO= "AUTOMAÇÃO_AUTOMAÇÃO_AUTOMAÇÃO";
    public static final String TEXTO_BENEFICIOS_SAAS= "Benefício SaaS";
    public static final String TEXTO_BENEFICIOS_SAAS_CONFIGURACAO= "Benefício SaaS - Configurações";
    public static final String TEXTO_FPW_REPORTS= "FPw Reports";
    public static final String GEN_TE_AGREGA_AUTOATENDIMENTO= "Gen.te Agrega - Autoatendimento";
    public static final String GEN_TE_FLUI_WORKFLOW= "Gen.te Flui - Workflow";


    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser, Method method) throws Exception {
        DriverFactory.criarInstancia(browser);
        DriverManager.getDriver().get(URL_BASE);
        DriverManager.getDriver().manage().window().maximize();
        new LoginPage(USUARIO_LOGIN, USUARIO_SENHA);
    }

    @AfterMethod(alwaysRun = true)
    public void aposTeste() {
        DriverManager.quit();
    }

    public void esperar(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

