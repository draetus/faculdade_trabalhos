/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula06;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Mauricio
 */
public class Company implements Contactable{
    
    /**
     * Nome da compania
     */
    private String name;
    
    /**
     * Email da compania
     */
    private String email;
    
    /**
     * Date de começo da compania
     */
    private LocalDate dateOfEstabilishment;
    
    /**
     * Constructor para Data em LocalDate
     * @param name Nome da compania
     * @param email Email da compania
     * @param dateOfEstabilishment Date de inicio da compania
     */
    public Company(String name, String email, LocalDate dateOfEstabilishment)
    {
        this.setName(name);
        this.setEmail(email);
        this.setDateOfEstabilishment(dateOfEstabilishment);
    }
    
    /**
     * Constructor para Data em String
     * @param name Nome da compania
     * @param email Email da compania
     * @param dateOfEstabilishment Date de inicio da compania
     */
    public Company(String name, String email, String dateOfEstabilishment)
    {
        this(name, email, LocalDate.parse(dateOfEstabilishment, AppConfig.DATE_FORMAT));
    }
    
    /**
     * Setter
     * @param name Nome da compania
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Getter
     * @return Nome da compania
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Setter
     * @param email Email da compania
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Getter
     * @return Email da compania
     */
    @Override
    public String getEmail() {
        return this.email;
    }
    
    /**
     * Setter
     * @param dateOfEstabilishment Data de inicio da compania
     */
    public void setDateOfEstabilishment(LocalDate dateOfEstabilishment)
    {
        this.dateOfEstabilishment = dateOfEstabilishment;
    }
    
    /**
     * Getter
     * @return Data de inicio da compania 
     */
    public LocalDate getDateOfEstabilishment()
    {
        return this.dateOfEstabilishment;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }
        
        Company company = (Company)obj;
        return (this.name.equals(company.name)) &&
               (this.email.equals(company.email)) &&
               (this.dateOfEstabilishment.equals(dateOfEstabilishment)); 
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^ email.hashCode() ^ dateOfEstabilishment.hashCode();
    }
    
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder("Company: " + AppConfig.NEW_LINE);
        string.append("Name: " + this.name + AppConfig.NEW_LINE);
        string.append("Email: " + this.email+ AppConfig.NEW_LINE);
        string.append("Date Of Estabilishment: " + this.dateOfEstabilishment + AppConfig.NEW_LINE);
        return string.toString();
    }
}
