package testcases.time;

import custom.requests.CustomRestAssured;
import geral.service.IsaService;
import org.hamcrest.Matchers;
import org.junit.Test;

public class IsaServiceTimeTest extends IsaService {

    @Test
    public void testVwIsaAssociadosCpfCnpjListaCounterTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA_COUNTER)
                .body(this.getIsaDocumentoPayload("SICREDI", "09541497934", "1"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }

    @Test
    public void testVwIsaAssociadosCpfCnpjListaTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA)
                .body(this.getIsaDocumentoPayload("SICREDI", "09541497934", "1"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }

    @Test
    public void testVwIsaAssociadosCpfCnpjCounterTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_COUNTER)
                .body(this.getIsaDocumentoPayload("SICREDI", "09541497934", "1"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }

    @Test
    public void testVwIsaAssociadosSolucoesListaCounterTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_LISTA_COUNTER)
                .body(this.getIsaContaPayload("0101", "013242", "1"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }

    @Test
    public void testVwIsaAssociadosSolucoesListaTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_LISTA)
                .body(this.getIsaContaPayload("0101", "013242", "1"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }

    @Test
    public void testVwIsaAssociadosSolucoesCounterTime() {
        CustomRestAssured.givenSoap(URL_SERVICE, ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_COUNTER)
                .body(this.getIsaContaPayload("0101", "013242", "1"))
            .when()
                .post()
            .then()
                .time(Matchers.lessThan(TIME_LIMIT));
    }
}
