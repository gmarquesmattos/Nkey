package testcases.Negocio;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Home.HomePage;
import pageObjects.Negocio.NegocioPage;
import pageObjects.Negocio.NegocioQualificarPage;
import pageObjects.Negocio.NovoNegocioPage;
import pageObjects.Negocio.QualificarPage;

import static org.testng.Assert.assertEquals;

public class NegocioTeste extends BaseTest {

    @Test
    public void deveAcessarMenuNegocio() {
        HomePage homePage = new HomePage();
        homePage.clicarBotaoNegocio();
        NegocioPage negocioPage = new NegocioPage();

        assertEquals(TEXTO_TITULO_NEGOCIO, negocioPage.getTextoNegocio());

    }

    @Test
    public void deveCriarNovoNegocio() {
        HomePage homePage = new HomePage();
        homePage.clicarBotaoNegocio();
        NegocioPage negocioPage = new NegocioPage();
        negocioPage.clicarNovoNegocio();
        NovoNegocioPage novoNegocioPage = new NovoNegocioPage();
        esperar(3000);
        novoNegocioPage.clicarAbaNegocio();
        novoNegocioPage.inserirNomeNegocio(NOME_NEGOCIO);
        novoNegocioPage.escolherEmpresa(NOME_EMPRESA);
        novoNegocioPage.clicarBotaoSalvar();

        assertEquals(TEXTO_NEGOCIO_CADASTRADO_COM_SUCESSO, novoNegocioPage.getTextoNegocioCadastradoSucesso());

    }

    @Test

    public void deveQualificarNegociacaoEAgendarAtividade() {
        deveCriarNovoNegocio();
        NegocioPage negocioPage = new NegocioPage();
        esperar(2000);
        negocioPage.clicarNaOportunidade();
        NegocioQualificarPage negocioQualificarPage = new NegocioQualificarPage();
        negocioQualificarPage.clicarBotaoQualificar();
        QualificarPage qualificar = new QualificarPage();
        qualificar.clicarComboNegociacao();
        qualificar.inserirObservacaoEQualificar(TEXTO_OBD_QUALIFICACAO);
        esperar(4000);
        assertEquals(QUALIFICACAO_CAD_SUCESSO, qualificar.getTextoQualificacaoCadSucesso());
        qualificar.inserirdataReuniao(HORA_INICIO, HORA_FIM, VENDE_RESP, TEXTO_ATIVIDADE_NOTA);
        esperar(4000);
        assertEquals(ATIVIDADE_AGENDADA_COM_SUCESSO, qualificar.getTextoQualificacaoSucesso());


    }

    @Test

    public void deveAtenderProximaAtividade() {
        deveQualificarNegociacaoEAgendarAtividade();
        QualificarPage qualificarPage = new QualificarPage();
        esperar(6000);
        qualificarPage.finalizarAtividade();
        assertEquals(ATIVIDADE_ATUALIZADA_COM_SUCESSO, qualificarPage.getTextoQualificacaoSucesso());

    }

    @Test

    public void deveRealizarFluxoDaNegociação() {
        deveCriarNovoNegocio();
        QualificarPage qualificarPage = new QualificarPage();
        esperar(4000);
        NegocioPage negocioPage = new NegocioPage();
        esperar(2000);
        negocioPage.clicarNaOportunidade();
        qualificarPage.finalizarAtividade();
        assertEquals(ATIVIDADE_ATUALIZADA_COM_SUCESSO, qualificarPage.getTextoQualificacaoSucesso());
        NovoNegocioPage novoNegocioPage = new NovoNegocioPage();
        novoNegocioPage.clicarAbaQualificacao();
        esperar(4000);
        assertEquals(ETAPA_NEGOCIO_REALIZADA_SUCESSO, qualificarPage.getTextoQualificacaoSucesso());
        esperar(3000);
        qualificarPage.finalizarAtividade();
        novoNegocioPage.clicarAbaReuniao();
        esperar(4000);
        assertEquals(ETAPA_NEGOCIO_REALIZADA_SUCESSO, qualificarPage.getTextoQualificacaoSucesso());
        esperar(3000);
        novoNegocioPage.clicarAbaNegocioWork();
        assertEquals(ETAPA_NEGOCIO_REALIZADA_SUCESSO, qualificarPage.getTextoQualificacaoSucesso());
        esperar(3000);
        novoNegocioPage.clicarAbaPosVenda();
        assertEquals(ETAPA_NEGOCIO_REALIZADA_SUCESSO, qualificarPage.getTextoQualificacaoSucesso());

    }

    @Test
    public void deveAtualizarParaGanhou() {
        deveRealizarFluxoDaNegociação();
        NovoNegocioPage novoNegocioPage = new NovoNegocioPage();
        novoNegocioPage.clicarBotaoGanhou(TEXTO_GANHOU);
        QualificarPage qualificarPage = new QualificarPage();
        esperar(8000);

        assertEquals(ETAPA_NEGOCIO_DEU_CERTO, qualificarPage.getTextoGanhouSucesso());

    }


    @Test
    public void naoDeveCriarAtividadeNotaSemPreferencia() {
        deveCriarNovoNegocio();
        NegocioPage negocioPage = new NegocioPage();
        esperar(2000);
        negocioPage.clicarNaOportunidade();
        QualificarPage qualificarPage = new QualificarPage();
        qualificarPage.cadastrarAtividadeNota(TEXTO_ATIVIDADE_NOTA, HORA_INICIO, HORA_FIM);
       // esperar(1000);
        assertEquals(TEXTO_FORMA_CONTATO_ATIV_NOTA, qualificarPage.getTextoFormaContato());


    }


//    @Test
//    public void deveAtualizarParaPerdeu() {
//        deveRealizarFluxoDaNegociação();
//        NovoNegocioPage novoNegocioPage = new NovoNegocioPage();
//        novoNegocioPage.clicarBotaoPerdeu(TEXTO_GANHOU,MOTIVO_DESCARTE);
//        QualificarPage qualificarPage = new QualificarPage();
//        esperar(8000);
//
//        assertEquals(ETAPA_NEGOCIO_DEU_CERTO, qualificarPage.getTextoGanhouSucesso());
//
//    }

}