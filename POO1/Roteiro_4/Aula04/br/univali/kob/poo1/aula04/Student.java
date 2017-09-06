/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula04;

import java.time.LocalDate;

/**
 * Classe base para a hierarquia de estudantes no sistema acadêmico.
 * @author Mauricio
 */
public class Student extends Person {
    
    /**
     * 
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     */
    public Student(String name, LocalDate dateOfBirth)
    {
        super(name, dateOfBirth);
        this.setDropDate(null);
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param rollNumber Numero de matricula
     */
    public Student(String name, LocalDate dateOfBirth, int rollNumber)
    {
        this(name, dateOfBirth);
        this.setRollNumber(rollNumber);
    }
    
    /**
     * @param name Nome da pessoa
     * @param dateOfBirth Data de nascimento
     * @param rollNumber Numero de matricula
     * @param enrollmentDate Data de inicio
     */
    public Student(String name, LocalDate dateOfBirth, int rollNumber, LocalDate enrollmentDate)
    {
        this(name, dateOfBirth, rollNumber);
        this.setEnrollmentDate(enrollmentDate);
    }
    
    /**
     * Número de matrícula do estudante
     */
    private int rollNumber;
    
    /**
     * Data em que o estudante ingressou
     */
    private LocalDate enrollmentDate;
    
    /**
     * Data em que o estudante saiu
     */
    private LocalDate dropDate;
    
    /**
     * Informa se o aluno está ou não matriculado
     * @return True=Matriculado; False=Não matriculado
     */
    public boolean isEnrolled()
    {
        return this.dropDate == null;
    }
    
    /**
     * Setter
     * @param rollNumber Número de matricula do estudante
     */
    public void setRollNumber(int rollNumber)
    {
        this.rollNumber = rollNumber;
    }
    
    /**
     * Setter
     * @param enrollmentDate Data de entrada do estudante
     */
    public void setEnrollmentDate(LocalDate enrollmentDate)
    {
        this.enrollmentDate = enrollmentDate;
    }
    
    /**
     * Setter
     * @param dropDate Data de saida do estudante
     */
    public void setDropDate(LocalDate dropDate)
    {
        this.dropDate = dropDate;
    }
    
    /**
     * Getter
     * @return Numero de matricula do estudante
     */
    public int getRollNumber()
    {
        return this.rollNumber;
    }
    
    /**
     * Getter
     * @return Data de entrada do estudante 
     */
    public LocalDate getEnrollmentDate()
    {
        return this.enrollmentDate;
    }
    
    /**
     * Getter
     * @return Data de saida do estudante 
     */
    public LocalDate getDropDate()
    {
        return this.dropDate;
    }
}