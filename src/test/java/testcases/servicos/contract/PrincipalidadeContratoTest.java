package testcases.servicos.contract;


import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.PrincipalidadeService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static servicos.custom.requests.XsdInClasspath.matchesXsdInClasspath;

public class PrincipalidadeContratoTest extends PrincipalidadeService {
    @Test
    public void deveCompararContrato() throws Exception {
        String response = CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_PRINCIPALIDADE)
              //  .body(this.consultarPrincipalidade("0903", "58321942172", "1"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().asString();

        assertThat(response, matchesXsdInClasspath("schema/consultaPrincipalidadeContrato.xsd"));
    }
}
