package com.examen.full_Api_Pc.dto;
import com.examen.full_Api_Pc.enums.EstadoContribuyente;
import com.examen.full_Api_Pc.enums.CondicionDomicilio;
public record CompanyResponse(String ruc,
                              String razonSocial,
                              EstadoContribuyente estado,
                              CondicionDomicilio condicion,
                              String direccion,
                              String ubigeo,
                              String departamento,
                              String provincia,
                              String distrito,
                              Boolean esAgenteRetencion,
                              Boolean esBuenContribuyente) {
}
