package pageObjects.Negocio;

import base.BasePage;
import base.DataUtil;
import org.openqa.selenium.By;

public class QualificarPage extends BasePage {
    private By botaoQualificar = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/label[1]/span[1]");
    private By campoObs = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[2]/div[1]/div[4]/div[2]/div[1]/label[1]/textarea[1]");
    private By botaoQualificarr = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[2]/div[1]/div[5]/div[1]/button[2]/span[1]");
    private By textoQualificacaoCadSucesso = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    private By CampoDataReuniao = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[5]/div[1]/div[3]/label[1]/input[1]");
    private By CampoHoraInicio = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[5]/div[1]/div[3]/label[2]/input[1]");
    private By CampoHoraFim = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[5]/div[1]/div[3]/label[3]/input[1]");
    private By CampoVendeResposavel = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[5]/div[1]/div[3]/label[4]/div[1]/select[1]");
    private By CampoAtividadeOuNota = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[5]/div[1]/label[1]/textarea[1]");
    private By botãoFormaContatoEmail = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[5]/div[1]/label[1]/div[1]/div[2]");
    private By botãoConfirmar = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[5]/div[1]/div[4]/button[1]/span[1]");
    private By textoQaulificadoSucesso = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    private By linkTextoProxiAtividade = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[10]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/*[1]");
    private By iconeConfirEtapa = By.cssSelector("svg.flex.center.defaultMarginLeft.pointer > g > path");
    private By textoHistorico = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[10]/div[2]/div[3]/div[1]/h4[1]");
    private By textoGanhou = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[7]/div[1]/div[2]/h3[1]");
    private By campoAtividadeNotaNegociacao = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[11]/div[2]/label[1]/textarea[1]");
    private By campoDataAtivNota = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[11]/div[2]/div[1]/div[1]/label[1]/input[1]");
    private By campoHoraInicio = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[11]/div[2]/div[1]/div[1]/label[2]/input[1]");
    private By campoHoraFim = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[11]/div[2]/div[1]/div[1]/label[3]/input[1]");
    private By iconePreferenciaWhats = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[11]/div[2]/label[1]/div[1]/div[1]/*[1]");
    private By botaoSalvar = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[11]/div[2]/div[1]/button[1]");
    private By textoSelecionarFormaContato = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]");

    public void clicarComboNegociacao() {

        clicar(botaoQualificar);
    }

    public void inserirObservacaoEQualificar(String obs) {

        escrever(campoObs, obs);
        clicar(botaoQualificarr);
    }

    public String getTextoQualificacaoCadSucesso() {

        return obterTexto(textoQualificacaoCadSucesso);
    }

    public String getTextoQualificacaoSucesso() {

        return obterTexto(textoQaulificadoSucesso);
    }

    public String getTextoGanhouSucesso() {

        return obterTexto(textoGanhou);
    }

    public void inserirdataReuniao(String hrInicio, String HrFim, String vendResp, String atvNota) {
        DataUtil dataUtil = new DataUtil();
        escrever(CampoDataReuniao, dataUtil.ObterDataAtual());
        escrever(CampoHoraInicio, hrInicio);
        escrever(CampoHoraFim, HrFim);
        selecionarValor(CampoVendeResposavel, vendResp);
        escrever(CampoAtividadeOuNota, atvNota);
        clicar(botãoFormaContatoEmail);
        clicar(botãoConfirmar);

    }

    public void finalizarAtividade() {

        clicar(iconeConfirEtapa);

    }

    public void cadastrarAtividadeNota(String texto, String horaInicio, String horaFim) {
        escrever(campoAtividadeNotaNegociacao, texto);
        DataUtil dataUtil = new DataUtil();
        escrever(campoDataAtivNota, dataUtil.ObterDataAtual());
        escrever(campoHoraInicio, horaInicio);
        escrever(campoHoraFim, horaFim);
        clicar(botaoSalvar);
    }

    public String getTextoFormaContato() {

        return obterTexto(textoSelecionarFormaContato);

    }
}
