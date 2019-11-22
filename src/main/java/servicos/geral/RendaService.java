package servicos.geral;

import utils.servicos.ParametroXML;
import utils.servicos.Payload;
import utils.servicos.PayloadBuilder;

import static utils.CommonUtils.getProperty;

public class RendaService {

    protected static final String URL_SERVICE = getProperty("service.renda");
    protected static final String ACTION_CONSULTAR_RENDA = "consultarRendaDadosBasicosAssociado";

    protected String consultarRenda(String oidPessoa) {
        return PayloadBuilder
                .builder()
                .xml(Payload.get(ACTION_CONSULTAR_RENDA + ".xml"))
                .parametros(ParametroXML.ParametroBuilder.stringParametro("oidPessoa", oidPessoa))
                .build();
    }

}
