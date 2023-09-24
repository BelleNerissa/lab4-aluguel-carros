package com.mycompany.agente;

import javax.persistence.*;

@Entity
@Table(name = "agentes")
public class Agente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 255)
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Agente{" +
                "id=" + id +
                ", tipo='" + tipo ;
    }
}
