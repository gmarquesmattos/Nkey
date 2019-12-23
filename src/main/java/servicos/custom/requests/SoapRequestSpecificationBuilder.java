package servicos.custom.requests;

import io.restassured.specification.RequestSpecification;

public interface SoapRequestSpecificationBuilder {
    RequestSpecification build(String url, String action);
}
