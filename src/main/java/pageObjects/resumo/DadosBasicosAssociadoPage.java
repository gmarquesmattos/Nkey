package pageObjects.resumo;

import base.BasePage;
import org.openqa.selenium.By;
import pageObjects.home.HomePage;
import pageObjects.pessoa.PessoaFisicaPage;
import java.util.ArrayList;

public class DadosBasicosAssociadoPage extends BasePage {

    private By rotuloNomeCompleto = By.id("s_6_1_19_0");
    private By rotuloDataNascimento = By.id("s_6_1_13_0");
    private By rotuloEstadoCivil = By.id("s_6_1_7_0");
    private By rotuloCpf = By.id("s_6_1_10_0");
    private By rotuloRg = By.id("s_6_1_14_0");
    private By rotuloAssociadoDesde = By.id("s_6_1_8_0");
    private By rotuloGrupoEconomico = By.id("s_6_1_11_0");
    private By rotuloCbo = By.id("s_6_1_9_0");

    public DadosBasicosAssociadoPage() {
           acessar();
    }

    public void pesquisarPessoaFisica(String cpf) {
        new PessoaFisicaPage(cpf).acessarNomeCompleto();
    }

    public ArrayList<String> obterValor() {
        ArrayList<String> informacoesResumoAssociado = new ArrayList<>();
        informacoesResumoAssociado.add(obterTexto(rotuloNomeCompleto).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloDataNascimento).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloEstadoCivil).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloCpf).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloRg).trim());
        informacoesResumoAssociado.add(obterTexto(rotuloAssociadoDesde));
        informacoesResumoAssociado.add(obterTexto(rotuloGrupoEconomico));
        informacoesResumoAssociado.add(obterTexto(rotuloCbo).trim());

        return informacoesResumoAssociado;
    }

    private void acessar() {
        HomePage homePage = new HomePage();
        homePage.acessarPessoaFisica();
    }


}
