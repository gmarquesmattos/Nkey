package servicos.custom.requests;

import io.restassured.http.Header;

public class HeaderBuilderImpl implements HeaderBuilder {
    @Override
    public Header build(String header, String value) {
        return new Header(header, value);
    }
}
