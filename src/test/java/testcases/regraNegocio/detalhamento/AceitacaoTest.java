package testcases.regraNegocio.detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.retaguarda.RetaguardaPage;

public class AceitacaoTest extends BaseTest {

    public static final int valorDetalhamento = 2;
    public static final int valorDetalhamentoValorZero = 0;

    @Test
    public void deveriaPreencherDetalhamento() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.preencherDetalhamento(valorDetalhamento);
        retaguardaPage.apagarRegistro();
    }

    @Test
    public void devePesquisarDetalhamento() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.preencherDetalhamento(valorDetalhamento);
        retaguardaPage.botaoPesquisar();
        retaguardaPage.apagarRegistro();
    }

    @Test
    public void naoDeveSalvarSemRenda() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.acessarCadastroCanais();
        retaguardaPage.preencherCooperativa();
        retaguardaPage.salvarSemDetalhamento();
        retaguardaPage.textValidacao("'Periodicidade' é um campo obrigatório. Informe um valor para o campo. (SBL-DAT-00498)");

    }

    @Test
    public void naoDeveSalvarComTiposDuplicado() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.preencherDetalhamento(valorDetalhamento);
        retaguardaPage.novoDetalhamentoTipoDuplicado();
        retaguardaPage.textValidacao("Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)");
        retaguardaPage.excluirRegistroDetalhamento();
        retaguardaPage.apagarRegistro();
    }


    @Test
    public void naoDeveSalvarComTiposDuplicadoBotaoDetalhamentoNovo() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.preencherDetalhamento(valorDetalhamento);
        retaguardaPage.TipoDuplicadoBotaoNovodetalhamento();
        retaguardaPage.textValidacao("Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)");
        retaguardaPage.excluirRegistroDetalhamento();
        retaguardaPage.apagarRegistro();

    }

    @Test
    public void naoDeveSalvarValorIgualZero() {
        RetaguardaPage retaguardaPage = new RetaguardaPage(driver);
        retaguardaPage.preencherDetalhamento(valorDetalhamentoValorZero);
        retaguardaPage.textValidacao("[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521");
    }
}






