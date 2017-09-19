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
    
    /**
     * Enum representando os graus de formação do professor
     * atribuindo os modificadores de salario junto
     */
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
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato string na data de nascimento
     * e na data de inicio de contrato
     * e formato float na taxa de hora para
     * facilitar chamada
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(AcademicDegree academicDegree, String name, String dateOfBirth, String hireDate, int hoursPerWorkWeek, float hourlyRate) {
        this(academicDegree, name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), hoursPerWorkWeek, new BigDecimal(hourlyRate));
    }
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato float no valor da hora para
     * facilitar chamada
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(AcademicDegree academicDegree, String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursPerWorkWeek, float hourlyRate) {
        this(academicDegree, name, dateOfBirth, hireDate, hoursPerWorkWeek, new BigDecimal(hourlyRate));
    }
    
    /**
     * Construtor para ser reutilizado
     * Utiliza formato string na data de nascimento
     * e na data de inicio de contrato
     * facilitar chamada
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(AcademicDegree academicDegree, String name, String dateOfBirth, String hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate) {
        this(academicDegree, name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT), LocalDate.parse(hireDate, AppConfig.DATE_FORMAT), hoursPerWorkWeek, hourlyRate);
    }
    
    /**
     * Construtor
     * @param academicDegree Grau de formação academica do professor
     * @param name Nome do professor
     * @param dateOfBirth Data de nascimento do professor
     * @param hireDate Data de inicio de contratamento do professor
     * @param hoursPerWorkWeek Horas por semana do professor
     * @param hourlyRate Valor da hora do professor
     */
    public Professor(AcademicDegree academicDegree, String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursPerWorkWeek, BigDecimal hourlyRate) {
        super(name, dateOfBirth, hireDate, hoursPerWorkWeek, hourlyRate);
        this.setAcademicDegree(academicDegree);
    }
    
    /**
     * Setter
     * @param academicDegree Grau de formação academica do professor
     */
    public void setAcademicDegree(AcademicDegree academicDegree)
    {
        this.academicDegree = academicDegree;
    }
    
    /**
     * Getter
     * @return Grau de formação academica professor
     */
    public AcademicDegree getAcademicDegree()
    {
        return this.academicDegree;
    }
    
    /**
     * Getter
     * @return Descrição do grau de formação academica do professor 
     */
    public String getAcademicDegreeDescription()
    {
        return academicDegree.getDescription();
    }
    
    /**
     * Getter
     * @return Bonus de salario baseado no grau de formação academica do professor
     */
    public BigDecimal getAcademicBonus()
    {
        BigDecimal bonus = super.getHourlyRate().multiply(new BigDecimal(academicDegree.getBonus()));
        return bonus.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
    
    /**
     * Getter
     * @return Valor da hora do professor
     */
    @Override
    public BigDecimal getHourlyRate()
    {
        return super.getHourlyRate().add(this.getAcademicBonus());
    }
}