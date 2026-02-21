package com.examen.full_Api_Pc.client;

import com.examen.full_Api_Pc.dto.SunatRucResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "decolectaSunatClient",
            url = "${decolecta.base-url}",
            configuration = com.examen.full_Api_Pc.config.DecolectaFeignConfig.class)
public interface DecoletaSunatFeignClient {
    @GetMapping("v1/sunat/ruc")
    SunatRucResponse Ruc(@RequestParam("numero") String numero);
}

