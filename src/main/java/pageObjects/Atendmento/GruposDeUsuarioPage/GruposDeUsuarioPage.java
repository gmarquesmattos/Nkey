package pageObjects.Atendmento.GruposDeUsuarioPage;

import base.BasePage;
import org.openqa.selenium.By;

public class GruposDeUsuarioPage extends BasePage {

    private By campoNomeGrupos = (By.id("nmgrupo"));
    private By botaoProcessar = (By.id("btnProcessar"));
    private By textoRegistroSalvoComSucesso = (By.cssSelector("div.DIVALERT:nth-child(7) table.WINDOWCONTENT table.ALERTCONTENT tbody:nth-child(1) tr:nth-child(1) td.COLORLABEL:nth-child(2) > div:nth-child(1)"));
    private By botaoModalOk = (By.id("btnOK"));
    private By campoPesquisar = (By.id("dspesquisa"));
    private By botaoExcluir = (By.xpath("//img[@alt='Excluir']"));
    private By botaoModalSim = (By.xpath("//button[@id='btnYES']/font"));
    private By textoModalCampoVazio = (By.cssSelector("div.DIVALERT:nth-child(7) table.WINDOWCONTENT table.ALERTCONTENT tbody:nth-child(1) tr:nth-child(1) td.COLORLABEL:nth-child(2) > div:nth-child(1)"));

    public void inserirNomeCampoGrupo(String NomeGrupo) {
        acessarFrame2();
        escrever(campoNomeGrupos, NomeGrupo);
        clicar(botaoProcessar);

    }

    public String getTextoRegistroSalvoComSucesso() {
        return obterTexto(textoRegistroSalvoComSucesso);

    }

    public void clicarBotaoModalOk() {
        clicar(botaoModalOk);
    }

    public void escreverCampoNomePesquisa(String grupo) {

        escrever(campoPesquisar, grupo);
    }

    public void clicarEmExcluir() {
     clicar(botaoExcluir);
     clicar(botaoModalSim);


    }
    public String getMensagemCampoVazio() {
        return    obterTexto(textoModalCampoVazio);


    }
}
