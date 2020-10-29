package pageObjects.Atendmento.EngrenagemAdm;

import base.BasePage;
import org.openqa.selenium.By;

public class EngrenagemAdmPage extends BasePage {
    private By botaoEngrenagem = (By.xpath("//div[@id='mnuAdministracao']/span/span/img"));
    private By opcaoAvancado = (By.id("mnuAvancado"));
    private By opcaoUsuario = (By.id("mnuAd_Usuario"));
    private By cadUsuario = (By.xpath("//div[@id='mnuAd_Usuario05']/span"));
    private By opcaoSeguranca = (By.id("mnuAd_Permissoes"));
    private By opcaoGruposDeUsuario = (By.xpath("//div[@id='mnuAd_Grupo02']/span"));
    private By opcaoMenuCliente = (By.id("mnuAd_Cliente"));
    private By opcaoCliente = (By.id("mnuAd_Cliente01"));
    private By opcaoMenuContato = (By.id("mnuAd_Contato0"));
    private By opcaoontato = (By.id("mnuAd_Contato01"));

    public void acessarMenuUsuario() {
        clicar(botaoEngrenagem);
        clicar(opcaoAvancado);
        clicar(opcaoUsuario);
        clicar(cadUsuario);
    }

    public void acessarMenuGrupoDeUsuario() {
        clicar(botaoEngrenagem);
        clicar(opcaoAvancado);
        clicar(opcaoSeguranca);
        clicar(opcaoGruposDeUsuario);

    }

    public void acessarMenuPesquisaCliente() {
        clicar(botaoEngrenagem);
        clicar(opcaoMenuCliente);
        clicar(opcaoCliente);

    }
    public void acessarMenuPesquisaContato() {
        clicar(botaoEngrenagem);
        clicar(opcaoMenuContato);
        clicar(opcaoontato);

    }


}
