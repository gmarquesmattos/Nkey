package testcases.servicos.healthcheck;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.RestritivoService;

public class RestritivoServiceHealthcheckTest extends RestritivoService {

    @Test(timeOut = 5000)
    public void testConsultarSituacaoCadastralPJStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_SITUACAO_CADASTRAL)
                .body(this.getConsultarSituacaoCadastralPJPayload("92403112000101", "Tela de Relacionamento", "0116", "false", "karine_bonjour", "PLAINT"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(timeOut = 5000)
    public void testConsultarSituacaoCadastralPFStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_SITUACAO_CADASTRAL)
                .body(this.getConsultarSituacaoCadastralPFPayload("41684788072", "Tela de Relacionamento", "0116", "false", "karine_bonjour", "PLAINT"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
