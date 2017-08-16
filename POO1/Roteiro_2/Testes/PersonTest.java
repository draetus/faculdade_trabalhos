package br.univali.kob.poo1.aula02;

/*import java.time.LocalDate;
import java.time.format.DateTimeFormatter;*/

/**
 * Testes da classe Pessoa.
 * @author Marcello Thiry
 */
public class PersonTest {

/*
 Comentário não javadoc

 Mostra como criar um objeto a partir de uma classe e testar
 suas operações. Você percebeu que, para utilizar o objeto, não
 precisamos saber sobre os detalhes de como a classe foi implementada?

 Veja que o objeto criado é manipulado exclusivamente pelas suas
 operações públicas. O conjunto das operações públicas de uma classe é
 chamada de interface. Ou seja, um objeto só pode ser manipulado por
 operações que fazem parte da interface de sua classe.

 Note que os testes são privados, pois eles são chamados na única
 operação pública desta classe: run()

 Para chamar a classe de teste, basta fazer o seguinte:

 PersonTest test = new PersonTest();
 test.run()

 ou

 PersonTest test = new PersonTest().run();
    
 ou
    
 new PersonTest().run(); // pois não faremos nada com um objeto PersonTest depois

 Todos os testes serão executados na sequência.

 Você pode utilizar esta ideia quando estiver programando para
 acompanhar se as classes implementadas estão se comportando como
 esperado, sem precisar que o programa esteja completamente pronto.
*/

    /**
     * Caso de teste: instancia e popula um objeto pessoa.
     */
    /*-----------------------------------------------------
    private void createPerson() {
        System.out.println("test case: createPerson");
        Person john = new Person();
        // Tente retirar o comentário da linha abaixo e verificar o erro
        // que aparece. Você sabe dizer o motivo do erro?
        //john.name = "John";
        john.setName("John");
        john.setDateOfBirth(LocalDate.parse("1999-03-15")); //yyyy-MM-dd
        System.out.format("name: %s\ndate of birth: %s\n\n", john.getName(),
            john.getDateOfBirth());
    }
    -----------------------------------------------------*/

/*
 Comentário não javadoc

 Mostra como formatar uma data LocalDate utilizando a classe
 DateTimeFormatter

 Dicas sobre Date e Time no Java 8 podem ser encontradas em:

 http://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html
*/

    /**
     * Caso de teste: instancia e popula um objeto pessoa, mostrando
     * formatação de data.
     */
    /*-----------------------------------------------------
    private void useFormattedDate() {
        System.out.println("test case: useFormattedDate");
        Person john = new Person();
        john.setName("John");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        john.setDateOfBirth(LocalDate.parse("15/03/1999", format));
        System.out.format("name: %s\ndate of birth: %s\n", john.getName(), john.getDateOfBirth());
        System.out.format("formatted date of birth: %s\n\n", john.getDateOfBirth().format(format));
    }
    -----------------------------------------------------*/

/*
 Mostra o que acontece quando um objeto é copiado para outro de modo
 direto. Este tipo de cópia é chamada shallow (superficial) copy.

 Também mostra outra opção para montar longas cadeias de caracteres
 com a classe StringBuilder.

 Dicas sobre StringBuilder podem ser encontradas em:

 https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
*/
    /**
     * Caso de teste: copia objetos como referência (shallow copy).
     */
    /*-----------------------------------------------------
    private void doPersonShallowCopy() {
        System.out.println("test case: doPersonShallowCopy");
        Person john = new Person();
        john.setName("John");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        john.setDateOfBirth(LocalDate.parse("15/03/1999", format));
        Person mary = john;
        mary.setName("Mary");
        StringBuilder output = new StringBuilder();
        output.append("John's name: %s\n");
        output.append("John's date of birth: %s\n");
        output.append("Mary's name: %s\n");
        output.append("Mary's date of birth: %s\n");
        System.out.format(output.toString(),
            john.getName(),
            john.getDateOfBirth().format(format),
            mary.getName(),
            mary.getDateOfBirth().format(format));
        System.out.format("==> What have just happened here?!?\n\n");
    }
    -----------------------------------------------------*/

/*
 Comentário não javadoc

 Mostra como calcular a idade de uma pessoa utilizando sua
 data de nascimento e a data atual.

 Veja mais sobre período e duração em:

 https://docs.oracle.com/javase/tutorial/datetime/iso/period.html

 O que você acha de incorporar uma operação int getAge() na classe
 Pessoa? Faça isso agora e elabore um novo teste para verificar se
 sua implementação está funcionando.
*/
    /**
     * Caso de teste: calcula a idade de um objeto pessoa.
     */
    /*-----------------------------------------------------
    private void calculateAge() {
        System.out.println("test case: calculateAge");
        Person john = new Person();
        john.setName("John");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        john.setDateOfBirth(LocalDate.parse("15/03/1999", format));
        //Period period = Period.between(john.getDateOfBirth(), LocalDate.now());
        System.out.format("name: %s\ndate of birth: %s\nage: %d\n\n",
            john.getName(),
            john.getDateOfBirth().format(format),
            //period.getYears();
            john.getAge());
    }
    -----------------------------------------------------*/

    /**
     * Carga de teste: executa todos os casos de teste.
     */
    /*-----------------------------------------------------
    public void run() {
        System.out.printf("\n\n\n******* aula01: PersonTest ******** \n\n");
        createPerson();
        useFormattedDate();
        doPersonShallowCopy();
        calculateAge();
    }
    -----------------------------------------------------*/

}