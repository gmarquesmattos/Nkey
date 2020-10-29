package testcases.LGAtendimento;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Atendmento.AtendimentoChamado.AtendimentoChamadoPage;
import pageObjects.Atendmento.AtendimentoHome.AtendimentoHomePage;
import pageObjects.Atendmento.EngrenagemAdm.EngrenagemAdmPage;
import pageObjects.Atendmento.Home.HomePage;
import pageObjects.Atendmento.LogExecucaoEtapas.LogExecucaoEtapaPage;
import pageObjects.Atendmento.ManutencaoChamados.NovoChamadoPage;
import pageObjects.Atendmento.PesquisaClientes.PesquisaDeClientesPage;
import pageObjects.Atendmento.PesquisaContato.PesquisaContatoPage;
import pageObjects.Atendmento.RegistroDeAtividades.RegistroDeAtividadePage;


import static org.testng.Assert.assertEquals;


public class AtendimentoTeste extends BaseTest {

    String numeroChamado, idCliente, idContato;


    @Test
    public void deveLogarNoPortalAtendimento() {
        HomePage homePage = new HomePage();
        esperar(3000);
        assertEquals(RODAPE_LOGIN_USUARIO, homePage.getRodapePagina());


    }

    @Test

    public void deveCriarChamado() {
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.clicarNemuChamados();
        NovoChamadoPage novoChamadoPage = new NovoChamadoPage();
        novoChamadoPage.inserirClienteContato(ID_CLIENTE, ID_CONTATO);
        novoChamadoPage.inserirTipoPrioridadeCategorias();
        novoChamadoPage.inserircategoria1();
        esperar(2000);
        novoChamadoPage.inserirCategoria2();
        esperar(2000);
        novoChamadoPage.inserirCategoria3();
        esperar(2000);
        novoChamadoPage.inserirTituloDescrucao();
        esperar(2000);
        novoChamadoPage.inserirInformacaoAdicional();
        esperar(2000);
        novoChamadoPage.clicarBoaoProcessar();
        esperar(2000);
        numeroChamado = novoChamadoPage.obterNumeroChamadoCriado();

    }

    @Test
    public void deveCriarClientes() {

        EngrenagemAdmPage engrenagemAdmPage = new EngrenagemAdmPage();
        engrenagemAdmPage.acessarMenuPesquisaCliente();
        PesquisaDeClientesPage pesquisaDeClientesPage = new PesquisaDeClientesPage();
        pesquisaDeClientesPage.fecharPesquisa();
        pesquisaDeClientesPage.clicarBotaoNovoClientePreencharCadastroCliente(NOME_CLIENTE_AUTOMACAO, NOME_CLIENTE_RAZAO_AUTOMACAO, CNPJ_AUTOMACAO, TIPO_CLIENTE);
        esperar(5000);
        idCliente = pesquisaDeClientesPage.getIdCliente();
        pesquisaDeClientesPage.fecharPagina();
    }


    @Test
    public void deveCriarContato() {
        EngrenagemAdmPage engrenagemAdmPage = new EngrenagemAdmPage();
        engrenagemAdmPage.acessarMenuPesquisaContato();
        PesquisaContatoPage pesquisaContatoPage = new PesquisaContatoPage();
        pesquisaContatoPage.fecharPesquisa();
        pesquisaContatoPage.PreencherNovoContato(COD_CLI_CONTATO, NOME_CONTATO_AUTOMACAO);
        esperar(5000);
        idContato = pesquisaContatoPage.getIdContato();

    }

    @Test

    public void devePesquisarPorChamado() {
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.pesquisarPorchamdo(CHAMADO_ATENDIMENTO);
        esperar(5000);
        assertEquals(MENSAGEM_PESQUISA_CHAMADO, atendimentoHomePage.getTextoTituloPesquisa());

    }

    @Test
    public void devePesquisarPeloChamado() {
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.clicarclicarBotaoPesquisar();
        atendimentoHomePage.acessarFrame();
        atendimentoHomePage.escreverChamdo(CHAMADO_ATENDIMENTO);
        atendimentoHomePage.iserirDataInicioDataFim(DATA_PESQUISA_INICIO, DATA_PESQUISA_FIM);
        atendimentoHomePage.clicarBotaoPesquisar();
        esperar(5000);

        assertEquals(CHAMADO_ATENDIMENTO, atendimentoHomePage.getTextoGridNumeroChamado());


    }


    @Test
    public void devePesquisarPelocliente() {
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.clicarclicarBotaoPesquisar();
        atendimentoHomePage.acessarFrame();
        atendimentoHomePage.iserirDataInicioDataFim(DATA_PESQUISA_INICIO, DATA_PESQUISA_FIM);
        atendimentoHomePage.inserirCliente(NOME_CLIENTE);
        atendimentoHomePage.clicarBotaoPesquisar();
        esperar(5000);

        assertEquals(NOME_CLIENTE, atendimentoHomePage.getTextoGridNomeCliente());


    }

    @Test
    public void devePesquisarPeloResponsavel() {
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.clicarclicarBotaoPesquisar();
        atendimentoHomePage.acessarFrame();
        atendimentoHomePage.iserirDataInicioDataFim(DATA_PESQUISA_INICIO, DATA_PESQUISA_FIM);
        atendimentoHomePage.inserirResponsavel(RESPONSAVEL_CHAMADO);
        atendimentoHomePage.clicarBotaoPesquisar();
        esperar(5000);

        assertEquals(RESPONSAVEL_CHAMADO, atendimentoHomePage.getTextoGridNomeResponsavel());


    }


    @Test
    public void devePesquisarPeloTipoEquipe() {
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.clicarclicarBotaoPesquisar();
        atendimentoHomePage.acessarFrame();
        atendimentoHomePage.iserirDataInicioDataFim(DATA_PESQUISA_INICIO, DATA_PESQUISA_FIM);
        atendimentoHomePage.inserirTipoDeEquipe(TIPO_DE_EQUIPE);
        atendimentoHomePage.clicarBotaoPesquisar();
        esperar(5000);

        assertEquals(VALOR_CAMPO_TIPO_EQUIPE, atendimentoHomePage.getTextoNomeEquipe());


    }

    @Test
    public void devePesquisarPelaEquipe() {
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.clicarclicarBotaoPesquisar();
        atendimentoHomePage.acessarFrame();
        atendimentoHomePage.iserirDataInicioDataFim(DATA_PESQUISA_INICIO, DATA_PESQUISA_FIM);
        atendimentoHomePage.inserirEquipe(EQUIPE);
        atendimentoHomePage.clicarBotaoPesquisar();
        esperar(5000);

        assertEquals(VALOR_CAMPO_EQUIPE, atendimentoHomePage.getTextoNomeEquipe());


    }


    @Test
    public void deveAvancarEtapaPelaGrid() {
        deveCriarChamado();
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.pesquisarPorchamdo(numeroChamado);
        atendimentoHomePage.cicarComboChamado();
        atendimentoHomePage.trocarEtapaInicarAtendimento();
        LogExecucaoEtapaPage logExecucaoEtapaPage = new LogExecucaoEtapaPage();

        Assert.assertTrue(logExecucaoEtapaPage.getTextoTrocaEtapa().contains(TEXTO_ETAPA_AVANCADA_ENVIAR_ANEXO));
        logExecucaoEtapaPage.fecharPagLog();
        atendimentoHomePage.trocarEtapaEnviarAnexos();

        Assert.assertTrue(logExecucaoEtapaPage.getTextoTrocaEtapa().contains(TEXTO_ETAPA_AVANCADA_ENVIAR_SIM));
        logExecucaoEtapaPage.fecharPagLog();
        atendimentoHomePage.trocarEtapaEncerrarAtendimento();

        Assert.assertTrue(logExecucaoEtapaPage.getTextoTrocaEtapa().contains(TEXTO_ETAPA_AVANCADA_ENCERRAR_ATENDIMENTO));
        logExecucaoEtapaPage.fecharPagLog();
    }


    @Test
    public void deveAvancarEtapaPeloChamado() {
        deveCriarChamado();
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.getpop();
        AtendimentoChamadoPage atendimentoChamadoPage = new AtendimentoChamadoPage();
        esperar(5000);
        assertEquals(TEXTO_ETAPA_INICIAR_ATENDIMENTO, atendimentoChamadoPage.getNomeEtapa());
        atendimentoChamadoPage.clicarEtapaIniciarAtendimentoDentroChamado();
        esperar(5000);
        assertEquals(TEXTO_ETAPA_ENVIAR_ANEXOS, atendimentoChamadoPage.getNomeEtapa());
        atendimentoChamadoPage.clicarEtapaIniciarAtendimentoDentroChamado();
        atendimentoChamadoPage.clicarFluxoSim();
        esperar(5000);
        assertEquals(TEXTO_ETAPA_SIM, atendimentoChamadoPage.getNomeEtapa());
        atendimentoChamadoPage.clicarEtapaIniciarAtendimentoDentroChamado();
        esperar(5000);

        assertEquals(TEXTO_ETAPA_ENCERRAR_ATENDIMENTO, atendimentoChamadoPage.getNomeEtapa());
    }

    @Test

    public void deveRealizarEncerramentoChamado() {
        deveAvancarEtapaPeloChamado();
        AtendimentoChamadoPage atendimentoChamadoPage = new AtendimentoChamadoPage();
        atendimentoChamadoPage.clicarAbaEncerramento(RESPONSAVEL_PELO_ENCERRAMENTO);
        atendimentoChamadoPage.escolherCausaFCA(VALOR_ENCERRAMENTO_CAUSA_FCA);
        atendimentoChamadoPage.escolhercausaSolucao(TEXTO_ENCERRAMENTO_SOLUCAO);
        esperar(5000);
        atendimentoChamadoPage.clicarBotaoEncerrarAtendimento();
        esperar(5000);
        assertEquals(TEXTO_ETAPA_ENCERRAR, atendimentoChamadoPage.getNomeEtapa());

    }

    //////////////////////// fazer encerramento pela grid

    ///////////////////////////////////////////

    @Test
    public void deveRegistrarAcompanhamentoPelaGrid() {
        deveCriarChamado();
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.pesquisarPorchamdo(numeroChamado);
        atendimentoHomePage.clicarMenuAcaoRegistrarAcompanhamento();
        RegistroDeAtividadePage registroDeAtividadePage = new RegistroDeAtividadePage();

        assertEquals(TEXTO_REGISTRO_SALVO_COM_SUCESO, registroDeAtividadePage.escreverNoCampoRegistrarAtividade());
    }

    @Test
    public void deveRegistrarAcompanhamentoPeloChamado() {
        deveCriarChamado();
        AtendimentoHomePage atendimentoHomePage = new AtendimentoHomePage();
        atendimentoHomePage.pesquisarPorchamdo(numeroChamado);
        atendimentoHomePage.abriChamdado();
        AtendimentoChamadoPage atendimentoPage = new AtendimentoChamadoPage();
        atendimentoPage.clicarAbaAtendimento();
        atendimentoPage.inserirDataInicio();
        atendimentoPage.clicarDataFim();
        atendimentoPage.inserirHoraInicio();
        atendimentoPage.inserirHoraFim();
        atendimentoPage.inseriAcompanhamento(TEXTO_DESCRICAO_ACOMPANHAMENTO);
        atendimentoPage.escolherTipoAcompanhamento();
        atendimentoPage.clicarRegistrar();


    }

    @Test
    public void devePesquisarPorCliente() {
        deveCriarClientes();
        PesquisaDeClientesPage pesquisaDeClientesPage = new PesquisaDeClientesPage();
        pesquisaDeClientesPage.inserirIdCliente(idCliente);
        pesquisaDeClientesPage.getPopUp();
        esperar(9000);
        assertEquals(idCliente, pesquisaDeClientesPage.getIdCliente());

    }

    @Test
    public void devePesquisarPorContato() {
        deveCriarContato();
        PesquisaContatoPage pesquisaContatoPage = new PesquisaContatoPage();
        pesquisaContatoPage.inserirNomeContato(idContato, NOME_CONTATO_AUTOMACAO);
        esperar(9000);

        assertEquals(idContato, pesquisaContatoPage.abrirContato());

    }


}

