package servicos.geral;


import utils.servicos.ParametroXML;
import utils.servicos.Payload;
import utils.servicos.PayloadBuilder;

import static utils.CommonUtils.getProperty;


public class GiroService {

    protected static final String URL_SERVICE = getProperty("service.giro");
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
