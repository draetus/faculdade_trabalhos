package com.univali.competicaoatletas;

public class Atleta {

    private String name;
    private Double time;

    public Atleta(String name, Double time) {
        this.name = name;
        this.time = time;
    }

    public String getName(){
        return this.name;
    }

    public Double getTime(){
        return this.time;
    }
}
