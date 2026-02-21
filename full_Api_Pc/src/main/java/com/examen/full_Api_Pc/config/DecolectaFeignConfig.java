package com.examen.full_Api_Pc.config;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class DecolectaFeignConfig {

    @Bean
    public RequestInterceptor authInterceptor(@Value("${decolecta.token}") String token){
        return request -> request.header("Authorization", "Bearer " + token);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new DecolectaErrorDecoder();
    }
}
