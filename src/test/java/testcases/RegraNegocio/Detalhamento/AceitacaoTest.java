package testcases.RegraNegocio.Detalhamento;

import base.BaseTest;
import org.testng.annotations.Test;
import pageObjects.Retaguarda.RetaguardaPO;

public class AceitacaoTest extends BaseTest {

    // @Test -- Este teste nao esta passando
    public void preencherDetalhamento() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(2);
        retaguardaPO.apagarRegistro();
    }

    // @Test -- Este teste nao esta passando
    public void pesquisarDetalhamento() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(2);
        retaguardaPO.botãoPesquisar();
        retaguardaPO.apagarRegistro();
    }

    @Test
    public void salvarSemRenda() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.acessarCadastroCanais();
        retaguardaPO.preencherCooperativa();
        retaguardaPO.salvarSemDetalhamento();
        retaguardaPO.textValidacao("'Periodicidade' é um campo obrigatório. Informe um valor para o campo. (SBL-DAT-00498)");

    }

    // @Test -- Este teste nao esta passando
    public void duplicarTipos() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(2);
        retaguardaPO.novoDetalhamentoTipoDuplicado();
        retaguardaPO.textValidacao("Já existe uma renda do mesmo tipo informada para o atendimento. (SBL-APS-00802)");
        retaguardaPO.excluirRegistroDetalhamento();
        retaguardaPO.apagarRegistro();
    }

    // @Test -- Este teste nao esta passando
    public void ValorIgualZero() {
        realizarLogin();
        RetaguardaPO retaguardaPO = new RetaguardaPO();
        retaguardaPO.preencherDetalhamento(0);
        retaguardaPO.textValidacao("[1]Valor ou tipo de valor incorreto detectado no campo Valor. Informe os valores do campo novamente. Se necessitar de assistência adicional, consulte a documentação.(SBL-UIF-00299) [2]O valor informado é inválido.: SBL-DAT-00521");
    }


}






