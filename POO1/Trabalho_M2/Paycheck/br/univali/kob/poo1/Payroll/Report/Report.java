package br.univali.kob.poo1.Payroll.Report;

/**
 * Class made to print the report of possibly every class
 * @author Mauricio
 */
public abstract class Report {
    
    /**
     * Main report, prints the header, body and the footer
     * @param obj Object that will be printed
     */
    static public void run(Object obj)
    {
        printHeader(obj);
        printBody(obj);
        printFooter(obj);
    }
    
    /**
     * Prints the header of the Object
     * @param obj Object data that will be printed
     */
    static public void printHeader(Object obj)
    {
        System.out.println("\n----------------------------------");
        System.out.println(obj.getClass().getSimpleName());
        System.out.println("----------------------------------");
    }
    
    /**
     * Prints the body of the Object
     * @param obj Object data that will be printed
     */
    static public void printBody(Object obj)
    {
        System.out.print(obj.toString());
    }
    
    /**
     * Prints the footer of the Object
     * @param obj Object data that will be printed
     */
    static public void printFooter(Object obj)
    {
        System.out.println("----------------------------------");
    }
    
}
