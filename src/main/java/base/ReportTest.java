package base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReportTest implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Está executando: " + iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        reportPrint(Status.PASS, "");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info(iTestResult.getThrowable());
        reportPrintFail("");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentService.getInstance().flush();
    }

    private void reportPrintFail(String log) {
        reportPrint(Status.FAIL, log);
    }

    private void reportPrint(Status status, String log) {
        try {
            ExtentTestManager.getTest().log(status, log,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build());
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    private String takeScreenshot() throws IOException {
        String caminhoDiretorioCapturasTela = System.getProperty("user.dir") + "/target/relatorio/img/" + System.currentTimeMillis() + ".png";
        File capturaTela = new File(caminhoDiretorioCapturasTela);

        if (!capturaTela.getParentFile().exists()) {
            capturaTela.getParentFile().mkdirs();
        }
        if (capturaTela.createNewFile()) {
            LOGGER.info("Arquivo criado com sucesso!");
        }

        File scrFile = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, capturaTela);

        byte[] fileContent = FileUtils.readFileToByteArray(capturaTela);
        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        return "data:image/png;base64," + encodedString;
    }

    @AfterSuite(alwaysRun = true)
    public void updateReport() {
        try {

            String relatorioPath = "target/relatorio/execucao.html";
            String htmlContent = FileUtils.readFileToString(new File(relatorioPath), "utf-8");
            String pattern = "href='([^'].*)' data-featherlight";
            Pattern r = Pattern.compile(pattern);
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


}
