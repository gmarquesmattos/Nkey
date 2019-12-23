package servicos.custom.requests;

import io.restassured.http.Header;

public interface HeaderBuilder {
    Header build(String header, String value);
}
