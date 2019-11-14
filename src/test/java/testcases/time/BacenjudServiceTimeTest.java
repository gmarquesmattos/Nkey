package testcases.time;

import org.hamcrest.Matchers;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.BacenjudService;

public class BacenjudServiceTimeTest extends BacenjudService {
    @Test
    public void deveRetornarNoTempoEsperado() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_Bacenjud)
                .body(this.consultarBacenjud("03458997091"))
                .when()
                .post()
                .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }




}
