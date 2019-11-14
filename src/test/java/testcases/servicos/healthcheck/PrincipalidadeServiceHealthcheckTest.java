package testcases.servicos.healthcheck;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.PrincipalidadeService;

public class PrincipalidadeServiceHealthcheckTest extends PrincipalidadeService {

    @Test(timeOut = 5000)
    public void deveVerificarStatusDoServico(){

        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_PRINCIPALIDADE)
                .body(this.consultarPrincipalidade("0903", "58321942172", "1"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
