package servicos.geral;


import utils.servicos.ParametroXML;
import utils.servicos.Payload;
import utils.servicos.PayloadBuilder;

import static utils.CommonUtils.getProperty;

public class RestritivoService {
    protected static final String URL_SERVICE = getProperty("service.situacao.cadastral");
    protected static final Long TIME_LIMIT = 5000L;
    protected static final String ACTION_CONSULTAR_SITUACAO_CADASTRAL = "consultarSituacaoCadastral";

    protected String getConsultarSituacaoCadastralPJPayload(String cnpj, String agenciaArea, String cooperativa, String autorizaOnline, String usuarioLogado, String sistemaOrigem) {
        return PayloadBuilder
            .builder()
            .xml(Payload.get(ACTION_CONSULTAR_SITUACAO_CADASTRAL + "PJ.xml"))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("cnpj", cnpj))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("agenciaArea", agenciaArea))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("cooperativa", cooperativa))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("autorizaOnline", autorizaOnline))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("usuarioLogado", usuarioLogado))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("sistemaOrigem", sistemaOrigem))
            .build();
    }

    protected String getConsultarSituacaoCadastralPFPayload(String cpf, String agenciaArea, String cooperativa, String autorizaOnline, String usuarioLogado, String sistemaOrigem) {
        return PayloadBuilder
            .builder()
            .xml(Payload.get(ACTION_CONSULTAR_SITUACAO_CADASTRAL + "PF.xml"))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("cpf", cpf))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("agenciaArea", agenciaArea))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("cooperativa", cooperativa))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("autorizaOnline", autorizaOnline))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("usuarioLogado", usuarioLogado))
            .parametros(ParametroXML.ParametroBuilder.stringParametro("sistemaOrigem", sistemaOrigem))
            .build();
    }
}
