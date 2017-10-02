package br.univali.kob.poo1.aula06;

/**
 *
 * @author Mauricio
 */
public class CallStackTest {
    
    private void method1()
    {
        System.out.println("entrei em method1()");
        System.out.println("method1() --> method2(): empilha o endereço " + 
                " de method1 e vai para o endereço de method2");
        try
        {
            method2();
        } catch (java.lang.ArithmeticException ex)
        {
            System.out.println("********* capturei a exceção em method1");
            System.out.println("********* mensagem default da exceção: "
            + ex.getMessage());
        }
        System.out.println("voltei para method1()");
    }
    
    private void method2()
    {
        System.out.println("entrei em method2()");
        System.out.println("method2() --> method3(): empilha o endereço " + 
                "de method2 e vai para o enredeço de method3");
        method3();
        System.out.println("voltei para method2()");
        System.out.println("desempilha o endereço de method1 e vai para " + 
                "este endereço");
    }
    
    private void method3()
    {
        System.out.println("entrei em method3()");
        try 
        {
            int divisao = 100 / 0;
            System.out.println(divisao);
        } catch (java.lang.RuntimeException ex)
        {
            System.out.println("*********** mensagem default da exceção: "
            + ex.getClass() + ": " + ex.getMessage());
        } finally 
        {
            System.out.println("######## a parte finally é sempre executada");
        }
        System.out.println("desempilha o endereço de method2 e vai para " +
                "este endereço");
    }
    
    public void run()
    {
        System.out.printf("\n\n\n******* CallStackTest ******* \n\n");
        method1();
    }
}
