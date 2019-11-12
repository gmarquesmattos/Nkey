package testcases.time;


import org.hamcrest.Matchers;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.CraService;

public class CraServiceTimeTest extends CraService {

    @Test
    public void testConsultarUltimoContatoTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_CRA)
                .body(this.getConsultarCraPayload("0230", "99227401091"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }
}
