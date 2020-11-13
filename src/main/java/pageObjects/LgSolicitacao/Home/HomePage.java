package pageObjects.LgSolicitacao.Home;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By textoUsuarioLogado = By.id("navbar-user-name");
    private By menuLaretalServico = By.id("optService");
    private By cardBeneSaasAdmBeneficio = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[1]/div[1]/div[2]/span[1]");
    private By botaoBeneSaasAdmBeneficioConfiguracao = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[2]/div[1]/div[2]/span[1]");
    private By botaoFpwReports = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[3]/div[1]/div[2]/span[1]");
    private By botaoGenAgregaAutoAtendimento = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[4]/div[1]/div[2]/span[1]");
    private By botaoGenFluiWorkflow = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[2]/div[1]/div[1]/div[2]/span[1]");
    private By botaoGenMobileAutoAtendimento = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[2]/div[2]/div[1]/div[2]/span[1]");
    private By botaoGenMobileFolhaPagamento = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[2]/div[3]/div[1]/div[2]/span[1]");
    private By botaoSa3 = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[2]/div[4]/div[1]/div[2]/span[1]");
    private By botaoSoc = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[3]/div[1]/div[1]/div[2]/span[1]");
    private By botaoTabelaGenericas = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[3]/div[2]/div[1]/div[2]/span[1]");
    private By BotaoComponentesAdmBeneficio = By.id("btnActionService8450");
    private By BotaoComponentesAssociacao = By.xpath("//div[@id='btnActionService8451']");
    private By campoDescricao = By.id("txtdescricao");
    private By botaoAbrirChamado = By.xpath("//button[@id='AbrirChamado']/span");
    private By confirmacaoNumeroChamado = By.xpath("//tbody/tr[1]/td[2]/div[1]/b[1]");
    private By botaoNao = By.id("btnNO");
    private By idChamado = By.id("cdchamado");
    private By menuLateralSolicitacao = By.id("portal");
    private By menuLateralPendencia = By.id("optPendencias");
    private By barraRolagem = By.id("ascrail2001");
    private By botaoLinkAcessarPainelAdmBene = By.xpath("(//div[@onclick=\"searchService(8449, 3, true, true, '');dw_Tooltip.hide();\"])[2]");
    private By textoCardAdmDeBeneficio = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[5]/div[1]/div[1]/div[1]/div[2]/span[1]");
    private By textoCardRelatorio = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[5]/div[1]/div[2]/div[1]/div[2]/span[1]");
    private By textoCardRelatorioReports = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[5]/div[1]/div[3]/div[1]/div[2]/span[1]");
    private By textoCardEstornoLancamentoColetivoEspecificos = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[2]/span[1]");
    private By campoPesquisar = By.id("dsconteudosearchservice");

    public String getTextoUsuariologado() {

        System.out.println("@#$$$$$ " + obterTexto(textoUsuarioLogado));
        return obterTexto(textoUsuarioLogado);

    }

    public void acessarMenuServico() {
        clicar(menuLaretalServico);
    }

    public void acessarBeneficiosAdm() {
        moverMouse(cardBeneSaasAdmBeneficio);
        clicar(BotaoComponentesAdmBeneficio);

    }

    public void acessarPainelAdmBeneficio() {
        moverMouse(cardBeneSaasAdmBeneficio);
        clicar(botaoLinkAcessarPainelAdmBene);

    }

    public void acessarMenuAssociacao() {
        clicar(BotaoComponentesAssociacao);

    }

    public void escreverAbrirChamado(String texto) {
        SelectPopUp();
        escrever(campoDescricao, texto);
        clicar(botaoAbrirChamado);


    }

    public String getNumeroChamado() {
        String numchamado = obterTexto(confirmacaoNumeroChamado);
        this.SelectPopUp();
        return numchamado;
    }


    public void clicarMenuSolicitacao() {

        clicar(menuLateralSolicitacao);
    }

    public void clicarMenuPendencia() {
        clicar(menuLateralPendencia);
    }

    public String getTextoServicoBeneficioSaaS() {
        System.out.println(obterTexto(cardBeneSaasAdmBeneficio));
        return obterTexto(cardBeneSaasAdmBeneficio);

    }

    public String getTextoBenefícioSaaSConfiguracoes() {
        System.out.println(obterTexto(botaoBeneSaasAdmBeneficioConfiguracao));
        return obterTexto(botaoBeneSaasAdmBeneficioConfiguracao);

    }

    public String getTextoFpwReports() {
        System.out.println(obterTexto(botaoFpwReports));
        return obterTexto(botaoFpwReports);

    }

    public String getTextoGenAgregaAutoatendimento() {
        System.out.println(obterTexto(botaoGenAgregaAutoAtendimento));
        return obterTexto(botaoGenAgregaAutoAtendimento);

    }

    public String getTextoGenFluiWorkflow() {
        System.out.println(obterTexto(botaoGenFluiWorkflow));
        return obterTexto(botaoGenFluiWorkflow);

    }

    public String getTextoGenMobileAutoAtendimento() {
        System.out.println(obterTexto(botaoGenMobileAutoAtendimento));
        return obterTexto(botaoGenMobileAutoAtendimento);

    }

    public String getTextoGenFolhaPagamento() {
        System.out.println(obterTexto(botaoGenMobileFolhaPagamento));
        return obterTexto(botaoGenMobileFolhaPagamento);

    }

    public String getTextoSA3() {
        //rolagemPagina();
        clicar(barraRolagem);

        System.out.println(obterTexto(botaoSa3));
        return obterTexto(botaoSa3);

    }

    public String getTextoSoc() {
        //  rolagemPagina();
        System.out.println(obterTexto(botaoSoc));
        return obterTexto(botaoSoc);

    }

    public String getTextoTabelaGenericas() {
        System.out.println(obterTexto(botaoTabelaGenericas));
        return obterTexto(botaoTabelaGenericas);

    }

    public String getAdministracaoDeBenefícios() {
        System.out.println(obterTexto(textoCardAdmDeBeneficio));
        return obterTexto(textoCardAdmDeBeneficio);
    }

    public String getRelatorio() {
        System.out.println(obterTexto(textoCardRelatorio));
        return obterTexto(textoCardRelatorio);
    }

    public String getRelatorioReports() {
        System.out.println(obterTexto(textoCardRelatorioReports));
        return obterTexto(textoCardRelatorioReports);
    }

    public String getEstornoLancamentoColetivoEspecificos() {
        System.out.println(obterTexto(textoCardEstornoLancamentoColetivoEspecificos));
        return obterTexto(textoCardEstornoLancamentoColetivoEspecificos);
    }

    public void pesquisarServico(String texto) {
        escrever(campoPesquisar, texto);
        entrar2(campoPesquisar);


    }
}


