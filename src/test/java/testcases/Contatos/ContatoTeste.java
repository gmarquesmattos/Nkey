package testcases.Contatos;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Contatos.ContatosPage;
import pageObjects.Home.HomePage;


import static org.testng.Assert.assertEquals;

public class ContatoTeste extends BaseTest {

    @Test
    public void deveAcessarMenuContatos() {
        HomePage homePage = new HomePage();
        homePage.clicarMenuContatos();
        ContatosPage contatosPage = new ContatosPage();
        assertEquals(TEXTO_CONTATOS, contatosPage.getTextoContato());


    }


    @Test
    public void deveCriarNovoContato() {
        HomePage homePage = new HomePage();
        homePage.clicarMenuContatos();
        ContatosPage contatosPage = new ContatosPage();
        contatosPage.clicarBotaoNovoContato();
        contatosPage.inserirNomeContato(NOME_CONTATO);
        contatosPage.insrirEmpresa();
        contatosPage.inserirCargo(CARGO);
        contatosPage.inserirEmail(EMAIL);
        contatosPage.inserirTEL(TELEFONE_PRINCIPAL);
        contatosPage.inserirTELSecun(TELEFONE_SECUNDARIO);
        contatosPage.inserirTELWhats(TELEFONE_WHATSAPP);
        contatosPage.inserirRazaoSocial(TEXTO_RAZAO_SOCIAL);
        contatosPage.inserirObs(TEXTO_OBS);
        contatosPage.clicarBotaoSalvar();
        assertEquals(TEXTO_CADASTRO_CADASTRADO_SUCESSO, contatosPage.getTextoCadastroRealizado());

    }

    @Test
    public void naoDdeveCriarNovoContatoSemNome() {
        HomePage homePage = new HomePage();
        homePage.clicarMenuContatos();
        ContatosPage contatosPage = new ContatosPage();
        contatosPage.clicarBotaoNovoContato();
        contatosPage.insrirEmpresa();
        contatosPage.inserirCargo(CARGO);
        contatosPage.inserirEmail(EMAIL);
        contatosPage.inserirTEL(TELEFONE_PRINCIPAL);
        contatosPage.inserirTELSecun(TELEFONE_SECUNDARIO);
        contatosPage.inserirTELWhats(TELEFONE_WHATSAPP);
        contatosPage.inserirRazaoSocial(TEXTO_RAZAO_SOCIAL);
        contatosPage.inserirObs(TEXTO_OBS);
        contatosPage.clicarBotaoSalvar();
        assertEquals(TEXTO_NOME_OBRIGATORIO, contatosPage.getTextoNomeObrigatorio());

    }

    @Test
    public void deveEditarContato() {
        HomePage homePage = new HomePage();
        homePage.clicarMenuContatos();
        ContatosPage contatosPage = new ContatosPage();
        contatosPage.clicarContato();
        contatosPage.clicarEditar();

    }
}