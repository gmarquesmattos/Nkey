package testcases.resumo;

import base.BaseTest;
import base.Retentativa;
import org.testng.annotations.Test;
import pageObjects.resumo.NovoContatoAtendimentoPfPage;
import static org.testng.AssertJUnit.assertEquals;

public class NovoContatoAtendimentoPfTest extends BaseTest {

    @Test (retryAnalyzer = Retentativa.class,dataProvider = "cpfSolucaoFinanceiraCoop0718")
    public void deveCriarNovoContatoAtendimentoPf(String cpf){

        NovoContatoAtendimentoPfPage novoContatoAtendimentoPfPage = new NovoContatoAtendimentoPfPage();
        novoContatoAtendimentoPfPage.pesquisarPessoaFisica(cpf);
        novoContatoAtendimentoPfPage.criarNovoContato();
        novoContatoAtendimentoPfPage.criarNovoAtendimento();
        novoContatoAtendimentoPfPage.escreverAtendimento();
        novoContatoAtendimentoPfPage.selecionarAgenciaAtendimento();
        novoContatoAtendimentoPfPage.salvarAtendimento();

        String textodescricao = novoContatoAtendimentoPfPage.pesquisarAtendimento();
        String descricaoEsperada = "Novo Atendimento Automação PF";

        assertEquals(descricaoEsperada,textodescricao);

        novoContatoAtendimentoPfPage.excluirAtendimento();
    }
}
