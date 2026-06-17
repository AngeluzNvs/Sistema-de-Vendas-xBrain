package com.Loja.xBrain.dto;

import java.time.LocalDate;

public class VendaRes {
    private Long id;
    private double valorVenda;
    private LocalDate dataVenda;
    private String nomeVendedor;

    public VendaRes() {
    }

    public VendaRes(Long id, double valorVenda, LocalDate dataVenda, String nomeVendedor) {
        this.id = id;
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
        this.nomeVendedor = nomeVendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
}
