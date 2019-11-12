package testcases.time;


import org.hamcrest.Matchers;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.RestritivoService;

public class RestritivoServiceTimeTest extends RestritivoService {
    @Test
    public void testConsultarSituacaoCadastralPJTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_SITUACAO_CADASTRAL)
                .body(this.getConsultarSituacaoCadastralPJPayload("92403112000101", "Tela de Relacionamento", "0116", "false", "karine_bonjour", "PLAINT"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }

    @Test
    public void testConsultarSituacaoCadastralPFTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_SITUACAO_CADASTRAL)
                .body(this.getConsultarSituacaoCadastralPFPayload("41684788072", "Tela de Relacionamento", "0116", "false", "karine_bonjour", "PLAINT"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }
}
