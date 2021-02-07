package pageObjects.Negocio;

import base.BasePage;
import org.openqa.selenium.By;

public class NovoNegocioPage extends BasePage {
    private By abaNegociacao = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[3]/div[1]/span[1]");
    private By abaQualificacao = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[2]");
    private By abaReuniao = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[3]");
    private By abaNegocioWork = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[4]");
    private By abaPosVenda = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[5]");
    private By campoNegocio = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[4]/label[1]/input[1]");
    private By campoEmpresa = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private By botaoSalvar = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[5]/button[1]/span[1]");
    private By textoNegocioSalcaSucesso = By.xpath("//div[contains(text(),'Negócio cadastrado com sucesso')]");
    private By botaoGanhou = By.xpath("//img[contains(@src,'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAaCAYAAACpSkzOAAAAAXNSR0IArs4c6QAAADhlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAAqACAAQAAAABAAAAGqADAAQAAAABAAAAGgAAAABvAZQwAAACKklEQVRIDaWV4VHCQBCFicN/7cB0YKzA64B0oCXQAZRgB8QOsAKOCoAOsALpIH4vs5e5xAskujPPvdt9b/duk2A2u2F1XRdQFsCB3ICbnQ0e/5ll2RE/3WjgwA6MtR1EN6kTgiqqfmH9DkqQh0JaW0xccYJtAmfQw3wAB1NIvFZsUGAJcYwbGu6u6kgegUwCPZtJJo1pcfUuKSYRxqUmN2+RLEJQWqAasu4YCbgmPOIm8HTqt6FGihsnNHMtl4QHsnUbTCzIq8m3iFieoLQh8uuGFUbIRmKZTjA4MnJxk7qtOLBQLauJq4s7eKVxKz66S0onInE93HCQfYoXx6zW1mLlnIWzjTffcTRR8biJ8vfEVx3ibLanuO/F1OgVOD24M5DlPVKzJb5ssrf/+L4eicYtO2h0jyJwmrN8wsK4EqnrIWoejdE8o+vs8Vl/jaobfYnA9XL5f1jV11KzsNhJjc62CUHbTnIfA6PPrcpFjbxtSvN/cdWAKNT0Gll4M/TFP/QFUZ5l0nxfoz1MfbDhV6SY680goA/wBSzBGrRm+WcCvw4hEnkvnzDVkmavGk2eRg7IdIIiIZoUUg2rhev91yVQKYolRzi2E/p4ZFVSB0ljlP3pZujim/hkEwUh6jRxs5VigwJLmE7c8PD9GJ0ahjGybMQb/AK0z09ri23woQHLurp1sE4egQM62VgT13WKRJssWieXiHWLEjigMT4B2QlcgAfb9hVmk7IfINvuzbPh0dwAAAAASUVORK5CYII=')]");
    private By campoGanhou = By.xpath("(//textarea[@type='text'])[5]");
    private By botaoConfirmar = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[6]/div[1]/div[3]/button[1]/span[1]");
    private By botaoConfirmarPerdeu = By.cssSelector("main.flex section.flexGrow.flex.column div.contentModal.flex.center.absolute.fullWidth.fullScreenHeight.active:nth-child(7) div.modal.card.auto.loseModal.modal-sm div.fullWidth.flex.end.vCenter.defaultMarginTop:nth-child(5) > button.pointer.defaultButton.flex.center");

    private By abaGanhou = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[10]/div[1]/div[7]");
    private By abaPerdeu = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[10]/div[1]/div[6]");
    private By botaoPerdeu = By.xpath("//img[contains(@src,'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAaCAYAAACpSkzOAAAAAXNSR0IArs4c6QAAADhlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAAqACAAQAAAABAAAAGqADAAQAAAABAAAAGgAAAABvAZQwAAACJ0lEQVRIDaWU4VXDMAyEGx7/2w3IBnQDvAEdATZgAzICGzQjlAkaJqBsUCYgG5TvEtm4xm5T0HtXydKdZDtNqtkZOxwOSyj3wIHagJvtDR3+taqqHf5yY4ADWzDVthDdRZMQtFH3nvgFrEDtGym2nLjieFt7TtHDXIB3U0jcKFcUWEEc4/qB25M6ijsgk0DP5iKTxrS4wzYrpuCvS0POniLbhKS0QD1kx9dIwg3pP54kHUqv+GQu1Cl0NqgJySSgXoO7AuqErpM1QDZeIYGmy3Tc7JWR15AvULKvzKAFZPWULa8grIzU8tL1qcDWD/jsJqyups7iwVmvjeVWGuRs0ZnPuadcckLOD3IaVJtglxOy0wfy81xtQm5vnLke2mAlEcWdUc45l+vhRTpR0SAtKd4WCRcUNOhTfJrW8v+wPtXaRpX+uOZnD26Adq84mD79kB9J1CE5Bs/J+k3cJKdlbbleJ2mArLXkSQdPf+XYtJlFTkS+NWKjQUtb6IXMCuImcJzx5U4N0Yb8S67bGp5PZ+JmSJz4gfdk3OIQyeE0xutCOxJ+l9rBOD1UfwfWpHh69QD+NO6oA4UWyCZd4ZE4WqCPr6yNSj8hJF2HbNLJfpRjhC4+SZfWwxqidhMPe1YuEAqB6cT119VN0c0g+WskHMRr/D0Iz0+x5dZ4P4Bw2msS9ozAAe1sqonrQoMkqJL1ryVinWIFHNA1+m/fB3EPOrApfBkojfYNhvE6rah9neYAAAAASUVORK5CYII=')]");
    private By comboMotivoDescarte = By.xpath("//div[@id='root']/main/section/div[8]/div/label/div/select");
    private By campoObsPerdaNegocio = By.xpath("(//textarea[@type='text'])[6]");
    private By abaProspec = By.xpath("//div[@id='root']/main/section/div/div/div[3]/div/span");
    private By campoNomeNegocio = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[1]/div[1]/div[4]/label[1]/input[1]");
    private By abaNovaEtapaPre = By.xpath("//div[@id='root']/main/section/div[9]/div/div[2]/span");
    private By abaNovaetapaPreVendas2 = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[3]");
    private By abaNovaetapaPreVendas3 = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[4]");
    private By abaVisita = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[5]");
    private By abaDemostracao = By.xpath("/html[1]/body[1]/div[1]/main[1]/section[1]/div[9]/div[1]/div[6]");


    public String getTextoNegocioCadastradoSucesso() {

        return obterTexto(textoNegocioSalcaSucesso);
    }


    public void clicarAbaNegocio() {
        clicar(abaNegociacao);
    }

    public void clicarAbaQualificacao() {
        clicar(abaQualificacao);
    }

    public void clicarAbaReuniao() {
        clicar(abaReuniao);
    }

    public void clicarAbaNegocioWork() {
        clicar(abaNegocioWork);
    }

    public void clicarAbaPosVenda() {
        clicar(abaPosVenda);
    }

    public void clicarAbaPros(String texto) {

        clicar(abaProspec);
        escrever(campoNomeNegocio, texto);

    }

    public void inserirNomeNegocio(String NomeNegocio) {
        escrever(campoNegocio, NomeNegocio);
    }

    public void escolherEmpresa(String emppresa) {
        escrever(campoEmpresa, emppresa);
        descerValor(campoEmpresa);
        entrar();
    }

    public void clicarBotaoSalvar() {
        clicar(botaoSalvar);

    }

    public void clicarBotaoGanhou(String texto) {
        clicar(botaoGanhou);
        escrever(campoGanhou, texto);
        clicar(botaoConfirmar);
        clicar(abaGanhou);
    }

    public void clicarBotaoPerdeu(String texto, String opc) {

        clicar(botaoPerdeu);
        selecionarValor(comboMotivoDescarte, opc);
        escrever(campoObsPerdaNegocio, texto);
        clicar(botaoConfirmarPerdeu);
        clicar(abaPerdeu);

    }

    public void clicarAbaNovaAtapaPre() {
        clicar(abaNovaEtapaPre);
    }

    public void clicarAbaNovaEtapa() {
        clicar(abaNovaetapaPreVendas2);
    }
    public void clicarAbaNovaEtapa2() {
        clicar(abaNovaetapaPreVendas3);
    }

    public void clicarAbaVisita() {
        clicar(abaVisita);
    }
    public void clicarAbaDemostracao() {
        clicar(abaDemostracao);
    }
}

