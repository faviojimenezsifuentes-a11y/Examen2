package com.examen.full_Api_Pc.controller;

import com.examen.full_Api_Pc.service.SunatFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examen.full_Api_Pc.dto.CompanyResponse;
import com.examen.full_Api_Pc.dto.ConsultaResponse;
import java.util.List;

@RestController
@RequestMapping("/api/sunat")
public class SunatController {
    private final SunatFeignService service;

    public SunatController(SunatFeignService service) {
        this.service = service;
    }
    @GetMapping("/ruc/{ruc}")
    public CompanyResponse  consultar(@PathVariable String ruc){
        return service.consultarRuc(ruc);
    }
    @GetMapping("/ruc/{ruc}/consultas")
    public List<ConsultaResponse> historial(@PathVariable String ruc) {
        return service.obtenerHistorial(ruc);
    }
}

