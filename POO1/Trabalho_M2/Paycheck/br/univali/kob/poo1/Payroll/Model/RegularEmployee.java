package br.univali.kob.poo1.Payroll.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents the Regular Employee, the one that have bounds with the company
 * and have the paychecks
 * @author Mauricio e Gabriel
 */
public class RegularEmployee extends Employee {
    
    /**
     * Role of the Regular Employee
     * It can be just an Regular Employee with no relevant benefits,
     * or it can be a director, the one that is the leader of the department
     * the director has a 5% addition to his salary for every year he has 
     * worked on as a director
     */
    private final Role role;
    
    /**
     * The history of paychecks of the Regular Employee
     */
    private final ArrayList<Paycheck> paychecks = new ArrayList<>();
    
    /**
     * Constructor
     * @param name Name of the Regular Employee
     * @param dateOfBirth Date of birth of the Regular Employee
     * @param hireDate Hire date of the Regular Employee
     * @param hoursWorked Hours worked per month by the Regular employee
     * @param hourlyRate Value of the hours worked per month by the Regular Employee
     * @param role Role of the employee in the department
     */
    public RegularEmployee(String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursWorked, BigDecimal hourlyRate, Role role)
    {
        super(name, dateOfBirth, hireDate, hoursWorked, hourlyRate);
        this.role = role;
    }
    
    /**
     * Getter
     * @return The role of the employee in the department
     */
    public Role getRole()
    {
        return this.role;
    }
    
    /**
     * Adds a paycheck to his history
     * @param paycheck Paychecks that will be added to the Array List
     */
    public void addPaycheck(Paycheck paycheck)
    {
        this.paychecks.add(paycheck);
    }
    
    /**
     * Getter
     * @return Return all the history of paychecks in an Array List
     */
    public ArrayList<Paycheck> getPaychecks()
    {
        return this.paychecks;
    }
    
    /**
     * Getter
     * @return The years the Regular Employee has worked on this company
     */
    public int getYearsWorked()
    {
        return LocalDate.now().getYear() - this.getHireDate().getYear();
    }
    
    /**
     * Overrides the method toString()
     * translates the object data to a printable string
     * @return printable data of the object
     */
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append("Cargo: " + role.getDescription() + "\n");
        string.append("Quantidade de contracheques: " + paychecks.size() + "\n");
        return string.toString();
    }
}
