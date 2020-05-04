package br.univali.mobile.entities;

import java.io.Serializable;

public class Filme implements Serializable {
    private String nome;
    private String[] horarios;
    private String elenco;


    public Filme(String titulo, String[] horarios,String elenco){
        this.nome=titulo;
        this.horarios=horarios;
        this.elenco=elenco;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getHorarios() {
        return horarios;
    }

    public void setHorarios(String[] horarios) {
        this.horarios = horarios;
    }

    public String toString(){
        return this.nome;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }
}
