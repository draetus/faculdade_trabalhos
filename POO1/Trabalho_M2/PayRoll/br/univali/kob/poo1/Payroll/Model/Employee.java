package br.univali.kob.poo1.Payroll.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Mauricio e Gabriel
 * Represents an Employee of a Department
 */
public abstract class Employee {
    
    /**
     * Name of the employee
     */
    private String name;
    
    /**
     * Date of birth of the employee
     */
    private LocalDate dateOfBirth;
    
    /**
     * Hire date of the employee
     */
    private LocalDate hireDate;
    
    /**
     * Hours worked per month of the employee
     */
    int hoursWorked;
    
    /**
     * Value payed for the hour worked of the employee
     */
    BigDecimal hourlyRate;
    
    /**
     * Constructor
     * @param name Name of the employee
     * @param dateOfBirth Date of birth of the employee
     * @param hireDate Hire date of the employee
     * @param hoursWorked Hours worked per month of the employee
     * @param hourlyRate Value of the hour worked by the employee
     */
    public Employee(String name, LocalDate dateOfBirth, LocalDate hireDate, int hoursWorked, BigDecimal hourlyRate)
    {
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
        this.setHireDate(hireDate);
        this.setHoursPerWorkWeek(hoursWorked);
        this.setHourlyRate(hourlyRate);
    }
    
    /**
     * Setter
     * @param name Name of the employee
     * @throws IllegalArgumentException in case of the name is empty
     */
    public final void setName(String name)
    {
        if (name == null)
        {
            throw new IllegalArgumentException("Name is empty!");
        }
        this.name = name;
    }
    
    /**
     * Setter
     * @param dateOfBirth Date of birth of the employee
     * @throws IllegalArgumentException in case of the date of birth is null or
     *         it is a date after today's date
     */
    public final void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth == null || dateOfBirth.compareTo(LocalDate.now()) > 0)
        {
            throw new IllegalArgumentException("Invalid Date of birth ,it must be after today!!");
        }
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * Setter
     * @param hireDate Hire date of the employee
     * @throws IllegalArgumentException in case the date of birth is null
     */
    public final void setHireDate(LocalDate hireDate)
    {
        if (hireDate == null)
        {
            throw new IllegalArgumentException("Null Hire Date!");
        }
        this.hireDate = hireDate;
    }
    
    /**
     * Setter
     * @param hoursWorked Hours worked in the month by the employee
     * @throws IllegalArgumentException in case hours worked is negative
     */
    public final void setHoursPerWorkWeek(int hoursWorked)
    {
        if (hoursWorked < 0)
        {
            throw new IllegalArgumentException("Hours worked must be positive");
        }
        this.hoursWorked = hoursWorked;
    }
    
    /**
     * Setter
     * @param hourlyRate Value of the hour worked by the employee
     * @throws IllegalArgumentException in case the value is negative
     */
    public final void setHourlyRate(BigDecimal hourlyRate)
    {
        if (hourlyRate.compareTo(new BigDecimal(0)) == -1 || hourlyRate == null)
        {
            throw new IllegalArgumentException("Hours worked must be positive");
        }
        this.hourlyRate = hourlyRate;
    }
    
    /**
     * Getter
     * @return Name of the employee
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Getter
     * @return Date of the birth of the employee
     */
    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    /**
     * Getter
     * @return Hire date of the employee
     */
    public LocalDate getHireDate()
    {
        return this.hireDate;
    }
    
    /**
     * Getter
     * @return Hours worked in the month by the employee
     */
    public int getHoursWorked()
    {
        return this.hoursWorked;
    }
    
    /**
     * Getter
     * @return Value of the hour worked by the employee
     */
    public BigDecimal getHourlyRate()
    {
        return this.hourlyRate;
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
        string.append("Nome: " + this.name + "\n");
        string.append("Data de nascimento: " + this.dateOfBirth.toString() + "\n");
        string.append("Data de contratação: " + this.hireDate.toString() + "\n");
        string.append("Horas trabalhadas: " + this.hoursWorked + "\n");
        string.append("Valor da hora: " + this.hourlyRate.toString() + "\n");
        return string.toString();
    }
}
