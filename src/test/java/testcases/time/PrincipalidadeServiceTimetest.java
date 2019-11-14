package testcases.time;

import org.hamcrest.Matchers;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.PrincipalidadeService;

public class PrincipalidadeServiceTimetest extends PrincipalidadeService {

    @Test
    public void testConsultarUltimoContatoTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_PRINCIPALIDADE)
                .body(this.consultarPrincipalidade("0903", "58321942172", "1"))
                .when()
                .post()
                .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }

}
