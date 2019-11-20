package servicos.custom.requests;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationBuilderImpl implements RequestSpecificationBuilder {

    private final EmptyRequestSpecificationBuilder emptyRequestSpecificationBuilder;
    private final RequestLoggingFilter requestLoggingFilter;
    private final ResponseLoggingFilter responseLoggingFilter;

    public RequestSpecificationBuilderImpl(EmptyRequestSpecificationBuilder emptyRequestSpecificationBuilder,
                                           RequestLoggingFilter requestLoggingFilter,
                                           ResponseLoggingFilter responseLoggingFilter) {
        this.emptyRequestSpecificationBuilder = emptyRequestSpecificationBuilder;
        this.requestLoggingFilter = requestLoggingFilter;
        this.responseLoggingFilter = responseLoggingFilter;
    }

    @Override
    public RequestSpecification build() {
        return emptyRequestSpecificationBuilder.build()
                .filter(requestLoggingFilter)
                .filter(responseLoggingFilter);
    }
}
