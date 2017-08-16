/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.kob.poo1.aula02;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Mauricio
 */
public class PersonListTest {
    
    private Person[] personlist = new Person[9];
    
    
    public Student createStudent(String name, String dateOfBirth, int rollNumber, String enrollmentDay)
    {
        System.out.println("Creating Student");
        Student student = new Student();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        student.setName(name);
        student.setDateOfBirth(LocalDate.parse(dateOfBirth, format));
        student.setRollNumber(rollNumber);
        student.setEnrollmentDate(LocalDate.parse(enrollmentDay, format));
        return student;
    }
    
    public Employee createEmployee(String name, String dateOfBirth, int id, String hireDate, int hoursPerWorkWeek, double hourlyRate)
    {
        Employee employee = new Employee();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        employee.setName(name);
        employee.setDateOfBirth(LocalDate.parse(dateOfBirth, format));
        employee.setId(id);
        employee.setHireDate(LocalDate.parse(hireDate, format));
        employee.setHoursPerWorkWeek(hoursPerWorkWeek);
        employee.setHourlyRate(new BigDecimal(hourlyRate));
        return employee;
    }
    
    public void run()
    {
        System.out.println("Test case: Creating student and employee");
        personlist[0] = createStudent("Jorge Bush", "06/07/1958", 1, "10/12/1990");
        personlist[1] = createStudent("Logan Paul", "06/09/1996", 2, "25/11/1995");
        personlist[2] = createEmployee("Glados", "07/01/1968", 3, "13/08/2015", 40, 15.5);
        personlist[3] = createEmployee("Linus Torvalds", "28/12/1969", 4, "28/12/1988", 70, 35.5);
        
        System.out.println("Listing People: ");
        for (int i=0;i<4;i++)
        {
            System.out.println("Name: " + personlist[i].getName());
            System.out.println("Date of Birth: " + personlist[i].getDateOfBirth());
            System.out.println("Age: " + personlist[i].getAge());
            System.out.println();
        }
        
    }
    
}
