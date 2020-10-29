package pageObjects.Atendmento.AtendimentoChamado;

import base.BasePage;
import org.openqa.selenium.By;

public class AtendimentoChamadoPage extends BasePage {

    private By abaAtendimento = By.cssSelector("#XMLTababa_atendimento > .COLORLABEL");
    private By inicioData = By.id("dtinicioacompanhamento");
    private By fimData = By.id("dtterminoacompanhamento");
    private By horaInicio = By.id("hrinicioacompanhamento");
    private By horaFim = By.id("hrterminoacompanhamento");
    private By campoTextoAcompanhamento = By.id("dsacompanhamento");
    private By combotipo = By.id("cdtipoacompanhamento");
    private By botaoRegistrar = By.xpath("//button[@id='btnFollowUp']/span");
    private By botaoProximaEtapa = By.xpath("//img[@alt='Próxima etapa']");
    private By textoNomeEtapa = By.id("tdEtapas");
    private By botaoFluxoSim = By.xpath("//img[@onclick=\"selectNextEtapa('283,3,5024,534001', undefined, 'Y','');\"]");
    private By texttto = By.xpath("//tbody/tr[@id='gridListaEtapaRow_1']/td[1]/font[1]/img[1]");
    private By abaEncerramento = By.xpath("//td[@id='XMLTababa_fca']/font");
    private By FcaCausa1 = By.id("cdcausa1");
    private By abaSolucao = By.xpath("//td[@id='XMLTababa_solucao']/font");
    private By campoDescriCorretiva = By.id("dsacaocorretiva");
    private By botaoProcessar = By.id("btnProcessar");

    private By botaoLocalizarResponsavel = By.xpath("(//img[@alt='Localizar'])[12]");
    private By campoPesquisarNome = By.id("vlsearchfield");
    private By botaoPesquisar = By.id("btnSearch");
    private By botaoConfirmar = By.xpath("//img[@alt='Confirmar']");

    public void clicarAbaAtendimento() {
        SelectPopUpService();
        clicar(abaAtendimento);
    }

    public void clicarAbaEncerramento(String nomeResponsavel) {

        clicar(abaAtendimento);

        clicar(botaoLocalizarResponsavel);

        escrever(campoPesquisarNome, nomeResponsavel);
        clicar(botaoPesquisar);
        clicar(botaoConfirmar);
        clicar(abaEncerramento);

    }

    public void escolherCausaFCA(String OpcaoCausaFCA) {
        clicar(FcaCausa1);
        selecionarValor(FcaCausa1, OpcaoCausaFCA);
    }

    public void escolhercausaSolucao(String textoDescricao) {
        clicar(abaSolucao);
        escrever(campoDescriCorretiva, textoDescricao);
        clicar(botaoProcessar);

    }

    public void clicarBotaoEncerrarAtendimento() {
        clicar(botaoProximaEtapa);
    }

    public void inserirDataInicio() {
        escrever(inicioData, gerarDataAtual());

    }

    public void clicarDataFim() {

        escrever(fimData, gerarDataAtual());


    }

    public void inserirHoraInicio() {
        escrever(horaInicio, "12:00");
    }

    public void inserirHoraFim() {
        escrever(horaFim, "13:00");
    }

    public void inseriAcompanhamento(String texto) {

        escrever(campoTextoAcompanhamento, texto);
    }

    public void escolherTipoAcompanhamento() {
        selecionarValor(combotipo, "Registro de atividades");

    }

    public void clicarRegistrar() {
        clicar(botaoRegistrar);
    }


    public void clicarEtapaIniciarAtendimentoDentroChamado() {
        clicar(botaoProximaEtapa);

    }

    public String getNomeEtapa() {
        System.out.println("!@#$%%$$#@#$ " + obterTexto(textoNomeEtapa));
        return obterTexto(textoNomeEtapa);

    }

    public void clicarFluxoSim() {
        clicar(texttto);

    }

}

