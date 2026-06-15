package com.Loja.xBrain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class VendaModel {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dataVenda;
    private double valorVenda;
    private long idVendedor;
    private String nomeVendedor;

    public VendaModel() {
    }

    public VendaModel(Long id, LocalDate dataVenda, double valorVenda, long idVendedor, String nomeVendedor) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.idVendedor = idVendedor;
        this.nomeVendedor = nomeVendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }
}
