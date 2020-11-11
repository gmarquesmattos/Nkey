package pageObjects.LgSolicitacao.Solicitacao;

import base.BasePage;
import org.openqa.selenium.By;

public class SolicitacaoPage extends BasePage {
    private By textoUsuarioLogado = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[2]/fieldset[1]/legend[1]");
    private By linkAbrirChamado = By.xpath("//tbody/tr[@id='gridIncidentSingleRow_0']/td[2]/div[3]/div[1]/a[1]");
    private By textoSituacaoSolicitacao = By.xpath("//tbody/tr[@id='gridIncidentSingleRow_0']/td[2]/div[2]/div[1]/div[2]/span[1]");
    private By campoPesquisa = By.id("dsconteudosearch");
    private By botaoPesquisar = By.xpath("//a[@onclick='runPesquisaIncidentClick();']");
    private By abaAtendimento = By.id("aba_atendimento");
    private By campoDescricao = By.id("dsacompanhamento");
    private By botaoRegistrar = By.xpath("//button[@id='btnAddAcompanhamento']/span");
    private By textoRegistroSalvoComSucesso = By.xpath("//body/div[@id='toast-container']/div[1]/div[1]");


    public String getTextoMinhasSolicitacoes() {
        System.out.println(obterTexto(textoUsuarioLogado));
        return obterTexto(textoUsuarioLogado);
    }

    public void clicarLinkAbrirChamado() {
        moverMouse(textoSituacaoSolicitacao);
        clicar(linkAbrirChamado);

    }

    public void escreverChamado(String chamado) {
        escrever(campoPesquisa, chamado);
        clicar(botaoPesquisar);
    }

    public void abrirChamado() {
        clicar(linkAbrirChamado);

    }

    public void clicarAtendimento(String texto) {
        SelectPopUp();
        clicar(abaAtendimento);
        escrever(campoDescricao, texto);
        clicar(botaoRegistrar);
    }

    public String getTextoRegistroSalvoComSucesso() {
        System.out.println("&&&&&&&&&&&&&& " + obterTexto(textoRegistroSalvoComSucesso));
        return obterTexto(textoRegistroSalvoComSucesso);
    }

}
