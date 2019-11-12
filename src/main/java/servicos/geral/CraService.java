package servicos.geral;

import utils.servicos.ParametroXML;
import utils.servicos.Payload;
import utils.servicos.PayloadBuilder;

import static utils.CommonUtils.getProperty;

public class CraService {
    protected static final String URL_SERVICE = getProperty("service.cra");
    protected static final Long TIME_LIMIT = 5000L;
    protected static final String ACTION_CONSULTAR_CRA = "consultarCRA";

    protected String getConsultarCraPayload(String coop, String documento) {
        return PayloadBuilder
                .builder()
                .xml(Payload.get(ACTION_CONSULTAR_CRA + ".xml"))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("codCooperativa", coop))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("numDocumento", documento))
                .build();
    }
}
