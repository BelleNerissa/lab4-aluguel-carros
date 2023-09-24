package com.mycompany.carro;

import javax.persistence.*;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 255)
    private Integer id;

    @Column(name = "ano", length = 20, nullable = false)
    private String ano;

    @Column(name = "marca", length = 20, nullable = false)
    private String marca;

    @Column(name = "modelo", length = 30, nullable = false)
    private String modelo;

    @Column(name = "placa", length = 30, nullable = false, unique = true)
    private String placa;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", ano='" + ano +
                ", modelo='" + modelo +
                ", marca='" + marca +
                ", placa='" + placa
                ;
    }

    public Integer getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getAno() {
        return ano;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}