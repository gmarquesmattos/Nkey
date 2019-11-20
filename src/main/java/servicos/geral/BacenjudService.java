package servicos.geral;


import utils.servicos.ParametroXML;
import utils.servicos.Payload;
import utils.servicos.PayloadBuilder;

import static utils.CommonUtils.getProperty;

public class BacenjudService {
    protected static final String URL_SERVICE = getProperty("service.bacenjud");
    protected static final Long TIME_LIMIT = 5000L;
    protected static final String ACTION_CONSULTAR_Bacenjud = "consultaBacenjud";


    protected String consultarBacenjud(String documento) {
        return PayloadBuilder
                .builder()
                .xml(Payload.get(ACTION_CONSULTAR_Bacenjud + ".xml"))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("numDocumento", documento))

                .build();
    }
}