package br.univali.kob.poo1.Payroll.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents the paycheck of the Regular Employee
 * Contains data about his salary and hiring information
 * @author Mauricio e Gabriel
 */
public final class Paycheck {
    
    /**
     * Name of the Regular Employee
     */
    private final String name;
    
    /**
     * Hire date of the Regular Employee
     */
    private final LocalDate hireDate;
    
    /**
     * Base salary of the Regular Employee
     */
    private final BigDecimal baseSalary;
    
    /**
     * Net salary of the Regular Employee
     */
    private final BigDecimal netSalary;
    
    /**
     * Hours worked per month of the Regular Employee
     */
    private final int hoursWorked;
    
    /**
     * Value of the hours worked by the Regular Employee
     */
    private final BigDecimal hourlyRate;
    
    /**
     * Construtor
     * @param employee Employee that owns the paycheck
     */
    public Paycheck(RegularEmployee employee)
    {
        this.name = employee.getName();
        this.hireDate = employee.getHireDate();
        this.hoursWorked = employee.getHoursWorked();
        this.hourlyRate = employee.getHourlyRate();
        this.baseSalary = hourlyRate.multiply(new BigDecimal(160));
        this.netSalary = calculateNetSalary(employee);
    }
    
    /**
     * Calculates the net Salary of the Regular Employee
     * if the hours worked are above 160, the Regular Employee gain them with a 50% bonus value
     * if the hours worked are below 145(160's 90%) the Regular Employee no longer gain the base salary,
     * it only gains based on his hours
     * and if the hours are in between 145 and 160, he just gains the normal net salary
     * At the end of this calculation it calculates the bonus of the Role,
     * In case of the Regular Employee being a Director he gains a 5% addition for every year the he is
     * acting as a Director
     * at the end all the cases substracts the social insurance and the income tax from the total
     * @param employee
     * @return 
     */
    private BigDecimal calculateNetSalary(RegularEmployee employee)
    {
        BigDecimal salary;
        BigDecimal extra = new BigDecimal(0);
        BigDecimal INSS;
        if (hoursWorked < 145)
        {
            salary = hourlyRate.multiply(new BigDecimal(hoursWorked));
        }
        else
        {
            if (hoursWorked > 160)
            {
                extra = extra.add(new BigDecimal(hoursWorked-160));
                extra = extra.multiply(hourlyRate.add(hourlyRate.multiply(new BigDecimal(0.5))));
            }
            salary = this.baseSalary.add(extra);
        }
        extra = new BigDecimal(employee.getYearsWorked());
        extra = extra.multiply(new BigDecimal(employee.getRole().getBonus()));
        salary = salary.add(extra);
        
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
        return salary;
    }
    
    /**
     * Getter
     * @return Base salary of the Regular Employee
     */
    public BigDecimal getBaseSalary()
    {
        return this.baseSalary;
    }
    
    /**
     * Getter
     * @return net salary of the Regular Employee
     */
    public BigDecimal getNetSalary()
    {
        return this.netSalary;
    }
    
    /**
     * Getter
     * @return Name of the Regular Employee
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Getter
     * @return Hire date of the Regular Employee
     */
    public LocalDate getHireDate()
    {
        return this.hireDate;
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
        string.append("Data de contratação: " + hireDate.toString() + "\n");
        string.append("Horas trabalhadas: " + hoursWorked + "\n");
        string.append("Valor da hora: " + hourlyRate.toString() + "\n");
        string.append("Salario Base: " + baseSalary.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString() + "\n");
        string.append("Salario Liquido: " + netSalary.setScale(2, BigDecimal.ROUND_HALF_EVEN).toString() + "\n");
        return string.toString();
    }
}
