package servicos.custom.requests;

import io.restassured.specification.RequestSpecification;

public class SoapRequestSpecificationBuilderImpl implements SoapRequestSpecificationBuilder {

    private final RequestSpecificationBuilder requestSpecificationBuilder;
    private final HeaderBuilder headerBuilder;

    public SoapRequestSpecificationBuilderImpl(RequestSpecificationBuilder requestSpecificationBuilder, HeaderBuilder headerBuilder) {
        this.requestSpecificationBuilder = requestSpecificationBuilder;
        this.headerBuilder = headerBuilder;
    }

    @Override
    public RequestSpecification build(String url, String action) {
        return requestSpecificationBuilder.build()
                .contentType("text/xml; charset=UTF-8;")
                .header(headerBuilder.build("SOAPAction", url + "/" + action))
                .header(headerBuilder.build("Connection", "Keep-Alive"))
                .baseUri(url);
    }
}
