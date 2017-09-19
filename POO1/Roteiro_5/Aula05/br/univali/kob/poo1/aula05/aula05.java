package br.univali.kob.poo1.aula05;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Mauricio
 */
public class aula05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CallStackTest test = new CallStackTest();
        /*Employee test = new Employee("Jorge", LocalDate.MIN);
        test.setHoursPerWorkWeek(41);*/
        //StaticIDTest test = new StaticIDTest();
        //test.run();
        Employee el = new Employee("Orin Curry", "15/01/1976", "01/03/2000", 40, "22.80");
        System.out.println(el.getClass().getName() + "@" + Integer.toHexString(el.hashCode()));
        System.out.println("o estado de el é: " + el.toString());
    }
    
}
