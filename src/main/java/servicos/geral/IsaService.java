package servicos.geral;

import utils.servicos.ParametroXML;
import utils.servicos.Payload;
import utils.servicos.PayloadBuilder;

import static utils.CommonUtils.getProperty;

public class IsaService {
    protected static final String URL_SERVICE = getProperty("service.isa");
    protected static final Long TIME_LIMIT = 5000L;
    protected static final String ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA_COUNTER = "VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA_COUNTER";
    protected static final String ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA = "VW_ISA_ASSOCIADOS_CPF_CNPJ_LISTA";
    protected static final String ACTION_VW_ISA_ASSOCIADOS_CPF_CNPJ_COUNTER = "VW_ISA_ASSOCIADOS_CPF_CNPJ_COUNTER";
    protected static final String ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_LISTA_COUNTER = "VW_ISA_ASSOCIADOS_SOLUCOES_LISTA_COUNTER";
    protected static final String ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_COUNTER = "VW_ISA_ASSOCIADOS_SOLUCOES_COUNTER";
    protected static final String ACTION_VW_ISA_ASSOCIADOS_SOLUCOES_LISTA = "VW_ISA_ASSOCIADOS_SOLUCOES_LISTA";

    protected String getIsaDocumentoPayload(String oidPessoa, String documento, String periodo) {
        return PayloadBuilder
                .builder()
                .xml(Payload.get("isaDocumento.xml"))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("oid_pessoa", oidPessoa))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("documento", documento))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("periodo", periodo))
                .build();
    }

    protected String getIsaContaPayload(String cooperativa, String conta, String periodo) {
        return PayloadBuilder
                .builder()
                .xml(Payload.get("isaConta.xml"))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("coop", cooperativa))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("conta", conta))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("periodo", periodo))
                .build();
    }
}
