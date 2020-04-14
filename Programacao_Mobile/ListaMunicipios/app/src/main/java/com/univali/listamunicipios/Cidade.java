package com.univali.listamunicipios;

public class Cidade {

    private String nome;
    private Long populacao;
    private Double area;
    private Double densidadePopulacional;

    public Cidade(String nome, Long populacao, Double area, Double densidadePopulacional) {
        this.nome = nome;
        this.populacao = populacao;
        this.area = area;
        this.densidadePopulacional = densidadePopulacional;
    }

    public String getNome() {
        return nome;
    }

    public Long getPopulacao() {
        return populacao;
    }

    public Double getArea() {
        return area;
    }

    public Double getDensidadePopulacional() {
        return densidadePopulacional;
    }
}
