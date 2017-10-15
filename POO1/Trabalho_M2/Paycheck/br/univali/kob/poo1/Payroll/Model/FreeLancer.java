package br.univali.kob.poo1.Payroll.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * It is a Employee
 * FreeLancer with no bounds with the company
 * @author Mauricio
 */
public class FreeLancer extends Employee {
    
    /**
     * Salary of the Freelancer
     */
    private BigDecimal salary;
    
    /**
     * Constructor
     * @param name Name of the freelancer
     * @param dateOfBirth Date of birth of the freelancer
     * @param hireDate Hire date of the freelancer
     * @param hoursWorked Hours worked in the month by the freelancer
     * @param hourlyRate Value of the hours worked by the freelancer
     */
    public FreeLancer(String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursWorked, BigDecimal hourlyRate) 
    {
        super(name, dateOfBirth, hireDate, hoursWorked, hourlyRate);
        calculateSalary();
    }
    
    /**
     * Calculates the net salary of the freelancer
     * if the hours worked are above 160, the freelancer gain them with a 50% bonus value
     * if the hours worked are below 145(160's 90%) the freelancer no longer gain the base salary,
     * it only gains based on his hours
     * and if the hours are in between 145 and 160, he just gains the normal net salary
     * all the cases substracts the social insurance and the income tax from the total
     */
    private void calculateSalary()
    {
        BigDecimal extra = new BigDecimal(0);
        BigDecimal INSS;
        BigDecimal baseSalary = getHourlyRate().multiply(new BigDecimal(160));
        if (getHoursWorked() < 145)
        {
            salary = getHourlyRate().multiply(new BigDecimal(getHoursWorked()));
        }
        else
        {
            if (getHoursWorked() > 160)
            {
                extra = extra.add(new BigDecimal(getHoursWorked()-160));
                extra = extra.multiply(getHourlyRate().add(getHourlyRate().multiply(new BigDecimal(0.5))));
            }
            salary = baseSalary.add(extra);
        }
        
        INSS = salary.multiply(new BigDecimal(0.11));
        if (INSS.compareTo(new BigDecimal(482.93)) == 1)
        {
            INSS = new BigDecimal(482.93);
        }
        
        if (salary.compareTo(new BigDecimal(1499.15)) == 1)
        {
            if (salary.compareTo(new BigDecimal(2246.76)) == -1)
            {
                salary = salary.subtract(salary.multiply(new BigDecimal(0.075)));
            }
            else
            {
                if (salary.compareTo(new BigDecimal(2995.8)) == -1)
                {
                    salary = salary.subtract(salary.multiply(new BigDecimal(0.15)));
                }
                else
                {
                    if (salary.compareTo(new BigDecimal(3743.20)) == -1)
                    {
                        salary = salary.subtract(salary.multiply(new BigDecimal(0.225)));
                    }
                    else
                    {
                        salary = salary.subtract(salary.multiply(new BigDecimal(0.275)));
                    }
                }
            }
        }
        salary = salary.subtract(INSS);
    }
    
    /**
     * Getter
     * @return Salary of the freelancer
     */
    private BigDecimal getSalary()
    {
        return this.salary;
    }
    
    /**
     * Overrides the method toString()
     * translates the object data to a printable string
     * it appends the supperclass method, to print also the inherited data
     * @return printable data of the object
     */
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append("Salario: " + salary.setScale(2,BigDecimal.ROUND_HALF_EVEN).toString() + "\n");
        return string.toString();
    }
}
