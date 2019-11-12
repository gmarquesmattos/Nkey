package testcases.healthcheck;

import custom.requests.CustomRestAssured;
import geral.service.RestritivoService;
import org.apache.http.HttpStatus;
import org.junit.Test;

public class RestritivoServiceHealthcheckTest extends RestritivoService {
    @Test
    public void testConsultarSituacaoCadastralPJStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_SITUACAO_CADASTRAL)
                .body(this.getConsultarSituacaoCadastralPJPayload("92403112000101", "Tela de Relacionamento", "0116", "false", "karine_bonjour", "PLAINT"))
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testConsultarSituacaoCadastralPFStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_SITUACAO_CADASTRAL)
                .body(this.getConsultarSituacaoCadastralPFPayload("41684788072", "Tela de Relacionamento", "0116", "false", "karine_bonjour", "PLAINT"))
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
