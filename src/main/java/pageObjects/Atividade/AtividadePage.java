package pageObjects.Atividade;

import base.BasePage;
import base.DataUtil;
import org.openqa.selenium.By;

public class AtividadePage extends BasePage {
    private By seletorNegocio = By.xpath("//div[@id='root']/main/section/div/div/div[3]/label/div/select");
    private By dataInicio = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[2]/input[1]");
    private By horaInicio = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[3]/input[1]");
    private By horaFim = By.xpath("//body/div[@id='root']/main[1]/section[1]/div[1]/div[1]/div[3]/label[4]/input[1]");
    private By campoAtividadeNota = By.xpath("//textarea[@type='text']");
    private By iconeTelefone = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/label[1]/div[1]/div[1]");

    private By botaoSalvar = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[4]/button[1]");

    private By mensagemAtividadeSalva = By.xpath("//div[contains(text(),'Atividade cadastrada/atualizada com sucesso')]");
    private By mensagemNegocioObrigatorio = By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]");


    public void escolherOpcaoNegocio(String HoraInicio, String hFim, String desc) {
        selecionarValor(seletorNegocio, "empresa");
        DataUtil dataUtil = new DataUtil();

        escrever(dataInicio, dataUtil.ObterDataAtual());
        System.out.println(dataUtil.ObterHora());
        escrever(horaInicio, HoraInicio);
        escrever(horaFim, hFim);
        escrever(campoAtividadeNota, desc);
        clicar(iconeTelefone);
        clicar(botaoSalvar);


    }

    public String getTextoSalvoComSucesso() {
        return obterTexto(mensagemAtividadeSalva);
    }


    public void salvarSemCampoNegocio(String HoraInicio, String hFim, String desc) {

        DataUtil dataUtil = new DataUtil();

        escrever(dataInicio, dataUtil.ObterDataAtual());
        System.out.println(dataUtil.ObterHora());
        escrever(horaInicio, HoraInicio);
        escrever(horaFim, hFim);
        escrever(campoAtividadeNota, desc);
        clicar(iconeTelefone);
        clicar(botaoSalvar);

    }


    public void salvarSemCampoData(String HoraInicio, String hFim, String desc) {
        selecionarValor(seletorNegocio, "empresa");
        DataUtil dataUtil = new DataUtil();
        escrever(horaInicio, HoraInicio);
        escrever(horaFim, hFim);
        escrever(campoAtividadeNota, desc);
        clicar(iconeTelefone);
        clicar(botaoSalvar);

    }

    public void salvarSemCampoHora(String hFim, String desc) {
        selecionarValor(seletorNegocio, "empresa");
        DataUtil dataUtil = new DataUtil();
        escrever(dataInicio, dataUtil.ObterDataAtual());
        System.out.println(dataUtil.ObterHora());
        escrever(horaFim, hFim);
        escrever(campoAtividadeNota, desc);
        clicar(iconeTelefone);
        clicar(botaoSalvar);

    }

    public void salvarSemCampoHoraFinal(String HoraInicio, String desc) {
        selecionarValor(seletorNegocio, "empresa");
        DataUtil dataUtil = new DataUtil();
        escrever(dataInicio, dataUtil.ObterDataAtual());
        System.out.println(dataUtil.ObterHora());
        escrever(horaInicio, HoraInicio);
        // escrever(horaFim, hFim);
        escrever(campoAtividadeNota, desc);
        clicar(iconeTelefone);
        clicar(botaoSalvar);

    }

    public void salvarSemCampoFormaContato(String HoraInicio, String hFim, String desc) {
        selecionarValor(seletorNegocio, "empresa");
        DataUtil dataUtil = new DataUtil();
        escrever(dataInicio, dataUtil.ObterDataAtual());
        System.out.println(dataUtil.ObterHora());
        escrever(horaInicio, HoraInicio);
        escrever(horaFim, hFim);
        escrever(campoAtividadeNota, desc);
        clicar(botaoSalvar);

    }

    public String getTextoNegocioObrigatorio() {
        return obterTexto(mensagemNegocioObrigatorio);
    }

}
