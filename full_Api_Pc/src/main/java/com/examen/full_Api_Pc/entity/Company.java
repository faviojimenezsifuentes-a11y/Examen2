package com.examen.full_Api_Pc.entity;
import com.examen.full_Api_Pc.enums.CondicionDomicilio;
import com.examen.full_Api_Pc.enums.EstadoContribuyente;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name ="company",uniqueConstraints = {
        @UniqueConstraint(name = "uk_company_ruc", columnNames = "ruc")
})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 11)
    private String ruc;
    @Column(nullable = false)
    private String razonSocial;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoContribuyente estado;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CondicionDomicilio condicion;

    private String direccion;
    private String ubigeo;
    private String departamento;
    private String provincia;
    private String distrito;

    private Boolean esAgenteRetencion;
    private Boolean esBuenContribuyente;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public EstadoContribuyente getEstado() {
        return estado;
    }

    public void setEstado(EstadoContribuyente estado) {
        this.estado = estado;
    }

    public CondicionDomicilio getCondicion() {
        return condicion;
    }

    public void setCondicion(CondicionDomicilio condicion) {
        this.condicion = condicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Boolean getEsAgenteRetencion() {
        return esAgenteRetencion;
    }

    public void setEsAgenteRetencion(Boolean esAgenteRetencion) {
        this.esAgenteRetencion = esAgenteRetencion;
    }

    public Boolean getEsBuenContribuyente() {
        return esBuenContribuyente;
    }

    public void setEsBuenContribuyente(Boolean esBuenContribuyente) {
        this.esBuenContribuyente = esBuenContribuyente;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
