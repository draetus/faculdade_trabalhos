/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula04;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Mauricio
 */
public class Professor extends Employee{
    
    public enum AcademicDegree
    {
        BACHELOR("Bachelor", "0.00"),
        MASTER("Master", "0.15"),
        DOCTORATE("Doctorate (PhD)", "0.30");
        
        private String description;
        
        private String bonus;
        
        public String getDescription()
        {
            return description;
        }
        
        public String getBonus()
        {
            return bonus;
        }
        
        private AcademicDegree(String description, String bonus)
        {
            this.description = description;
            this.bonus = bonus;
        }
    }
    
    private AcademicDegree academicDegree;
    
    /*public static final int BACHELOR=0;
    
    public static final int MASTER=1;
    
    public static final int DOCTORATE=2;*/
    
    //public static final String[] DEGREE_DESCRIPTION = {"Bachelor","Master","Doctorate"};
    
    public Professor(AcademicDegree academicDegree, String name, LocalDate dateOfBirth, int id, LocalDate hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate) {
        super(name, dateOfBirth, id, hireDate, hoursPerWorkWeek, hourlyRate);
        this.setAcademicDegree(academicDegree);
    }
    
    public void setAcademicDegree(AcademicDegree academicDegree)
    {
        this.academicDegree = academicDegree;
    }
    
    public AcademicDegree getAcademicDegree()
    {
        return this.academicDegree;
    }
    
    public String getAcademicDegreeDescription()
    {
        return academicDegree.getDescription();
    }
    
    public BigDecimal getAcademicBonus()
    {
        BigDecimal bonus = super.getHourlyRate().multiply(new BigDecimal(academicDegree.getBonus()));
        return bonus.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    
    @Override
    public BigDecimal getHourlyRate()
    {
        return super.getHourlyRate().add(this.getAcademicBonus());
    }
}