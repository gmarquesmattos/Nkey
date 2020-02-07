package servicos.custom.requests;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class CustomRestAssured {

    private static final RequestLoggingFilter requestLoggingFilter = new RequestLoggingFilter();
    private static final ResponseLoggingFilter responseLoggingFilter = new ResponseLoggingFilter();
    private static final EmptyRequestSpecificationBuilder emptyRequestSpecificationBuilder = new EmptyRequestSpecificationBuilderImpl();
    private static final HeaderBuilder headerBuilder = new HeaderBuilderImpl();

    private static final RequestSpecificationBuilder requestSpecificationBuilder = new RequestSpecificationBuilderImpl(emptyRequestSpecificationBuilder,requestLoggingFilter, responseLoggingFilter);
    private static final SoapRequestSpecificationBuilder soapRequestSpecificationBuilder = new SoapRequestSpecificationBuilderImpl(requestSpecificationBuilder, headerBuilder);

    public static RequestSpecification givenSoap(String url, String action) {
        return soapRequestSpecificationBuilder.build(url, action);
    }
}
