package servicos.custom.requests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class EmptyRequestSpecificationBuilderImpl implements EmptyRequestSpecificationBuilder {
    @Override
    public RequestSpecification build() {
        return RestAssured.given();
    }
}
