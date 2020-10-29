package pageObjects.Atendmento.AtendimentoHome;

import base.BasePage;
import org.openqa.selenium.By;

public class AtendimentoHomePage extends BasePage {
    private By campoPesquisar = By.id("dsconteudolocalizacao");
    private By botaoAbrirChamado = By.xpath("//img[@alt='Exibir Atendimento']");
    private By textoPesquisar = By.id("title");
    private By botaoPesquisar = By.cssSelector(".toolbarslider-item:nth-child(1)");
    private By textoGridChamado = By.cssSelector("fieldset.DIVCONTEUDOTOPO:nth-child(6) table.tableGrid:nth-child(2) tbody:nth-child(1) tr.ROW:nth-child(2) td:nth-child(7) > font.COLORLABEL");
    private By textoGridNomeCliente = By.cssSelector("fieldset.DIVCONTEUDOTOPO:nth-child(6) div:nth-child(1) table.tableGrid:nth-child(2) tbody:nth-child(1) tr.ROW:nth-child(2) > td.PADDINGLEFT:nth-child(12)");
    private By textoGridNomeResponsavel = By.id("nmresponsavel");
    private By textoGridNomeEquipe = By.id("nmequipe");
    private By campoChamdo = By.id("cdchamado");
    private By campoDataInicio = By.id("dtperiodo");
    private By campoDataFim = By.id("dtperiodo2");
    private By BotaoPesquisarModal = By.xpath("//button[@id='btnProcessar']//span[@class='IMGSPAN'][contains(text(),'Pesquisar')]");
    private By BotaoIconeCliente = By.xpath("//button[@id='btnMultipleSelectcdcliente']/img");
    private By BotaoIconeResponsavel = By.xpath("//button[@id='btnMultipleSelectcdresponsavel']/img");
    private By BotaoIconeTipoEquipe = By.xpath("//button[@id='btnMultipleSelectcdtipoequipe']/img");
    private By BotaoIconeEquipe = By.xpath("//button[@id='btnMultipleSelectcdequipe']/img");
    private By campoNomeCliente = By.id("multipleSelectcdcliente_multipleSelectSearchValue");
    private By campoNomeResponsavel = By.id("multipleSelectcdresponsavel_multipleSelectSearchValue");
    private By campoNomeTipoEquipe = By.id("multipleSelectcdtipoequipe_multipleSelectSearchValue");
    private By campoNomeEquipe = By.id("multipleSelectcdequipe_multipleSelectSearchValue");
    private By campoNumeroProcesso = By.id("cdestrutura");
    private By botaoPesquisarCliente = By.id("btnSearch");
    private By botaoIncluirItens = By.xpath("//img[@alt='Incluir item']");
    private By botaoConfirmar = By.id("btnSeach");
    private By abaAtendimento = By.xpath("//td[@id='XMLTababa_atendimento']/font");
    private By abaProcessos = By.xpath("//td[@id='XMLTababa_fluxo']/font");
    private By comboselecionaChamado = By.id("gridChamadosCheck_0");
    private By seletorMenuAcao = By.xpath("//div[@id='controlMenu_container']/div/div[3]/img");
    private By opcaoAvancarEtapa = By.id("optForwardStep_caption");
    private By opcaoRegistrarAcompanhamento = By.id("optRegisterFollowup_caption");
    private By botaoPesquisarProcessos = By.xpath("//button[@id='btnProcessar']/span");
    private By seletorEtapa = By.id("cdsubsituacaoedit");
    private String valorEtapa = ("De \"Enviar anexos \" para \"Sim\"");
    private By botaoSalvarTrocaEtapa = By.xpath("(//img[@alt='Processar'])[3]");
    private By botaoConfirmarSim = By.xpath("//button[@id='btnYES']/font");
    private By botaoFechar = By.id("btnCloseWindow2");
    private By botaoAtualizar = By.id("btnAtualizar");
    private By botaoChamados = By.xpath("//div[@id='mnuChamado']/span");
    private By botaoOpcaoChamados = By.xpath("//div[@id='mnuHd_Chamado01']/span");

    String janelaPrincipal = this.SelectPopUp();

    public void pesquisarPorchamdo(String chamado) {

        escrever(campoPesquisar, chamado);

        entrar();

    }

    public void getpop() {
        SelectPopUp();
    }

    public void abriChamdado() {
        acessarFrame2();
        clicar(botaoAbrirChamado);

    }

    public String getTextoTituloPesquisa() {
        acessarFrame2();
        return obterTexto(textoPesquisar);


    }

    public void clicarclicarBotaoPesquisar() {

        clicar2(botaoPesquisar);
    }

    public void escreverChamdo(String chamado) {

        escrever(campoChamdo, chamado);

    }

    public void acessarFrame() {
        acessarFrame2();
    }

    public void iserirDataInicioDataFim(String data, String dataFim) {

        escrever(campoDataInicio, data);
        escrever(campoDataFim, dataFim);
    }

    public void inserirCliente(String nomeCliente) {
        clicar(BotaoIconeCliente);
        escrever(campoNomeCliente, nomeCliente);
        clicar(botaoPesquisarCliente);
        clicar(botaoIncluirItens);
        clicar(botaoConfirmar);
    }

    public void inserirResponsavel(String nomeResponsavel) {
        clicar(abaAtendimento);
        clicar(BotaoIconeResponsavel);
        escrever(campoNomeResponsavel, nomeResponsavel);
        clicar(botaoPesquisarCliente);
        clicar(botaoIncluirItens);
        clicar(botaoConfirmar);


    }


    public void inserirTipoDeEquipe(String nomeEquipe) {
        clicar(abaAtendimento);
        clicar(BotaoIconeTipoEquipe);
        escrever(campoNomeTipoEquipe, nomeEquipe);
        clicar(botaoPesquisarCliente);
        clicar(botaoIncluirItens);
        clicar(botaoConfirmar);


    }

    public void inserirEquipe(String nomeEquipe) {
        clicar(abaAtendimento);
        clicar(BotaoIconeEquipe);
        escrever(campoNomeEquipe, nomeEquipe);
        clicar(botaoPesquisarCliente);
        clicar(botaoIncluirItens);
        clicar(botaoConfirmar);


    }


    public void inserirProcesso(String nomeEquipe) {
        clicar(abaProcessos);
        escrever(campoNumeroProcesso, nomeEquipe);
        clicar(botaoPesquisarProcessos);


    }


    public void clicarBotaoPesquisar() {
        clicar(BotaoPesquisarModal);

    }


    public void cicarComboChamado() {
        acessarFrame2();
        clicar(comboselecionaChamado);
        clicarMenuAcao();
        clicarAvancarEtapa();
    }

    public void trocarEtapaInicarAtendimento() {
        clicar(botaoSalvarTrocaEtapa);
        clicar(botaoConfirmarSim);
        clicar(botaoFechar);

    }

    public void clicarMenuAcaoRegistrarAcompanhamento() {
        acessarFrame2();
        clicar(comboselecionaChamado);
        clicarMenuAcao();
        clicar(opcaoRegistrarAcompanhamento);
    }

    public void trocarEtapaEnviarAnexos() {
        clicarMenuAcao();
        clicarAvancarEtapa();
        clicar(seletorEtapa);
        selecionarValor(seletorEtapa, valorEtapa);
        clicar(botaoSalvarTrocaEtapa);
        clicar(botaoConfirmarSim);
        clicar(botaoFechar);

    }

    public void trocarEtapaEncerrarAtendimento() {
        clicarMenuAcao();
        clicarAvancarEtapa();
        trocarEtapaInicarAtendimento();

    }

    public void clicarMenuAcao() {

        clicar(seletorMenuAcao);
    }

    public void clicarAvancarEtapa() {
        clicar(opcaoAvancarEtapa);
    }

    public void clicarNemuChamados() {
        clicar(botaoChamados);
        clicar(botaoOpcaoChamados);
    }

      public void clicarMenuClientes(){


      }

    public String getTextoGridNumeroChamado() {
        return obterTexto(textoGridChamado);
    }

    public String getTextoGridNomeCliente() {
        return obterTexto(textoGridNomeCliente);

    }

    public String getTextoGridNomeResponsavel() {
        clicar2(botaoAbrirChamado);
        SelectPopUpService();
        clicar(abaAtendimento);

        return obterValorElemento(textoGridNomeResponsavel);

    }

    public String getTextoNomeEquipe() {
        clicar(botaoAbrirChamado);
        SelectPopUpService();
        clicar(abaAtendimento);

        return obterValorElemento(textoGridNomeEquipe);

    }
}

