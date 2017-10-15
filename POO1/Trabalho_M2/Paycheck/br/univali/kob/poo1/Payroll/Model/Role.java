package br.univali.kob.poo1.Payroll.Model;

/**
 * Role used by the Regular Employee
 * @author Mauricio e Gabriel
 */
public enum Role {
    
    /**
     * Values that can be accepted by the Role
     * REGULAR Represents the Regular Employee that has no relevant benefits
     * DIRECTOR Represents the Director that has a 5% bonus for every year worked
     * as a Director
     */
    REGULAR("Regular Employee", "0.0"),
    DIRECTOR("Director", "0.05");
    
    /**
     * Description of the Role
     */
    private final String description;
    
    /**
     * Bonus attributed to the role
     */
    private final String bonus;
    
    /**
     * Constructor
     * @param description Descrition of the Role
     * @param bonus Bonus atributed to the Role
     */
    private Role(String description, String bonus) 
    {
        this.description = description;
        this.bonus = bonus;
    }
    
    /**
     * Getter
     * @return Description of the Role
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * Getter
     * @return Bonus attributed to the role
     */
    public String getBonus()
    {
        return this.bonus;
    }
}
