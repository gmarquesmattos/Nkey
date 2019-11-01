package base;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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
    static final String URL_BASE = retornarValorArquivoConfiguracao("url.base");

    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser, Method method) throws Exception {

        WebDriver driver = DriverFactory.criarInstancia(browser);
        DriverManager.setDriver(driver);

        DriverManager.getDriver().get(URL_BASE);
        driver.manage().window().maximize();


    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        DriverManager.quit();
    }

    @AfterSuite(alwaysRun = true)
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

    @DataProvider(name = "cpfNaoDigital")
    public Object[][] createData() {
        return new Object[][]{new Object[]{"97452874820"}};
    }

    @DataProvider(name = "cpfDigital")
    public Object[][] createDataDigital() {
        return new Object[][]{new Object[]{"03334856020"}};
    }

    @DataProvider(name = "cnpjDigital")
    public Object[][] cnpjDigital() {
        return new Object[][]{new Object[]{"09514327000156"}};


    }

    @DataProvider(name = "cpfResumo")
    public Object[][] cpfResumo() {
        return new Object[][]{new Object[]{"22661551808"}};
    }


}