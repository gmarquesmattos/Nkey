package pageObjects.Empresa;

import base.BasePage;
import org.openqa.selenium.By;

public class EmpresaPage extends BasePage {
    private By textoEmpresa = By.xpath("//h1[contains(text(),'Empresas')]");
    private By botaoNovaEmpresa = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[3]/button[1]/span[1]");
    private By textoNovaEmpresa = By.xpath("//h3[contains(text(),'Nova empresa')]");
    private By textoEmpresaSalvaComSucesso = By.xpath("//div[contains(text(),'Empresa cadastrada com sucesso')]");
    private By textoEmpresaNaoSalva = By.xpath("//div[contains(text(),'O nome da empresa é obrigatório')]");
    private By campoEmpresa = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[1]/input[1]");
    private By campoSegmento = By.xpath("//div[@id='root']/main/section/div/div/div[3]/label[2]/div/select");
    private By campoSite = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[3]/input[1]");
    private By campoEmail = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[4]/input[1]");
    private By campoTelefonePrincipal = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[5]/input[1]");
    private By campoTelefoneSecun = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[6]/input[1]");
    private By campoWhastsapp = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[7]/input[1]");
    private By campoRedeSocial = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[8]/input[1]");
    private By campoEndereco = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[9]/input[1]");
    private By campoNumero = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[10]/input[1]");
    private By campoComplemento = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[11]/input[1]");
    private By campoBairro = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[12]/input[1]");
    private By campoCidade = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[13]/input[1]");
    private By campoEstado = By.xpath("//div[@id='root']/main/section/div/div/div[3]/label[14]/div/select");
    private By campoObs = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/label[15]/textarea[1]");
    private By botaoSalvar = By.xpath("//div[@id='root']/main/section/div/div/div[4]/button/span");


    public String getTextoEmpresa() {

        return obterTexto(textoEmpresa);
    }

    public String getTextoModalEmpresa() {

        return obterTexto(textoNovaEmpresa);
    }

    public String getTextoEmpresaSalvaComSucesso() {

        return obterTexto(textoEmpresaSalvaComSucesso);
    }

    public String getTextoEmpresaNaoSalva() {

        return obterTexto(textoEmpresaNaoSalva);
    }

    public void clicarNovaEmpresa() {

        clicar(botaoNovaEmpresa);
    }

    public void inserirEmpresa(String nomeEmpresa) {

        escrever(campoEmpresa, nomeEmpresa);
    }

    public void inserirSegmentoMercado(String valor) {

        selecionarValor(campoSegmento, valor);
    }

    public void inserirSite(String valor) {

        escrever(campoSite, valor);
    }

    public void inserirEmail(String valor) {

        escrever(campoEmail, valor);
    }

    public void inserirTelefone(String valor) {

        escrever(campoTelefonePrincipal, valor);
    }

    public void inserirTelefoneSecu(String valor) {

        escrever(campoTelefoneSecun, valor);
    }

    public void inserirWhats(String valor) {

        escrever(campoWhastsapp, valor);
    }

    public void inserirRedeSocial(String valor) {

        escrever(campoRedeSocial, valor);
    }

    public void inserirEndereco(String valor) {

        escrever(campoEndereco, valor);
    }

    public void inserirNumero(String valor) {

        escrever(campoNumero, valor);
    }

    public void inserirComplemento(String valor) {

        escrever(campoComplemento, valor);
    }

    public void inserirBairro(String valor) {

        escrever(campoBairro, valor);
    }

    public void inserirCidade(String valor) {

        escrever(campoCidade, valor);
    }

    public void inserirEstado(String valor) {

        selecionarValor(campoEstado, valor);

    }

    public void inserirObs(String valor) {

        escrever(campoObs, valor);
    }

    public void clicarBotaoSalvar() {
        clicar(botaoSalvar);

    }

    public void CadastroNovaEmpresa(String nomeEmpresa, String segmento, String site, String email, String tel, String telSecun, String whats, String redeSocial, String Endereco, String numero, String comle, String bairro, String cidade, String estado, String obs) {
        inserirEmpresa(nomeEmpresa);
        inserirSegmentoMercado(segmento);
        inserirSite(site);
        inserirEmail(email);
        inserirTelefone(tel);
        inserirTelefoneSecu(telSecun);
        inserirWhats(whats);
        inserirRedeSocial(redeSocial);
        inserirEndereco(Endereco);
        inserirNumero(numero);
        inserirComplemento(comle);
        inserirBairro(bairro);
        inserirCidade(cidade);
        inserirEstado(estado);
        inserirObs(obs);


    }

    public void CadastroNovaEmpresaSemNome(String nomeEmpresa,String segmento, String site, String email, String tel, String telSecun, String whats, String redeSocial, String Endereco, String numero, String comle, String bairro, String cidade, String estado, String obs) {
      //  inserirEmpresa(nomeEmpresa);
        inserirSegmentoMercado(segmento);
        inserirSite(site);
        inserirEmail(email);
        inserirTelefone(tel);
        inserirTelefoneSecu(telSecun);
        inserirWhats(whats);
        inserirRedeSocial(redeSocial);
        inserirEndereco(Endereco);
        inserirNumero(numero);
        inserirComplemento(comle);
        inserirBairro(bairro);
        inserirCidade(cidade);
        inserirEstado(estado);
        inserirObs(obs);


    }
}