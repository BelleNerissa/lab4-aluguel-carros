package com.mycompany.alugueis;

import javax.persistence.*;

@Entity
@Table(name = "alugueis")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 255)
    private Integer id;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "idCarro", length = 20, nullable = false)
    private Integer idCarro;

    @Column(name = "idCliente", length = 30, nullable = false)
    private Integer idCliente;

    @Column(name = "idContrato", length = 30, nullable = false)
    private Integer idContrato;

    public Integer getId() {
        return id;
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}