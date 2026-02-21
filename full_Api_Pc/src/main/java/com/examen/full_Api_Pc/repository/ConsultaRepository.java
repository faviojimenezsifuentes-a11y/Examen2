package com.examen.full_Api_Pc.repository;

import com.examen.full_Api_Pc.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByRucConsultadoOrderByCreatedAtDesc(String rucConsultado);
}