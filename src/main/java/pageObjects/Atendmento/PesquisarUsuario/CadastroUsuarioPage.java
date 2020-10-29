package pageObjects.Atendmento.PesquisarUsuario;

import base.BasePage;
import org.openqa.selenium.By;

public class CadastroUsuarioPage extends BasePage {
    private By campoUsuario = (By.id("nmusuario"));
    private By botaoVisualizar = (By.xpath("//button[@id='btnSearch']/span"));
    private By botaoVisualizarChamado = (By.xpath("//img[@alt='Visualizar']"));
    private By botaoSelecionarEmpresa = (By.xpath("//button[@id='btnMultipleSelectcdempresa']/img"));
    private By botaoSelecionarTodos = (By.xpath("(//button[@id='btnSearchAll'])[2]"));
    private By botaoIncluirIntes = (By.xpath("//img[@alt='Incluir item']"));
    private By botaoConfirmar = (By.id("btnSeach"));
    private By botaoNovoUsuario = (By.id("btnNovo"));
    private By campoNome = (By.id("nmusuario"));
    private By campoCargo = (By.id("cdcargo"));
    private By campoEmail = (By.id("dsemail"));
    private By comboInterface = (By.id("nmskin"));
    private By comboConfi = (By.id("nmskin"));
    private By comboOpcaoAtivo = (By.id("idativo"));
    private By botaoProcessar = (By.id("btnProcessar"));
    private By textoRegistroSalvoComSucesso = (By.cssSelector("div.DIVALERT:nth-child(7) table.WINDOWCONTENT table.ALERTCONTENT tbody:nth-child(1) tr:nth-child(1) td.COLORLABEL:nth-child(2) > div:nth-child(1)"));
    private By botaoModalOk = (By.id("btnOK"));
    private By textoModalCampoVazio = (By.cssSelector("div.DIVALERT:nth-child(7) table.WINDOWCONTENT table.ALERTCONTENT tbody:nth-child(1) tr:nth-child(1) td.COLORLABEL:nth-child(2) > div:nth-child(1)"));


    public void inserirNomeUsuario(String Nome) {
        acessarFrame2();
        escrever(campoUsuario, Nome);

    }

    public void clicarBotaoPesquisar() {
        clicar(botaoVisualizar);

    }

    public void clicarBotaoAbrirChamado() {
        clicar(botaoVisualizarChamado);

    }

    public void clicarBotaoSelecionarEmpresa() {
        acessarFrame2();
        clicar(botaoSelecionarEmpresa);

    }

    public void clicarBotaoSelecionarTodos() {
        SelectPopUpService();
        clicar(botaoSelecionarTodos);

    }


    public void clicarBotaoConfirmar() {

        clicar(botaoConfirmar);

    }


    public void clicarBotaoIncluirItens() {

        clicar(botaoIncluirIntes);

    }

    public void criarUsuario(String nome, String mail, String cargo) {
        acessarFrame2();
        clicar(botaoNovoUsuario);
        SelectPopUpService();
        escrever(campoNome, nome);
        escrever(campoCargo, cargo);
        escrever(campoEmail, mail);
        selecionarValor(comboInterface, "Default");
        clicar(comboOpcaoAtivo);
        clicar(botaoProcessar);
    }

    public String getTextoRegistroSalvoComSucesso() {
        return obterTexto(textoRegistroSalvoComSucesso);

    }

    public void clicarBotaoModalOk() {
        clicar(botaoModalOk);
    }

    public String getMensagemCampoVazio() {
     return    obterTexto(textoModalCampoVazio);


    }
}
