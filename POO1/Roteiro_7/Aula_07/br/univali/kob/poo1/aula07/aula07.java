package br.univali.kob.poo1.aula07;

/**
 *
 * @author Mauricio
 */
public class aula07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CallStackTest test = new CallStackTest();
        /*Employee test = new Employee("Jorge", LocalDate.MIN);
        test.setHoursPerWorkWeek(41);*/
        //StaticIDTest test = new StaticIDTest();
        //test.run();
        /*Employee el = new Employee("Orin Curry", "15/01/1976", "01/03/2000", 40, "22.80");
        System.out.println(el.getClass().getName() + "@" + Integer.toHexString(el.hashCode()));
        System.out.println("o estado de el é: " + el.toString());*/
        
        /*DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate myDate = LocalDate.parse("01/01/2017", dateFormat);
        LocalDate minDate = LocalDate.parse("01/01/2014", dateFormat);
        LocalDate maxDate = LocalDate.parse("01/01/2018", dateFormat);
        new ComparableValidator<LocalDate>().range(myDate , "My Date", minDate, maxDate);
        
        BigDecimal myNumber = new BigDecimal("100.45");
        BigDecimal minNumber = new BigDecimal("100.43");
        BigDecimal maxNumber = new BigDecimal("100.47");
        new ComparableValidator<BigDecimal>().range(myNumber, "My Date", minNumber, maxNumber);
        
        Integer myInt = 10;
        Integer minInt = 1;
        Integer maxInt = 10;
        new ComparableValidator<Integer>().range(myInt, "My Integer", myInt, maxInt);
        
        String myStr = "DDDD";
        String minStr = "CCCC";
        String maxStr = "EEEE";
        new ComparableValidator<String>().range(myStr, "My Integer", minStr, maxStr);
        
        System.out.println("Validacoes feitas com sucesso. Todo mundo passou!");*/
        
        /*State s1 = new State("Santa Catarina", "SC");
        System.out.println(s1.toString());
        
        State s2 = new State("Santa Catarina", "SC");
        System.out.println(s2.toString());
        
        System.out.println("TRUE ==> " + s1.equals(s2));
        System.out.println("TRUE ==> " + s2.equals(s1));
        System.out.println("FALSE ==> " + (s1 == s2));
        
        //exceção aqui...
        //State s3 = new State("Santa Catarina", "");
        
        //exceção aqui...
        //State s4 = new State("", "SC");*/
        
        /*State s1 = new State("Santa Catarina", "SC");
        City c1 = new City("Florianopolis", s1);
        System.out.println(c1.toString());*/
        
        State s1 = new State("Santa Catarina", "SC");
        City c1 = new City("Florianopolis", s1);
        Address a1= new Address("Rua Floriano, 2012", null, c1, "88015200");
        System.out.println(a1.toString());
    }
    
}