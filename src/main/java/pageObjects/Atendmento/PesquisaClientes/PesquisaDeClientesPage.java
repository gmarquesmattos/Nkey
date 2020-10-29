package pageObjects.Atendmento.PesquisaClientes;

import base.BasePage;
import org.openqa.selenium.By;

public class PesquisaDeClientesPage extends BasePage {
    private By campoCnpj = (By.id("nrcpfcnpj"));
    private By botaoProcessar = (By.xpath("//button[@id='btnProcessar']/span"));
    private By botaoAbrirCliente = (By.xpath("//tbody/tr[@id='gridClienteRow_0']/td[1]/img[1]"));
    private By campoIdCliente = (By.id("cdcliente"));
    private By botaoFecharPesquisar = (By.id("btnCloseWindow2"));
    private By botaoNovoCliente = (By.xpath("//button[@id='btnNovo']/span"));
    private By campoNomeCliente = (By.id("nmcliente"));
    private By campoRazaoSocialCliente = (By.id("nmrazaosocial"));
    private By campoCnpjCliente = (By.id("nrcpfcnpj"));
    private By comboTipoCliente = (By.id("cdtipocliente"));
    private By botaoFechar = (By.id("btnFechar"));
    private By botaoPesquisar = (By.xpath("//button[@id='btnPesquisar']/span"));
    private By chekboxAtivo = (By.id("idativo"));


    public void inserirIdCliente(String cnpj) {

        this.SelectPopUp();
        acessarFrame2();
        clicar(botaoPesquisar);
        System.out.println("@@@@ Já Pego"+ cnpj);
        escrever(campoIdCliente, cnpj);
        clicar(botaoProcessar);
        //  acessarFrame2();
        clicar(botaoAbrirCliente);

    }

    public String getIdCliente() {

        System.out.println("&&&&&&&&&&&&&&&&" +obterValorElemento(campoIdCliente));
        return obterValorElemento(campoIdCliente);
    }

    public void getPopUp() {

        SelectPopUp();
    }

    public void fecharPesquisa() {
        acessarFrame2();
        clicar(botaoFecharPesquisar);
    }

    public void clicarBotaoNovoClientePreencharCadastroCliente(String nomeCliente, String nomeRazaoSocial, String cnpj, String tipoCliente) {
        clicar(botaoNovoCliente);
        SelectPopUp();
        escrever(campoNomeCliente, nomeCliente);
        escrever(campoRazaoSocialCliente, nomeRazaoSocial);
        escrever(campoCnpjCliente, cnpj);
        selecionarValor(comboTipoCliente, tipoCliente);
        clicar(chekboxAtivo);
        clicar(botaoProcessar);
    }


    public void fecharPagina() {
        //  String janelaPrincipal = this.SelectPopUp();

        //  acessarFrame2();
        //   clicar(botaoPesquisar);
        //  clicar(botaoFechar);
        // this.SelectPageMain(janelaPrincipal);


    }

}

