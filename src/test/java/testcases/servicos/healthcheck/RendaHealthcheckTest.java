package testcases.servicos.healthcheck;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.RendaService;

public class RendaHealthcheckTest extends RendaService {

    @Test(timeOut = 5000)
    public void deveConsultarUltimoContatoStatus(){

        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_RENDA)
                .body(this.consultarRenda("14156922"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
