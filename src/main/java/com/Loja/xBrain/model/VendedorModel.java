package com.Loja.xBrain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class VendedorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    // 1 pra muitos
    @OneToMany(mappedBy = "vendedor")
    private List<VendaModel> vendas;

    public VendedorModel() {
    }

    public VendedorModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
