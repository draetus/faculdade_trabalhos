package br.univali.kob.poo1.Payroll.Test;

import br.univali.kob.poo1.Payroll.Control.Company;
import br.univali.kob.poo1.Payroll.Model.Paycheck;
import br.univali.kob.poo1.Payroll.Model.RegularEmployee;
import br.univali.kob.poo1.Payroll.Model.Role;
import br.univali.kob.poo1.Payroll.Report.Report;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Mauricio
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        RegularEmployee employee = new RegularEmployee("Jeff", LocalDate.now(), LocalDate.now(), 160, new BigDecimal(25), Role.DIRECTOR);
        RegularEmployee employee2 = new RegularEmployee("Amenediel", LocalDate.now(), LocalDate.now(), 160, new BigDecimal(14), Role.REGULAR);
        RegularEmployee employee3 = new RegularEmployee("Kayle", LocalDate.now(), LocalDate.now(), 160, new BigDecimal(17), Role.REGULAR);
        RegularEmployee employee4 = new RegularEmployee("Sam", LocalDate.now(), LocalDate.now(), 160, new BigDecimal(15), Role.REGULAR);
        Paycheck test = new Paycheck(employee);
        Paycheck test2 = new Paycheck(employee2);
        Paycheck test3 = new Paycheck(employee3);
        Paycheck test4 = new Paycheck(employee4);
                
        Company company = new Company("P&G");
        company.addDepartament(employee, "Departamento Pessoal");
        company.getDepartament("Departamento Pessoal").addEmployee("Amenediel", LocalDate.now(), LocalDate.now(), 160, new BigDecimal(14), Role.REGULAR);
        company.getDepartament("Departamento Pessoal").addEmployee("Kayle", LocalDate.now(), LocalDate.now(), 160, new BigDecimal(17), Role.REGULAR);
        company.getDepartament("Departamento Pessoal").addEmployee("Sam", LocalDate.now(), LocalDate.now(), 160, new BigDecimal(15), Role.REGULAR);
        Paycheck test9 = new Paycheck(company.getDepartament("Departamento Pessoal").getEmployeeByName("Sam"));
        Paycheck test10 = new Paycheck(company.getDepartament("Departamento Pessoal").getEmployeeByName("Amenediel"));
        Paycheck test11 = new Paycheck(company.getDepartament("Departamento Pessoal").getEmployeeByName("Kayle"));
        //System.out.println(test.toString());
        
        Report.run(test9);
        
        
    }
    
}
