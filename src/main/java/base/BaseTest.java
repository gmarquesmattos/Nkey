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
public abstract class BaseTest extends ReportTest {

    protected static final Logger LOGGER = LogManager.getLogger();
    static final String URL_BASE = retornarValorArquivoConfiguracao("url.base");

    public static final String USUARIO_LOGIN = "lucas.dias";
    public static final String USUARIO_LOGIN_ADM = "admin";
    public static final String USUARIO_SENHA = "123";
    public static final String RODAPE_LOGIN_USUARIO = "  Clientes Externos / Lucas Sampaio Dias";
    public static final String TIPO_DE_EQUIPE = "N1";
    public static final String EQUIPE = "236";
    public static final String CHAMADO_ATENDIMENTO = "533969";
    public static final String DATA_PESQUISA_INICIO = "01/10/2020";
    public static final String DATA_PESQUISA_FIM = "01/10/2020";
    public static final String NOME_CLIENTE = "Mendes Júnior";
    public static final String RESPONSAVEL_CHAMADO = " Ana Paula Cardoso Conrado Jacintho";
    public static final String VALOR_CAMPO_TIPO_EQUIPE = " Sustentação CORE - Workflow Operacional";
    public static final String VALOR_CAMPO_EQUIPE = " Soluções Personalizadas - Customização Manutenção Corretiva";
    public static final String TEXTO_ETAPA_AVANCADA_ENVIAR_ANEXO = "Etapa avançada com sucesso : (Enviar anexos)";
    public static final String TEXTO_ETAPA_AVANCADA_ENVIAR_SIM = "Etapa avançada com sucesso : (Sim)";
    public static final String TEXTO_ETAPA_INICIAR_ATENDIMENTO = "Iniciar Atendimento";
    public static final String TEXTO_ETAPA_ENVIAR_ANEXOS = "Enviar anexos";
    public static final String TEXTO_ETAPA_SIM = "Sim";
    public static final String TEXTO_ETAPA_ENCERRAR_ATENDIMENTO = "Encerrar Atendimento";
    public static final String TEXTO_ETAPA_ENCERRAR = "Encerrado";
    public static final String TEXTO_ETAPA_AVANCADA_ENCERRAR_ATENDIMENTO = "Etapa avançada com sucesso : (Encerrar Atendimento)";
    public static final String TEXTO_DESCRICAO_ACOMPANHAMENTO = "Acompanhamento_Automação_automação";
    public static final String ID_CLIENTE = "0017000000SFSDZAA5";
    public static final String ID_CONTATO = "295";
    public static final String NOME_CLIENTE_AUTOMACAO = "Cliente_automação";
    public static final String NOME_CONTATO_AUTOMACAO = "Automação_Contato";
    public static final String COD_CLI_CONTATO = "458";
    public static final String NOME_CLIENTE_RAZAO_AUTOMACAO = "Automação_java";
    public static final String CNPJ_AUTOMACAO = "50712093000155";
    public static final String TIPO_CLIENTE = "TESTE";
    public static final String MENSAGEM_PESQUISA_CHAMADO = "Pesquisa de demandas [ 1 ]";
    public static final String VALOR_ENCERRAMENTO_CAUSA_FCA = "Arquivo de relatório inconsistente";
    public static final String TEXTO_ENCERRAMENTO_SOLUCAO = "TEXTO_ENCERRAMENTO_SOLUCAO";
    public static final String TEXTO_REGISTRO_SALVO_COM_SUCESO = "Registro inserido com sucesso.";
    public static final String RESPONSAVEL_PELO_ENCERRAMENTO = "Lucas Sampaio Dias";

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

