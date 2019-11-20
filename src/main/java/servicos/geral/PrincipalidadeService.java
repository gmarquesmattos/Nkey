package servicos.geral;

import utils.servicos.ParametroXML;
import utils.servicos.Payload;
import utils.servicos.PayloadBuilder;

import static utils.CommonUtils.getProperty;

public class PrincipalidadeService {

    protected static final String URL_SERVICE = getProperty("service.principalidade");
    protected static final String ACTION_CONSULTAR_PRINCIPALIDADE = "consultarPrincipalidade";


    protected String consultarPrincipalidade(String coop, String documento, String numPeriodo) {
        return PayloadBuilder
                .builder()
                .xml(Payload.get(ACTION_CONSULTAR_PRINCIPALIDADE + ".xml"))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("codCooperativa", coop))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("numDocumento", documento))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("numPeriodo", numPeriodo))
                .build();
    }


}
