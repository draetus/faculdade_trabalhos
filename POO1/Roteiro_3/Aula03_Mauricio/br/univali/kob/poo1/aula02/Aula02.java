/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula02;

import java.math.BigDecimal;
import java.time.LocalDate;
import javafx.util.converter.LocalDateStringConverter;

/**
 * 
 * @author Mauricio
 */
public class Aula02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //PersonTest test = new PersonTest();
        //StudentInheritanceTest test = new StudentInheritanceTest();
        //EmployeeInheritanceTest test = new EmployeeInheritanceTest();
        //PersonListTest test = new PersonListTest();
        Employee[] test = new Employee[10];
        test[0] = new Professor(Professor.AcademicDegree.MASTER, "Jorge", LocalDate.parse("1970-05-08"), 1, LocalDate.parse("1980-06-09"), 40, new BigDecimal(30));
        test[1] = new Employee("Jorge", LocalDate.parse("1970-05-08"), 1, LocalDate.parse("1980-06-09"), 40, new BigDecimal(30));
        System.out.println(test[0].getWeekPayment(0));
        System.out.println(test[1].getWeekPayment(0));
        //test.run();
    }
    
}
