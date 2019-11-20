package base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retentativa implements IRetryAnalyzer {
    private int contadorTentativas = 0;
    private static final int MAXIMO_TENTATIVAS = 1;

    @Override
    public boolean retry(ITestResult resultado) {
        if (contadorTentativas < MAXIMO_TENTATIVAS) {
            contadorTentativas++;
            return true;
        }
        return false;
   }
}
