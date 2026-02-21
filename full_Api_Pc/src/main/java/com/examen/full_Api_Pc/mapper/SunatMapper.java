package com.examen.full_Api_Pc.mapper;

import com.examen.full_Api_Pc.dto.CompanyResponse;
import com.examen.full_Api_Pc.dto.SunatRucResponse;
import com.examen.full_Api_Pc.dto.ConsultaResponse;
import com.examen.full_Api_Pc.entity.Company;
import com.examen.full_Api_Pc.enums.CondicionDomicilio;
import com.examen.full_Api_Pc.enums.EstadoContribuyente;
import org.springframework.stereotype.Component;
import com.examen.full_Api_Pc.entity.Consulta;


@Component
public class SunatMapper {

    public CompanyResponse toCompanyResponse(SunatRucResponse r) {
        return new CompanyResponse(
                r.numeroDocumento(),
                r.razonSocial(),
                EstadoContribuyente.fromProvider(r.estado()),
                CondicionDomicilio.fromProvider(r.condicion()),
                r.direccion(),
                r.ubigeo(),
                r.departamento(),
                r.provincia(),
                r.distrito(),
                r.esAgenteRetencion(),
                r.esBuenContribuyente()
        );
    }
    public void copyToExisting(Company target, SunatRucResponse r) {
        target.setRuc(r.numeroDocumento());
        target.setRazonSocial(r.razonSocial());
        target.setEstado(EstadoContribuyente.fromProvider(r.estado()));
        target.setCondicion(CondicionDomicilio.fromProvider(r.condicion()));
        target.setDireccion(r.direccion());
        target.setUbigeo(r.ubigeo());
        target.setDepartamento(r.departamento());
        target.setProvincia(r.provincia());
        target.setDistrito(r.distrito());
        target.setEsAgenteRetencion(r.esAgenteRetencion());
        target.setEsBuenContribuyente(r.esBuenContribuyente());
    }
    public ConsultaResponse toConsultaResponse(Consulta c) {
        return new ConsultaResponse(
                c.getRucConsultado(),
                c.getResultado(),
                c.getMensajeError(),
                c.getProviderStatusCode(),
                c.getCreatedAt()
        );
    }

}