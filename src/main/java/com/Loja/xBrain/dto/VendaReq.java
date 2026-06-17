package com.Loja.xBrain.dto;

import java.time.LocalDate;

public class VendaReq {
    private double valorVenda;
    private LocalDate dataVenda;
    private Long idVendedor;
    public VendaReq() {
    }
    public VendaReq(double valorVenda, LocalDate dataVenda, Long idVendedor) {
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
        this.idVendedor = idVendedor;
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

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }
}
