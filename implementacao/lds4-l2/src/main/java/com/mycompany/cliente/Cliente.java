package com.mycompany.cliente;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 255)
    private Integer id;

    @Column(name = "rg", length = 20, nullable = false, unique = true)
    private String rg;

    @Column(name = "cpf", length = 20, nullable = false, unique = true)
    private String cpf;

    @Column(name = "profissao", length = 65, nullable = false)
    private String profissao;

    @Column(name = "rendimento", length = 50, nullable = false)
    private String rendimento;

    @Column(name = "endereco", length = 255, nullable = false)
    private String endereco;

    public Integer getId() {
        return id;
    }
    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getRendimento() {
        return rendimento;
    }

    public String getRg() {
        return rg;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", rg='" + rg +
                ", cpf='" + cpf +
                ", profissao='" + profissao +
                ", rendimento='" + rendimento +
                ", endereco='" + endereco
                ;
    }
}