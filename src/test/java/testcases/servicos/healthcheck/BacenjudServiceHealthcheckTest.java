package testcases.servicos.healthcheck;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.BacenjudService;


public class BacenjudServiceHealthcheckTest extends BacenjudService {

    @Test(timeOut = 9000)
    public void deveVerificarStatusDoServico() {

        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_Bacenjud)
                .body(this.consultarBacenjud("03458997091"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);

    }

}
