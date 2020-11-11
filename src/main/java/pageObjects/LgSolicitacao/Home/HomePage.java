package pageObjects.LgSolicitacao.Home;

import base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By textoUsuarioLogado = By.id("navbar-user-name");
    private By menuLaretalServico = By.id("optService");
    private By botaoBeneSaasAdmBeneficio = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[1]/div[1]/div[2]/span[1]");
    private By botaoBeneSaasAdmBeneficioConfiguracao = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[2]/div[1]/div[2]/span[1]");
    private By botaoFpwReports = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[3]/div[1]/div[2]/span[1]");
    private By botaoGenAgregaAutoAtendimento = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[1]/div[4]/div[1]/div[2]/span[1]");
    private By botaoGenFluiWorkflow = By.xpath("//body/div[@id='bodycontent']/div[@id='wrapper']/div[@id='page-content-wrapper']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[12]/div[2]/div[1]/div[1]/div[2]/span[1]");
    private By BotaoComponentesAdmBeneficio = By.id("btnActionService8450");
    private By BotaoComponentesAssociacao = By.xpath("//div[@id='btnActionService8451']");
    private By campoDescricao = By.id("txtdescricao");
    private By botaoAbrirChamado = By.xpath("//button[@id='AbrirChamado']/span");
    private By confirmacaoNumeroChamado = By.xpath("//tbody/tr[1]/td[2]/div[1]/b[1]");
    private By botaoNao = By.id("btnNO");
    private By idChamado = By.id("cdchamado");
    private By menuLateralSolicitacao = By.id("portal");
    private By menuLateralPendencia = By.id("optPendencias");


    public String getTextoUsuariologado() {

        System.out.println("@#$$$$$ " + obterTexto(textoUsuarioLogado));
        return obterTexto(textoUsuarioLogado);

    }

    public void acessarMenuServico() {
        clicar(menuLaretalServico);
    }

    public void acessarBeneficiosAdm() {
        moverMouse(botaoBeneSaasAdmBeneficio);
        clicar(BotaoComponentesAdmBeneficio);

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
        System.out.println(obterTexto(botaoBeneSaasAdmBeneficio));
        return obterTexto(botaoBeneSaasAdmBeneficio);

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
}
