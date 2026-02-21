package com.examen.full_Api_Pc.dto;

import com.examen.full_Api_Pc.enums.ResultadoConsulta;
import java.time.LocalDateTime;

public record ConsultaResponse(
        String rucConsultado,
        ResultadoConsulta resultado,
        String mensajeError,
        Integer providerStatusCode,
        LocalDateTime createdAt
) {}
