package testcases.healthcheck;

import org.apache.http.HttpStatus;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.GiroService;

public class GiroServiceHealthcheckTest extends GiroService {

    @Test
    public void testConsultarUltimoContatoStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_ULTIMO_CONTATO)
                .body(this.getConsultarUltimoContatoPayload("0179", "87060331000103"))
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
