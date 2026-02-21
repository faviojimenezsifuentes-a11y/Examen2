package com.examen.full_Api_Pc.service;

import com.examen.full_Api_Pc.client.DecoletaSunatFeignClient;
import com.examen.full_Api_Pc.dto.CompanyResponse;
import com.examen.full_Api_Pc.dto.SunatRucResponse;
import com.examen.full_Api_Pc.entity.Company;
import com.examen.full_Api_Pc.entity.Consulta;
import com.examen.full_Api_Pc.enums.ResultadoConsulta;
import com.examen.full_Api_Pc.mapper.SunatMapper;
import com.examen.full_Api_Pc.repository.CompanyRepository;
import com.examen.full_Api_Pc.repository.ConsultaRepository;
import org.springframework.stereotype.Service;
import com.examen.full_Api_Pc.exception.RucInvalidoException;
import com.examen.full_Api_Pc.exception.ProviderHttpException;
import com.examen.full_Api_Pc.dto.ConsultaResponse;
import java.util.List;

@Service
public class SunatFeignService {

    private final DecoletaSunatFeignClient client;
    private final SunatMapper mapper;
    private final CompanyRepository companyRepository;
    private final ConsultaRepository consultaRepository;

    public SunatFeignService(
            DecoletaSunatFeignClient client,
            SunatMapper mapper,
            CompanyRepository companyRepository,
            ConsultaRepository consultaRepository
    ) {
        this.client = client;
        this.mapper = mapper;
        this.companyRepository = companyRepository;
        this.consultaRepository = consultaRepository;
    }

    public CompanyResponse consultarRuc(String ruc) {
        if (ruc == null || !ruc.matches("\\d{11}")) {

            Consulta c = new Consulta();
            c.setRucConsultado(ruc);
            c.setResultado(ResultadoConsulta.ERROR);
            c.setMensajeError("RUC debe tener exactamente 11 dígitos");
            c.setProviderStatusCode(400);
            consultaRepository.save(c);

            throw new RucInvalidoException("RUC debe tener exactamente 11 dígitos");
        }

        try {

            SunatRucResponse raw = client.Ruc(ruc);
            Company company = companyRepository.findByRuc(ruc)
                    .orElseGet(Company::new);

            mapper.copyToExisting(company, raw);
            Company saved = companyRepository.save(company);
            Consulta consulta = new Consulta();
            consulta.setRucConsultado(ruc);
            consulta.setResultado(ResultadoConsulta.SUCCESS);
            consulta.setCompany(saved);
            consultaRepository.save(consulta);

            return mapper.toCompanyResponse(raw);

        } catch (ProviderHttpException  ex) {

            Consulta c = new Consulta();
            c.setRucConsultado(ruc);
            c.setResultado(ResultadoConsulta.ERROR);
            c.setMensajeError(ex.getProviderMessage());
            c.setProviderStatusCode(ex.getStatusCode());
            consultaRepository.save(c);

            throw ex;
        }
    }
    public List<ConsultaResponse> obtenerHistorial(String ruc) {
        return consultaRepository
                .findByRucConsultadoOrderByCreatedAtDesc(ruc)
                .stream()
                .map(c -> mapper.toConsultaResponse(c))
                .toList();
    }
}