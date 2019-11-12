package testcases.time;

import org.hamcrest.Matchers;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.GiroService;

public class GiroServiceTimeTest extends GiroService {

    @Test
    public void testConsultarUltimoContatoTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_ULTIMO_CONTATO)
                .body(this.getConsultarUltimoContatoPayload("0179", "87060331000103"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }
}
