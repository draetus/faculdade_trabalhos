package br.univali.kob.poo1.aula02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Testes de herança (Student é uma subclasse de Person).
 *
 * @author Marcello Thiry
 */
public class StudentInheritanceTest {
    
    /**
     * Caso de teste: instanciar, popular e mostrar um estudante (subclasse).
     */
    private void createSubclassStudent() {
        System.out.println("test case: createSubclassStudent");
        Student student = new Student();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // operações herdadas de Person
        student.setName("John");
        student.setDateOfBirth(LocalDate.parse("22/04/1997", format));
        // operações implementadas em Student
        student.setRollNumber(1);
        student.setEnrollmentDate(LocalDate.parse("27/02/2017", format));
        // Não inicializamos a data de saída. Ela permanecerá como null.
        StringBuilder output = new StringBuilder();
        output.append("[Student] name: %s; ");
        output.append("date of birth: %s; ");
        output.append("age: %d; ");
        output.append("roll number: %d; ");
        output.append("enrolled: %s; ");
        output.append("enrollment date: %s; ");
        output.append("drop date: %s;\n\n");
        // Na última linha, é utilizado um operador ternário (a < b) ? a : b
        // Se o retorno da expressão for true, retorna a, caso contrário b
        // Aqui, o teste garante que format será invocado apenas se houver um
        // objeto LocalDate instanciado. Caso contrário, retornaria uma
        // exceção (erro) java.lang.NullPointerException
        // Evitar encadeamento de operadores ternários, pois isso reduz
        // legibilidade do código.
        System.out.format(output.toString(), 
            student.getName(), 
            student.getDateOfBirth().format(format),
            student.getAge(),
            student.getRollNumber(), 
            student.isEnrolled(),
            student.getEnrollmentDate().format(format),
            (student.getDropDate() == null) ? null : student.getDropDate().format(format));
    }
    
    /**
     * Caso de teste: acessar atributos da superclasse.
     * <p>
     * Mostra que os atributos (tanto aqueles herdados quanto aqueles
     * definidos na classe Student) só podem ser acessados por meio de
     * operações de acesso. Deste modo, garantimos a proteção aos dados
     * via "information hiding" (ocultamento da informação).
     * </p>
     * Atributos devem ser SEMPRE privados. Para permitir que eles sejam
     * acessados, deve-se utilizar operações de acesso.
     */
    private void tryAccessToSuperAttributes() {
        System.out.println("test case: tryAccessToSuperAttributes");
        Student student = new Student();
        // Experimente tirar os comentários das próximas linhas e
        // verificar o que acontece. Leia o erro retornado.
        //student.name = "John";
        //student.rollNumber = 1;
        System.out.println("Se chegou aqui é porque você não tentou " + 
                "acessar atributos diretamente. Atributos devem ser " +
                "SEMPRE privados.");
    }

    /**
     * Carga de teste: executa todos os casos de teste.
     */
    public void run() {
        System.out.printf("\n\n\n******* aula02a: StudentInheritanceTest ******** \n\n");
        createSubclassStudent();
        tryAccessToSuperAttributes();
    }
}