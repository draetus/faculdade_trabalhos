package com.univali.listamunicipios;

import java.io.Serializable;

public class Cidade implements Serializable {

    private final String nome;
    private final Integer populacao;
    private final Double area;
    private final Double densidadePopulacional;

    public Cidade(String nome, Integer populacao, Double area, Double densidadePopulacional) {
        this.nome = nome;
        this.populacao = populacao;
        this.area = area;
        this.densidadePopulacional = densidadePopulacional;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public Double getArea() {
        return area;
    }

    public Double getDensidadePopulacional() {
        return densidadePopulacional;
    }

    public String toString() {
        return this.nome;
    }
}
