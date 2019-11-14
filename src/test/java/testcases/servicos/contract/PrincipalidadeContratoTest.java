package testcases.servicos.contract;

import org.junit.Test;
import org.apache.http.HttpStatus;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.PrincipalidadeService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static servicos.custom.requests.XsdInClasspath.matchesXsdInClasspath;

public class PrincipalidadeContratoTest extends PrincipalidadeService {
    @Test
    public void deveCompararContrato() throws Exception {
        String response = CustomRestAssured.givenSoap(URL_SERVICE, ACTION_CONSULTAR_PRINCIPALIDADE)
                .body(this.consultarPrincipalidade("0903", "58321942172", "1"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().asString();
      //  assertThat(response, matchesXsdInClasspath("consultaPrincipalidadeContrato.xsd"));

        //   String var  ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"><soapenv:Header xmlns:prin=\"http://sicredi.com.br/crm/ws/v1/principalidade\"/><soapenv:Body xmlns:prin=\"http://sicredi.com.br/crm/ws/v1/principalidade\">\n        <princip:consultarPrincipalidadeResponse xmlns:princip=\"http://sicredi.com.br/crm/ws/v1/principalidade\"><princip:outConsultarPrincipalidade><princip:principalidades><princip:principalidade><princip:score>25.28</princip:score><princip:faixa_principalidade>Baixa</princip:faixa_principalidade><princip:i_pred>0</princip:i_pred><princip:datPeriodo>08/2019</princip:datPeriodo></princip:principalidade></princip:principalidades></princip:outConsultarPrincipalidade></princip:consultarPrincipalidadeResponse>\n    </soapenv:Body></soapenv:Envelope>";
       // assertEquals(response, var);


    }

}
