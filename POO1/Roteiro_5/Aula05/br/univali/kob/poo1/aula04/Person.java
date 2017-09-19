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
     * Construtor para ser reutilizado pelas subclasses de
     * Person. Utiliza formato string na data de nascimento para
     * facilitar chamada, Nome e data de nascimento são obrigatorios.
     * 
     * @param name O nome da pessoa
     * @param dateOfBirth A data de nascimento da pessoa
     */
    public Person(String name, String dateOfBirth)
    {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT));
    }
    
    /**
     * Construtor Requer nome e data de nascimento
     * @param name Nome da Pessoa
     * @param dateOfBirth Data de nascimento da pessoa
     * @throws InternalError in case of invalid parameters
     */
    public Person(String name, LocalDate dateOfBirth){
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("The name cannot be null...");
        }
        if (dateOfBirth.isEqual(null) || dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new InternalError("The date must be before the present date...");
        }
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.id = nextid++;
    }

    /**
     * Atributo que auxilia na cfriação de IDs para as pessoas
     */
    private static int nextid = 1;
    
    /**
     * Nome da pessoa
     */
    private String name;

    /**
     * Data de nascimento da pessoa
     */
    private LocalDate dateOfBirth;
    
    /**
     * ID da pessoa
     */
    private int id;

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
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("The name cannot be null...");
        }
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
        if (dateOfBirth.isEqual(null) || dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new InternalError("The date must be before the present date...");
        }
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
    
    /**
     * Getter
     * @return id da pessoa
     */
    public int getId()
    {
        return id;
    }
    
    /**
     * Getter
     * @return o proximo id a ser criado
     */
    public int getNextId()
    {
        return nextid;
    }
}