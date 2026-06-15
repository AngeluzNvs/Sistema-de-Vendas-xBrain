package com.Loja.xBrain.dto;

public class Relatorio {
    private String nome;
    private double valorTotal;
    private double mediaVendasDiarias;

    public Relatorio() {
    }

    public Relatorio(String nome, double valorTotal, double mediaVendasDiarias) {
        this.nome = nome;
        this.valorTotal = valorTotal;
        this.mediaVendasDiarias = mediaVendasDiarias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getMediaVendasDiarias() {
        return mediaVendasDiarias;
    }

    public void setMediaVendasDiarias(double mediaVendasDiarias) {
        this.mediaVendasDiarias = mediaVendasDiarias;
    }
}
