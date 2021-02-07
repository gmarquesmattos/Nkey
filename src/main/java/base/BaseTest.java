package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import pageObjects.Login.LoginPage;

import java.lang.reflect.Method;

import static utils.CommonUtils.retornarValorArquivoConfiguracao;


@Listeners({ReportTest.class, ExtentITestListenerClassAdapter.class})
public abstract class BaseTest extends ReportTest {

    protected static final Logger LOGGER = LogManager.getLogger();
    static final String URL_BASE = retornarValorArquivoConfiguracao("url.base");



    public static final String USUARIO_LOGIN = "douglas.queiroz+qa1@nkey.com.br";
    public static final String USUARIO_SENHA = "123123";
    public static final String TITULO_HOME_ATIVIDADE = "Atividades";
    public static final String ATIVIDADE_SALVA_COM_SUCESSO = "Atividade cadastrada/atualizada com sucesso";
    public static final String DATA_INICIO = "04/02/2021";
    public static final String HORA_INICIO = "2349";
    public static final String HORA_FIM = "2350";
    public static final String DESC = "TESTE_AUTTESTE_AUTTESTE_AUTTESTE_AUT";
    public static final String TEXTO_CONCLUIR = "CONCLUIR_CONCLUIR_CONCLUIR_CONCLUIR_CONCLUIR_CONCLUIR_CONCLUIR_CONCLUIR_CONCLUIR_CONCLUIR_";
    public static final String TEXTO_NEGOCIO_OBRIGATORIO = "O Negócio é obrigatório";
    public static final String TEXTO_ATIVIDADE_NOTA = "ATIVIDADE_NOTA_AUTO_ATIVIDADE_NOTA_AUTO_ATIVIDADE_NOTA_AUTO_ATIVIDADE_NOTA_AUTO_ATIVIDADE_NOTA_AUTO_";
    public static final String TEXTO_TITULO_EMPRESA = "Empresas";
    public static final String TEXTO_TITULO_NEGOCIO = "Negócios";
    public static final String TEXTO_NOVA_EMPRESA = "Nova empresa";
    public static final String TEXTO_EMPRESA_SALVA= "Empresa cadastrada com sucesso";
    public static final String TEXTO_EMPRESA_NAO_SALVA= "O nome da empresa é obrigatório";
    public static final String TEXTO_DATA_OBRIGATORIO = "A Data é obrigatória";
    public static final String TEXTO_HORA_OBRIGATORIO = "A Hora de início é obrigatória";
    public static final String TEXTO_HORA_FIM = "A Hora de fim é obrigatória";
    public static final String TEXTO_FORMA_CONTATO = "Você deve selecionar de qual forma irá entrar em contato";
    public static final String TEXTO_FORMA_CONTATO_ATIV_NOTA = "Você deve selecionar de que forma irá entrar em contato";
    public static final String TEXTO_CONTATOS = "Contatos";
    public static final String NOME_CONTATO = "AUT_NOME_TESTE";
    public static final String CARGO = "ANALISTA_TESTE";
    public static final String EMAIL = "Teste@gmail.com";
    public static final String TELEFONE_PRINCIPAL = "999999999";
    public static final String TELEFONE_SECUNDARIO = "888888888";
    public static final String TELEFONE_WHATSAPP = "777777777";
    public static final String TEXTO_RAZAO_SOCIAL = "RAZÃO_RAZÃO_RAZÃO_RAZÃO_";
    public static final String TEXTO_OBS = "AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_AUT_";
    public static final String TEXTO_CADASTRO_CADASTRADO_SUCESSO = "Contato cadastrado com sucesso";
    public static final String TEXTO_NOME_OBRIGATORIO = "O Nome é obrigatório";
    public static final String NOME_EMPRESA = "MATTOS";
    public static final String VALOR_SEGMENTO = "Agência de marketing/publicidade";
    public static final String SITE = "WWW.AUTMATTOS.COM.BR";
    public static final String ENDERECO = "RUA SILVA SÓ";
    public static final String NUMERO = "1234";
    public static final String COMPLE = "AP";
    public static final String BAIRRO = "TINGA";
    public static final String CIDADE = "POA";
    public static final String ESTADO = "RS";
    public static final String NOME_NEGOCIO = "NEGOCIAÇÃO_MATTOS";
    public static final String TEXTO_NEGOCIO_CADASTRADO_COM_SUCESSO = "Negócio cadastrado com sucesso";
    public static final String TEXTO_OBD_QUALIFICACAO = "AUT_QUALIFICACAO_AUT_QUALIFICACAO_AUT_QUALIFICACAO_AUT_QUALIFICACAO_AUT_QUALIFICACAO_";
    public static final String QUALIFICACAO_CAD_SUCESSO = "Qualificação cadastrada com sucesso";
    public static final String ATIVIDADE_AGENDADA_COM_SUCESSO = "Atividade agendada com sucesso";
    public static final String ATIVIDADE_ATUALIZADA_COM_SUCESSO= "Atividade atualizada com sucesso";
    public static final String ETAPA_NEGOCIO_REALIZADA_SUCESSO= "Etapa do negócio atualizada com sucesso";
    public static final String ETAPA_NEGOCIO_DEU_CERTO= "Ganhou";
    public static final String ETAPA_REUNIAO_REALIZADA_SUCESSO= "Etapa do reunião atualizada com sucesso";
    public static final String VENDE_RESP = "Douglas QA";
    public static final String ATIVIDADE_NOTA_CONCLUSÃO = "ATIVIDADE_NOTA_CONCLUIDA_CNCLUIDA_ATIVIDADE_NOTA_CONCLUIDA_CNCLUIDA_ATIVIDADE_NOTA_CONCLUIDA_CNCLUIDA_ATIVIDADE_NOTA_CONCLUIDA_CNCLUIDA_";
    public static final String TEXTO_GANHOU = "GANHOU_GANHOU_AUT_AUT";
    public static final String MOTIVO_DESCARTE = "Achou caro";



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

