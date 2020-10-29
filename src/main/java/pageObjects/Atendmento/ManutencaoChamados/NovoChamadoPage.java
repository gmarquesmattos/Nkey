package pageObjects.Atendmento.ManutencaoChamados;

import base.BasePage;
import org.openqa.selenium.By;

public class NovoChamadoPage extends BasePage {
    private By campoCliente = By.id("cdcliente");
    private By campoContato = By.id("cdcontato");
    private By tipoChamado = By.id("cdtipochamado");
    private By tipoSeveridade = By.id("cdseveridade");
    private By tipoCategoria1 = By.id("cdcategoria1");
    private By tipoCategoria2 = By.id("cdcategoria2");
    private By tipoCategoria3 = By.id("cdcategoria3");
    private By campoTituloChamado = By.id("nmtitulochamado");
    private By campoDescricaoChamado = By.id("dschamado");
    private By tipoInformacaoAdicional = By.id("vlinformacaoadicional789");
    private By botaoProcessar = By.xpath("//button[@id='btnProcessar']/span");
    private By textoNumeroChamado = By.id("label_cdchamado");


    public void inserirClienteContato(String nomeCliente, String nomeContato) {
        SelectPopUp();
        escrever(campoCliente, nomeCliente);
        escrever(campoContato, nomeContato);
    }

    public void inserirTipoPrioridadeCategorias() {
        clicar(tipoChamado);
        selecionarValor(tipoChamado, "Banestes");

        clicar(tipoSeveridade);
        selecionarValor(tipoSeveridade, "Baixa");

    }

    public void inserircategoria1() {

        clicar(tipoCategoria1);
        selecionarValor(tipoCategoria1, "Banestes");
    }

    public void inserirCategoria2() {

        clicar(tipoCategoria2);
        selecionarValor(tipoCategoria2, "Chamado");
    }

    public void inserirCategoria3() {
        clicar(tipoCategoria3);
        selecionarValor(tipoCategoria3, "Suporte Operacional");


    }

    public void inserirTituloDescrucao() {
        escrever(campoTituloChamado, "Teste_AUT_Teste_AUT");
        escrever(campoDescricaoChamado, "Teste_AUT_Teste_AUT");
    }

    public void inserirInformacaoAdicional() {
        clicar(tipoInformacaoAdicional);
        selecionarValor(tipoInformacaoAdicional, "Sistemas.Administrativos e Apoio.GDC - Gestão de Desempenho por Competências.Dúvidas");

    }

    public void clicarBoaoProcessar() {
        clicar(botaoProcessar);

    }
public String obterNumeroChamadoCriado(){
    System.out.println(obterTexto(textoNumeroChamado));
        return obterTexto(textoNumeroChamado);


    }

}


