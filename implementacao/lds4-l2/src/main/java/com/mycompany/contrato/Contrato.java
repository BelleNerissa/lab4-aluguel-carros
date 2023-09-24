package com.mycompany.contrato;

import javax.persistence.*;

@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 255)
    private Integer id;

    @Column(name = "agente", length = 20, nullable = false)
    private String agente;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", agente='" + agente
                ;
    }
}