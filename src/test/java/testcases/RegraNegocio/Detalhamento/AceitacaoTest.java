package testcases.RegraNegocio.Detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Retaguarda.RetaguardaPO;

public class AceitacaoTest extends BaseTest {

    public static final int valorDetalhamento = 2;
    public static final int valorDetalhamentoValorZero = 0;

    @Test
    public void devePreencherDetalhamento() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(valorDetalhamento);
        retaguardaPO.apagarRegistro();
    }

     @Test
    public void devePesquisarDetalhamento() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(valorDetalhamento);
        retaguardaPO.botaoPesquisar();
        retaguardaPO.apagarRegistro();
    }

    @Test
    public void naoDeveSalvarSemRenda() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.acessarCadastroCanais();
        retaguardaPO.preencherCooperativa();
        retaguardaPO.salvarSemDetalhamento();
        retaguardaPO.textValidacao("'Periodicidade' é um campo obrigatório. Informe um valor para o campo. (SBL-DAT-00498)");

    }

    @Test
    public void naoDeveSalvarComTiposDuplicado() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(valorDetalhamento);
        retaguardaPO.novoDetalhamentoTipoDuplicado();
        retaguardaPO.textValidacao("Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)");
        retaguardaPO.excluirRegistroDetalhamento();
        retaguardaPO.apagarRegistro();
    }



     @Test
    public void naoDeveSalvarComTiposDuplicadoBotaoDetalhamentoNovo() {
         realizarLogin();
         RetaguardaPO retaguardaPO = new RetaguardaPO();
         retaguardaPO.preencherDetalhamento(valorDetalhamento);
         retaguardaPO.TipoDuplicadoBotaoNovodetalhamento();
         retaguardaPO.textValidacao("Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)");
         retaguardaPO.excluirRegistroDetalhamento();
         retaguardaPO.apagarRegistro();

     }
    @Test
    public void naoDeveSalvarValorIgualZero() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(valorDetalhamentoValorZero);
        retaguardaPO.textValidacao("[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521");
    }
}






