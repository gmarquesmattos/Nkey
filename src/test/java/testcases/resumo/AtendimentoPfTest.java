package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.AtendimentoPfPage;
import static org.testng.AssertJUnit.assertEquals;


public class AtendimentoPfTest extends BaseTest {


    @Test(retryAnalyzer = Retentativa.class,dataProvider = "cpfSolucaoFinanceiraCoop0718")
    public void deveCriarAtendimentoPf(String cpf) {
        AtendimentoPfPage atendimentoPage = new AtendimentoPfPage();
        atendimentoPage.pesquisarPessoaFisica(cpf);
        atendimentoPage.acessarAtendimento();
        atendimentoPage.realizarNovoAtendimento();
        atendimentoPage.escreverDescricaoAtendimento();
        atendimentoPage.selecionarAgenciaAtendimento();
        atendimentoPage.salvarAtendimento();
        String textoDescricaoAtendimentoTela = atendimentoPage.pesquisarAtendimento();
        String descricaoEsperada = "Novo Atendimento Automacao";

        assertEquals(descricaoEsperada, textoDescricaoAtendimentoTela);

        atendimentoPage.excluirAtendimento();
    }

}
