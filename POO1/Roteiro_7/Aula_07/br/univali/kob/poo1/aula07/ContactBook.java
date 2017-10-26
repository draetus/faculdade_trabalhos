package br.univali.kob.poo1.aula07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Gerencia contatos.
 * <p>
 * Para gerar getters/setters, construtores, equals, hashCode, toString, etc. 
 * no NetBeans, utilize o botão direito sobre o arquivo e selecione a opção
 * Inserir Código ou clique Alt + INS.
 * 
 * @author Marcello Thiry
 */
public class ContactBook {
    /**
     * Lista de contatos.
     */
    private final List<Contactable> CONTACTS = new ArrayList<>();
    
    private static final Comparator<Contactable> NAME_ORDER = new Comparator<Contactable>()
            {
                @Override
                public int compare(Contactable c1, Contactable c2)
                        {
                            return c1.getName().compareTo(c2.getName());
                        }
            };
    
    private static final Comparator<Contactable> EMAIL_ORDER = new Comparator<Contactable>()
            {
                @Override
                public int compare(Contactable c1, Contactable c2)
                        {
                            return c1.getName().compareTo(c2.getName());
                        }
            };
    
    public static enum OrderBy{NAME, EMAIL};
    
    public static OrderBy orderBy;

    public void sort()
    {
        if (orderBy == OrderBy.NAME)
            {
                CONTACTS.sort(NAME_ORDER);
            }
        else
            {
                CONTACTS.sort(EMAIL_ORDER);
            }
    }
 
    /**
     * Adiciona um novo contato.
     * 
     * @param contact o contato a ser adicionado
     */
    public void add(Contactable contact) {
        // inserir validações aqui
        // nome e email devem ser válidos
        // não permitir emails repetidos
        CONTACTS.add(contact);
    }
    
    /**
     * Envia um email para um contato específico.
     * 
     * @param subject o assunto da mensagem
     * @param message a mensagem a ser enviada
     * @param contact o contato para o qual a mensagem deve ser enviada
     */
    public void email(String subject, String message, Contactable contact) {
        // inserir validações aqui
        // subject e message devem ser válidos
        // verificar se contato existe (pelo email que é único)
        System.out.println("sending [" + subject + ": \"" + message + "\"] to "
                + contact.getName() + " <" + contact.getEmail() + ">");
    }

    /**
     * Envia um email para toda a lista de contatos.
     * 
     * @param subject o assunto da mensagem
     * @param message a mensagem a ser enviada
     */
    public void email(String subject, String message) {
        // validações são feitas pelo método chamado
        for (Contactable contact: CONTACTS) {
            email(subject, message, contact);
        }
    }
    
    @Override
    public String toString() {
        // Adaptado da geração do NetBeans. Ele segue basicamente a mesma estrututra, mas sem quebra
        // de linhas
        // ArrayList já tem um toString que chama o toString de seus elementos
        // Elementos ficam entre []
        return "ContactBook {" + AppConfig.NEW_LINE + "  CONTACTS = " + CONTACTS + AppConfig.NEW_LINE + '}';
    }

    @Override
    public int hashCode() {
        // gerado pelo NetBeans
        // Ao invés de XOR, ele utiliza multiplicação por primos que são gerados
        // aleatoriamente
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.CONTACTS);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        // também gerado pelo NetBeans
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        // precisa acertar a partir daqui...
        final ContactBook contactBook = (ContactBook)obj;
        // ArrayList.equals já faz o dever de casa. Veja abaixo, o javadoc do ArrayList:
        // 
        // Returns true if and only if the specified object is also a list, both lists have the same 
        // size, and all corresponding pairs of elements in the two lists are equal. (Two elements 
        // e1 and e2 are equal if (e1==null ? e2==null : e1.equals(e2)).) In other words, two lists 
        // are defined to be equal if they contain the same elements in the same order. This definition 
        // ensures that the equals method works properly across different implementations of the List 
        // interface.
        //
        // Os elemenos devem estar na mesma ordem
        return CONTACTS.equals(contactBook.CONTACTS);
    }
    
}

/**
 * Classe exclusiva para teste de ContactBook. Para executá-lo, clique em qualquer área em 
 * branco deste arquivo e selecione [ Executar Arquivo ]. Este código pode ser excluído ou 
 * movido depois para um pacote de testes.
 * 
 * @author Marcello Thiry
 */
class ContactBookLocalTest {

    private static ContactBook contactBook = new ContactBook();

    public static void addContacts() {
        contactBook.add(new Employee("Orin Curry", "15/01/1976", "orin@com", "01/03/2000", 40, "22.80"));
        contactBook.add(new Student("Bruce Wayne", "02/05/1996", "wayne@com", "01/03/2017"));
        contactBook.add(new Professor("Stephen Vincent Strange", "23/06/1971", "strange@com", "05/08/1996", 40, "22.80", AcademicDegree.DOCTORATE));
        contactBook.add(new Student("Emma Grace Frost", "23/09/1994", "frost@com", "31/07/2016"));
        contactBook.add(new Employee("Susan Kent-Barr", "06/10/1969", "susan@com", "09/08/1995", 40, "25.23"));
        contactBook.add(new Company("ACME", "acme@com", "01/01/1960"));
        contactBook.add(new Company("Alibi Bar", "alibibar@com", "06/07/1971"));
    }
    
    public static void main(String[] args) {
        // simulando a inclusão de contatos...
        addContacts();
        // mostrando todos os contatos...
        contactBook.sort();
        System.out.println(contactBook.toString());
        // e testando emails
        contactBook.email("Happy New Year!", "Dear Friends, blah blah blah...");
    }
    
}

