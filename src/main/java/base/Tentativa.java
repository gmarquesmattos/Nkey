package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Tentativa implements IRetryAnalyzer {
    private int contadorTentativas = 0;
    private static final int maximoTentativas = 1;

    @Override
    public boolean retry(ITestResult resultado) {
        if (contadorTentativas < maximoTentativas) {
            contadorTentativas++;
            return true;
        }
        return false;
   }
}
