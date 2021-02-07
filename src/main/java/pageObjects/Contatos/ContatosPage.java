package pageObjects.Contatos;

import base.BasePage;
import org.openqa.selenium.By;

public class ContatosPage extends BasePage {
    private By campoLogin = By.xpath("//h1[contains(text(),'Contatos')]");
    private By botaoNovoCntato = By.xpath("//div[@id='root']/main/section/div[3]/button/span");
    private By campoNomeContato = By.xpath("(//input[@value=''])[2]");
    private By campoNomeEmpresa = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private By campoCargo = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[2]/input[1]");
    private By campoEmail = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[3]/input[1]");
    private By campoTel = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[4]/input[1]");
    private By campoTelSecun = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[5]/input[1]");
    private By campoTelWhats = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[6]/input[1]");
    private By campoRdeSocial = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[7]/input[1]");
    private By campoObservacao = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[8]/textarea[1]");
    private By botaoSalvar = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[4]/button[1]/span[1]");
    private By botaoSalvarEdicao = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[4]/div[1]/div[1]/button[1]/span[1]");
    private By textoContatoCadastradoComSucesso = By.xpath("//div[contains(text(),'Contato cadastrado com sucesso')]");
    private By textoNomeObrigatorio = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]");
    private By linkContato = By.xpath("//div[@id='root']/main/section/div[4]/div[2]/div");
    private By botaoEditar = By.cssSelector("svg.defaultMarginLeft.pointer.flex.flexShrinkNone.endSelf");


    public String getTextoContato() {
        return obterTexto(campoLogin);

    }

    public String getTextoCadastroRealizado() {
        return obterTexto(textoContatoCadastradoComSucesso);

    }

    public String getTextoNomeObrigatorio() {
        return obterTexto(textoNomeObrigatorio);

    }

    public void clicarBotaoNovoContato() {
        clicar(botaoNovoCntato);
    }

    public void inserirNomeContato(String nome) {

        escrever(campoNomeContato, nome);
    }

    public void insrirEmpresa() {
        clicar(campoNomeEmpresa);
        escrever(campoNomeEmpresa, "teste empresa");
        descerValor(campoNomeEmpresa);
        entrar();


    }

    public void inserirCargo(String cargo) {

        escrever(campoCargo, cargo);
    }

    public void inserirEmail(String email) {

        escrever(campoEmail, email);

    }

    public void inserirTEL(String tel) {

        escrever(campoTel, tel);
    }

    public void inserirTELSecun(String telSecun) {

        escrever(campoTelSecun, telSecun);
    }

    public void inserirTELWhats(String telWhats) {

        escrever(campoTelWhats, telWhats);
    }

    public void inserirRazaoSocial(String razao) {

        escrever(campoRdeSocial, razao);
    }

    public void inserirObs(String desc) {

        escrever(campoObservacao, desc);
    }

    public void clicarBotaoSalvar() {

        clicar(botaoSalvar);
    }

    public void clicarContato() {
        clicar(linkContato);
    }

    public void clicarEditar() {

        clicar(botaoEditar);
     //   clicar(botaoSalvarEdicao);
    }
}
