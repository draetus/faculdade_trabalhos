package br.univali.kob.poo1.Payroll.Control;

import br.univali.kob.poo1.Payroll.Model.RegularEmployee;
import br.univali.kob.poo1.Payroll.Model.Role;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Represents the Department who employs many Regular Employees
 */
public class Departament {

    /**
     * The Regular Employees
     */
    private final ArrayList<RegularEmployee> employees = new ArrayList<>();
    
    /**
     * The director of the Department, it only has one
     */
    private final RegularEmployee diretor;
    
    /**
     * The name that the Department uses for the identification
     */
    private final String name;
    
    /**
     * Constructor
     * @param diretor The ruler of the Department
     * @param name The name that the Department uses for the identification
     */
    public Departament(RegularEmployee diretor, String name) {
        this.diretor = diretor;
        this.name = name;
    }
    
    /**
     * Add one Regular Employee to the bunch of the Regular Employee
     * @param name Name of the Regular Employee
     * @param dateOfBirth Date of birth of the Regular Employee
     * @param hireDate Hire date of the Regular Employee
     * @param hoursWorked Hours worked per month of the Regular Employee
     * @param hourlyRate Value of the hours worked by the Regular Employee
     * @param role Role of the Regular Employee
     */
    public void addEmployee(String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursWorked, BigDecimal hourlyRate){
        employees.add(new RegularEmployee(name, dateOfBirth, hireDate, hoursWorked, hourlyRate, Role.REGULAR));
    }
    
    /**
     * Getter
     * @param index The index of the Regular Employee desired
     * @return The Regular Employee corresponding to the index provided
     */
    public RegularEmployee getEmployee(int index){
        return employees.get(index);
    }
    
    /**
     * Checks if the Regular Employee exists by the name of it
     * @param name Name of the Regular Employee
     * @return true if the Regular Employee exists
     *         false if the Regular Employee don't exists
     */
    private boolean existEmployee(String name){
        for (int i=0; i<employees.size(); i++){
            if (employees.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Get the Regular Employee corresponding to the provided name
     * @param name Name of the Regular Employee
     * @return The Regular Employee found first
     */
    public RegularEmployee getEmployeeByName(String name){
        if (existEmployee(name)){
            for (int i=0; i<employees.size(); i++){
                if (employees.get(i).getName().equals(name)){
                    return employees.get(i);
                }
            }    
        }
        return null;
    }
    
    /**
     * Getter
     * @return The whole bunch of Regular Employee, excluding the director
     */
    public ArrayList<RegularEmployee> getEmployees(){
        return this.employees;
    }
    
    /**
     * Getter
     * @return The director of the department
     */
    public RegularEmployee getDiretor(){
        return this.diretor;
    }
    
    /**
     * Removes the Regular Employee by its name
     * @param name Name of the Regular Employee
     */
    public void removeEmployee(String name){
        employees.remove(getEmployeeByName(name));
    }
    
    /**
     * Getter
     * @return The name of the department
     */
    public String getName(){
        return this.name;
    }
}