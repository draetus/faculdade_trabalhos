package com.univali.dadoscovid.entities;

public class Municipio {

    private String name;
    private String popEstimate;
    private Long pib;
    private Long ibge;
    private String date;
    private Boolean lastDate;
    private Long confirmed;
    private Long death;
    private String deathByHundredThousand;

    public Municipio(String name, String popEstimate, Long pib, Long ibge, String date, Boolean lastDate, Long confirmed, Long death, String deathByHundredThousand, Double deathRate) {
        this.name = name;
        this.popEstimate = popEstimate;
        this.pib = pib;
        this.ibge = ibge;
        this.date = date;
        this.lastDate = lastDate;
        this.confirmed = confirmed;
        this.death = death;
        this.deathByHundredThousand = deathByHundredThousand;
        this.deathRate = deathRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopEstimate() {
        return popEstimate;
    }

    public void setPopEstimate(String popEstimate) {
        this.popEstimate = popEstimate;
    }

    public Long getPib() {
        return pib;
    }

    public void setPib(Long pib) {
        this.pib = pib;
    }

    public Long getIbge() {
        return ibge;
    }

    public void setIbge(Long ibge) {
        this.ibge = ibge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getLastDate() {
        return lastDate;
    }

    public void setLastDate(Boolean lastDate) {
        this.lastDate = lastDate;
    }

    public Long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Long confirmed) {
        this.confirmed = confirmed;
    }

    public Long getDeath() {
        return death;
    }

    public void setDeath(Long death) {
        this.death = death;
    }

    public String getDeathByHundredThousand() {
        return deathByHundredThousand;
    }

    public void setDeathByHundredThousand(String deathByHundredThousand) {
        this.deathByHundredThousand = deathByHundredThousand;
    }

    public Double getDeathRate() {
        return deathRate;
    }

    public void setDeathRate(Double deathRate) {
        this.deathRate = deathRate;
    }

    private Double deathRate;
}
