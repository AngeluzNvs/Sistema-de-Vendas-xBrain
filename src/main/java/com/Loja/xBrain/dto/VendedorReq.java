package com.Loja.xBrain.dto;

public class VendedorReq {
    private String nome;

    public VendedorReq() {
    }

    public VendedorReq(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
