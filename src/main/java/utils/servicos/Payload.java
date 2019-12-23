package utils.servicos;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Payload {

    private static final Map<String, String> payloads = new ConcurrentHashMap<>();

    private Payload() {

    }

    public static String get(final String name) {
        try {
            String content = payloads.get(name);

            if (content == null || content.isEmpty()) {
                InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(Contants.PAYLOADS + "/" + name);
                content = IOUtils.toString(inputStream, StandardCharsets.ISO_8859_1.toString());

                payloads.put(name, content);
            }

            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
