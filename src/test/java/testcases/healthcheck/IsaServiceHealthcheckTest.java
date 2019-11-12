package testcases.healthcheck;

import org.apache.http.HttpStatus;
import org.junit.Test;
import servicos.custom.requests.CustomRestAssured;
import servicos.geral.IsaService;

public class IsaServiceHealthcheckTest extends IsaService {

    @Test
    public void testVwIsaAssociadosCpfCnpjListaCounterStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA_COUNTER)
                .body(this.getIsaDocumentoPayload("SICREDI", "09541497934", "1"))
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testVwIsaAssociadosCpfCnpjListaStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA)
                .body(this.getIsaDocumentoPayload("SICREDI", "09541497934", "1"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testVwIsaAssociadosCpfCnpjCounterStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_COUNTER)
                .body(this.getIsaDocumentoPayload("SICREDI", "09541497934", "1"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testVwIsaAssociadosSolucoesListaCounterStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_LISTA_COUNTER)
                .body(this.getIsaContaPayload("0101", "013242", "1"))
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testVwIsaAssociadosSolucoesListaStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_LISTA)
                .body(this.getIsaContaPayload("0101", "013242", "1"))
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testVwIsaAssociadosSolucoesCounterStatus() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_COUNTER)
                .body(this.getIsaContaPayload("0101", "013242", "1"))
            .when()
                .post()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
