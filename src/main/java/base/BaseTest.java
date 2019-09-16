package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.login.LoginPage;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.CommonUtils.retornarValorArquivoConfiguracao;

@Listeners({ListenerTest.class, ExtentITestListenerClassAdapter.class})
public abstract class BaseTest extends ListenerTest {

    protected static final Logger LOGGER = LogManager.getLogger();
    protected static final String SENHA_TESTE = "teste123";
    protected static final String USUARIO_TESTE = "karine_bonjour";
    protected static final String URL_BASE = retornarValorArquivoConfiguracao("url.base");
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser, Method method) throws Exception {

        WebDriver driver = DriverFactory.criarInstancia(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(URL_BASE);
        driver.manage().window().maximize();

        realizarLogin();

    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }

    @AfterSuite
    public void updateReport() {
        try {

            String relatorioPath = "target/relatorio/execucao.html";
            String htmlContent = FileUtils.readFileToString(new File(relatorioPath), "utf-8");

            String pattern = "href='([^'].*)' data-featherlight";

            // Create a Pattern object
            Pattern r = Pattern.compile(pattern);

            // Now create matcher object.
            Matcher matcher = r.matcher(htmlContent);

            Set<String> keyList = new HashSet();

            while (matcher.find()) {
                keyList.add(matcher.group(1));
            }
            for (String data : keyList) {
                String oldString = data + "' data-featherlight='image'>";
                htmlContent = htmlContent.replace(oldString, oldString + "<img src='" + data + "' style=\"width:150px\">");
            }
            htmlContent = htmlContent.replace("<span class='label grey badge white-text text-white'>base64-img</span>", "");

            FileUtils.writeStringToFile(new File(relatorioPath), htmlContent, "utf-8");

        } catch (Exception e) {
            LOGGER.error("Erro ao atualizar miniaturas no report html", e);
        }
    }

    private void realizarLogin() {
        LoginPage loginPO = new LoginPage(driver);
        loginPO.realizaLoginPortal(USUARIO_TESTE, SENHA_TESTE);
    }
}