package testcases.servicos.contract;

import org.apache.http.HttpStatus;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.GiroService;
import static org.hamcrest.MatcherAssert.assertThat;
import static servicos.custom.requests.XsdInClasspath.matchesXsdInClasspath;

public class GiroServiceContractTest extends GiroService {

    @Test
    public void testConsultarUltimoContatoContract() throws Exception{
        String response = CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_ULTIMO_CONTATO)
            .body(this.getConsultarUltimoContatoPayload("0179", "87060331000103"))
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.SC_OK)
            .extract().asString();

        assertThat(response, matchesXsdInClasspath("consultarUltimoContrato.xsd"));
    }
}
