package br.univali.kob.poo1.Payroll.Control;

import br.univali.kob.poo1.Payroll.Model.RegularEmployee;
import java.util.*;

/**
 * Represents the Company with many departments
 * the departments have many Regular Employees
 * The company can also have Freelances trailers to it
 * but the Freelances don't have paychecks and they info are kept
 * within themselves
 */
public class Company {
    
    /**
     * The whole bunch of departments, with many Regular Employees within it
     */
    private final ArrayList<Departament> departaments = new ArrayList<>();
    
    /**
     * The name of the company
     */
    private String name;
    
    /**
     * Constructor
     * @param name Name of the company
     */
    public Company(String name) {
        this.name = name;        
    }

    /**
     * Adds an department to the arraylist of departments
     * @param director Director of the department, you can't create a 
     * department without someone to manage it
     * @param name Name of the Department
     */
    public void addDepartament(RegularEmployee director, String name){
        departaments.add(new Departament(director, name));
    }
    
    /**
     * Checks if the Department exists by looking up its name
     * @param name Name of the Department
     * @return true if the Department exists
     *         false if the Departments doesn't exists
     */
    public boolean existDepartament(String name){
        for (int i=0; i<departaments.size(); i++){
            if (departaments.get(i).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Gets the department by looking it up by the name provided
     * returns null if nothing is found
     * @param name Name of the Department
     * @return The Department found by the name
     */
    public Departament getDepartament(String name){
        if(existDepartament(name)){
            for (int i=0; i<departaments.size(); i++){
                if (departaments.get(i).getName().equals(name)){
                    return departaments.get(i);
                }
            }
        }
        return null;
    }
    
    /**
     * Getter
     * @return the whole Arraylist of the Departments
     */
    public ArrayList<Departament> getDepartaments(){
        return this.departaments;
    }
    
    /**
     * Setter
     * @param name Name of the company
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Getter
     * @return The name of the company
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Removes a department by lookint it up by its name
     * @param name Name of the Department
     */
    public void removeDepartament(String name){
        departaments.remove(getDepartament(name));
    }
}