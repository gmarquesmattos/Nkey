package pageObjects.pessoa;

import base.BasePage;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class ContaCorrentePage extends BasePage {

    private By textoNumeroConta = By.cssSelector("input[aria-label='Nº da conta']");
    private By textoTipoConta = By.cssSelector("input[aria-label='Produto']");

    public ContaCorrentePage() {

    }

    public ArrayList<String> obterDadosContaSolucoesFinanceirasAssociado() {
        ArrayList<String> dadosContaAssociado = new ArrayList<>();
        dadosContaAssociado.add(obterValorElemento(textoNumeroConta));
        dadosContaAssociado.add(obterValorElemento(textoTipoConta).substring(6,14).trim());
         return dadosContaAssociado;
    }

}
