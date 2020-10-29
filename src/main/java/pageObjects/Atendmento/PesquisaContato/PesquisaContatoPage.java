package pageObjects.Atendmento.PesquisaContato;

import base.BasePage;
import org.openqa.selenium.By;

public class PesquisaContatoPage extends BasePage {
    private By campoNomeContato = (By.id("nmcontato"));
    private By botaoProcessar = (By.xpath("//button[@id='btnProcessar']/span"));
    private By botaoExpandir = (By.id("gridContatoRow_0_parentImage0"));
    private By botaoexibirContato = (By.xpath("//tbody/tr[@id='gridContatoRow_0']/td[2]/img[1]"));
    private By campoIdCliente = (By.id("cdcliente"));
    private By botaoFecharPesquisar = (By.id("btnCloseWindow2"));
    private By botaoNovoCliente = (By.xpath("//button[@id='btnNovo']/span"));
    private By textoCampoIdContato = (By.id("cdcontato"));
    private By botaoPesquisarContato = (By.id("btnPesquisar"));


    public void inserirNomeContato(String cod, String nome) {
        this.SelectPopUp();
        acessarFrame2();
        clicar(botaoPesquisarContato);
        escrever(textoCampoIdContato, cod);
        escrever(campoNomeContato,nome);
        clicar(botaoProcessar);

    }

    public String abrirContato() {

        clicar(botaoExpandir);
        clicar(botaoexibirContato);
        SelectPopUp();
        return obterValorElemento(textoCampoIdContato);
    }

    public void fecharPesquisa() {
        acessarFrame2();
        clicar(botaoFecharPesquisar);
    }

    public void PreencherNovoContato(String codCliente, String nomeContato) {
        clicar(botaoNovoCliente);
        SelectPopUp();
        escrever(campoIdCliente, codCliente);
        escrever(campoNomeContato, nomeContato);
        clicar(botaoProcessar);

    }

    public String getIdContato() {
        System.out.println(obterValorElemento(textoCampoIdContato));
        return obterValorElemento(textoCampoIdContato);
    }

}