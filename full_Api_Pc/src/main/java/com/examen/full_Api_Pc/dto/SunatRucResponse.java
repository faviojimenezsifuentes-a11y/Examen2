package com.examen.full_Api_Pc.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public record SunatRucResponse(@JsonProperty("numero_documento") String numeroDocumento,
                               @JsonProperty("razon_social") String razonSocial,
                               String estado,
                               String condicion,
                               String direccion,
                               String ubigeo,
                               String departamento,
                               String provincia,
                               String distrito,
                               @JsonProperty("es_agente_retencion") Boolean esAgenteRetencion,
                               @JsonProperty("es_buen_contribuyente") Boolean esBuenContribuyente){
}
