package com.examen.full_Api_Pc.entity;

import com.examen.full_Api_Pc.enums.ResultadoConsulta;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 11)
    private String rucConsultado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResultadoConsulta resultado;

    private String mensajeError;
    private Integer providerStatusCode;

    @ManyToOne(optional = true)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRucConsultado() {
        return rucConsultado;
    }

    public void setRucConsultado(String rucConsultado) {
        this.rucConsultado = rucConsultado;
    }

    public ResultadoConsulta getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoConsulta resultado) {
        this.resultado = resultado;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public Integer getProviderStatusCode() {
        return providerStatusCode;
    }

    public void setProviderStatusCode(Integer providerStatusCode) {
        this.providerStatusCode = providerStatusCode;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
