package br.univali.kob.poo1.aula05;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Testes com listas, membros estáticos, polimorfismo e typecasting.
 *
 * @author Marcello Thiry
 */
public class StaticIDTest {

    /**
     * Lista de pessoas.
     */
    private final ArrayList<Person> PERSON_LIST = new ArrayList<>();
    /**
     * Constante com formato brasileiro de data.
     */
    private final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Caso de teste: monta uma lista de empregados e estudantes, utilizando 
     * polimorfismo para mostrar a idade de cada um.
     */
    private void showPersonListTest() {
        System.out.println("test case: showPersonListTest");
        PERSON_LIST.add(new Employee("Orin Curry", "15/01/1976", "01/03/2000", 40, "22.80"));
        PERSON_LIST.add(new Student("Bruce Wayne", "02/05/1996", "01/03/2017"));
        PERSON_LIST.add(new Professor("Stephen Vincent Strange", "23/06/1971", "05/08/1996", 40, "22.80", AcademicDegree.DOCTORATE));
        PERSON_LIST.add(new Student("Emma Grace Frost", "23/09/1994", "31/07/2016"));
        PERSON_LIST.add(new Employee("Susan Kent-Barr", "06/10/1969", "09/08/1995", 40, "25.23"));
        // apenas para mostrar o uso de instanceof e typecast
        if (PERSON_LIST.get(0) instanceof Employee) {
            ((Employee)PERSON_LIST.get(0)).setTerminationDate(LocalDate.parse("09/08/2001", DATE_FORMAT));
        }
        // permite percorrer a lista sem a necessidade de variáveis de controle
        for (Person person : PERSON_LIST) {
            System.out.printf(person.toString());
        }
        System.out.println();
    }

    /**
     *
     * Carga de teste: executa todos os casos de teste.
     */
    public final void run() {
        System.out.printf("\n\n\n******* aula05a: StaticIDTest ******** \n\n");
        showPersonListTest();
    }

}

// Classe apenas para teste. Você executar este arquivo, sem 
// ter que executar o projeto inteiro.
// 
// No NetBeans, com o botão direito em qualquer área deste
// arquivo, selecione a opção [ Executar Arquivo  Shift+F6 ].
//
class MainTest {

    public static void main(String[] args) {
        new StaticIDTest().run();
    }
    
}
