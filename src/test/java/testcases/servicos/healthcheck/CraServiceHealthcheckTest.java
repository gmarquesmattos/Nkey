package testcases.servicos.healthcheck;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.CraService;


public class CraServiceHealthcheckTest  extends CraService {
    @Test(timeOut = 7000)
    public void deveConsultarUltimoContatoStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_CRA)
                .body(this.getConsultarCraPayload("0230", "99227401091"))
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
