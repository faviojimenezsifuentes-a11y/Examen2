package com.examen.full_Api_Pc.config;

import com.examen.full_Api_Pc.exception.ProviderHttpException;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.nio.charset.StandardCharsets;

public class DecolectaErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        int status = response.status();
        String msg = "Error en proveedor";

        try {
            if (response.body() != null) {
                byte[] bytes = response.body().asInputStream().readAllBytes();
                String body = new String(bytes, StandardCharsets.UTF_8);
                String key = "\"message\"";
                int i = body.indexOf(key);
                if (i != -1) {
                    int colon = body.indexOf(':', i);
                    int firstQuote = body.indexOf('"', colon + 1);
                    int secondQuote = body.indexOf('"', firstQuote + 1);
                    if (firstQuote != -1 && secondQuote != -1) {
                        msg = body.substring(firstQuote + 1, secondQuote);
                    } else {
                        msg = body;
                    }
                } else {
                    msg = body;
                }
            }
        } catch (Exception ignored) {}

        return new ProviderHttpException(status, msg);
    }
}