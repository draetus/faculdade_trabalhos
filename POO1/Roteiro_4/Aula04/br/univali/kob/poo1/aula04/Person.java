package br.univali.kob.poo1.aula04;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe base para hierarqia de pessoas do sistema acadêmico.
 * 
 * @author Mauricio
 */
public abstract class Person {

    /**
     * Construtor Requer nome e data de nascimento
     * @param name Nome da Pessoa
     * @param dateOfBirth Data de nascimento da pessoa
     */
    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Nome da pessoa
     */
    private String name;

    /**
     * Data de nascimento da pessoa
     */
    private LocalDate dateOfBirth;

    /**
     * Getter
     *
     * @return O nome da pessoa
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter
     *
     * @param name Nome da pessoa
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     *
     * @return Data de nascimento
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter
     *
     * @param dateOfBith Data de nascimento
     */
    public void setDateOfBirth(LocalDate dateOfBith) {
        this.dateOfBirth = dateOfBith;
    }
    
    /**
     * Calcula e retorna a idade em anos.
     * 
     * @return idade
     */
    public int getAge()
    {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        return period.getYears();
    }
}