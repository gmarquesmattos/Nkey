package servicos.geral;

import utils.ParametroXML;
import utils.Payload;
import utils.PayloadBuilder;

import static utils.CommonUtils.getProperty;

public class GiroService {

    protected static final String URL_SERVICE = getProperty("service.giro");
    protected static final Long TIME_LIMIT = 5000L;
    protected static final String ACTION_CONSULTAR_ULTIMO_CONTATO = "consultarUltimoContato";

    protected String getConsultarUltimoContatoPayload(String coop, String documento) {
        return PayloadBuilder
                .builder()
                .xml(Payload.get(ACTION_CONSULTAR_ULTIMO_CONTATO + ".xml"))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("codCooperativa", coop))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("numDocumento", documento))
                .build();
    }
}
