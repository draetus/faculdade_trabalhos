package br.univali.kob.poo1.aula05;

import java.time.LocalDate;
import java.time.Period;

/**
 * Classe base para hierarqia de pessoas do sistema acadêmico.
 *
 * @author Mauricio
 */
public abstract class Person implements Contactable{

    /**
     * Construtor para ser reutilizado pelas subclasses de
     * Person. Utiliza formato string na data de nascimento para
     * facilitar chamada, Nome e data de nascimento são obrigatorios.
     *
     * @param name O nome da pessoa
     * @param dateOfBirth A data de nascimento da pessoa
     */
    public Person(String name, String dateOfBirth)
    {
        this(name, LocalDate.parse(dateOfBirth, AppConfig.DATE_FORMAT));
    }

    /**
     * Construtor Requer nome e data de nascimento
     * @param name Nome da Pessoa
     * @param dateOfBirth Data de nascimento da pessoa
     * @throws InternalError in case of invalid parameters
     */
    public Person(String name, LocalDate dateOfBirth){
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("The name cannot be null...");
        }
        if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new InternalError("The date must be before the present date...");
        }
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.id = nextid++;
    }

    /**
     * Atributo que auxilia na criação de IDs para as pessoas
     */
    private static int nextid = 1;

    /**
     * Nome da pessoa
     */
    private String name;

    /**
     * Data de nascimento da pessoa
     */
    private LocalDate dateOfBirth;

    /**
     * ID da pessoa
     */
    private int id;
    
    /**
     * Email da pessoa
     */
    private String email;
    
    
    /**
     * Getter
     *
     * @return O nome da pessoa
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter
     *
     * @param name Nome da pessoa
     */
    public void setName(String name) {
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("The name cannot be null...");
        }
        this.name = name;
    }

    /**
     * Getter
     *
     * @return Data de nascimento
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Setter
     *
     * @param dateOfBith Data de nascimento
     */
    public void setDateOfBirth(LocalDate dateOfBith) {
        if (dateOfBirth.isEqual(null) || dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new InternalError("The date must be before the present date...");
        }
        this.dateOfBirth = dateOfBith;
    }

    /**
     * Calcula e retorna a idade em anos.
     *
     * @return idade
     */
    public int getAge()
    {
        Period period = Period.between(dateOfBirth, LocalDate.now());
        return period.getYears();
    }

    /**
     * Getter
     * @return id da pessoa
     */
    public int getId()
    {
        return id;
    }

    /**
     * Getter
     * @return o proximo id a ser criado
     */
    public int getNextId()
    {
        return nextid;
    }
    
    /**
     * Monta uma String com todos os atributos e seus respectivos valores
     * O formato retornado é:
     * 
     * <pre>
     * {@code
     * Nome_da_Classe_Completa {
     *  Atributo = valor
     *  Atributo = valor
     *  ...
     * }}
     * </pre>
     * 
     * @return o estado (atributos e respectivos valores) do objeto
     */
    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getName() + "{ " + AppConfig.NEW_LINE);
        output.append("   //Person" + AppConfig.NEW_LINE);
        output.append("   id = " + id + AppConfig.NEW_LINE);
        output.append("   name = " + name + AppConfig.NEW_LINE);
        output.append("   dateOfBirth = " + dateOfBirth.format(AppConfig.DATE_FORMAT) + AppConfig.NEW_LINE);
        output.append(appendToString());
        return output.toString();
    }
    
    /**
     * Cada subclasse de Person deve montar a string que será 
     * adicionada a implementação herdada de toString(). Cada 
     * atributo com seu respectivo valor deve estar em uma linha
     * separada. ver formato esperado da operação.
     * 
     * @return um conjunto de linhas atributo + valor que será incluido 
     *         na implementação herdada de toString()
     * @see #toString() para detalhes sobre o formato das linhas
     */
    protected abstract String appendToString();
    
    /**
     * Define uma relação de equivalência entre o objeto atual e aquele passado
     * como parâmetro. Esta operação deve atender às seguintes regras:
     * 
     * 1) Reflexiva: a.equals(a) é sempre verdadeiro.
     * 2) Simétrica: se a.equals(b), então b.equals(a).
     * 3) Transitiva: se a.equals(b) e b.equals(c), então a.euqlas(c)
     * 4) Consistente: se os objetos não foram modificados, o valor retornado
     *    deve sempre ser o mesmo.
     * 5) a.equals(null) sempre retorna false.
     * 
     * Compara o estado (valor) do objeto atual com o objeto passado como
     * parâmetro. Caso o objeto passado seja null, a comparação falhará. Se o
     * objeto passado apontar para o mesmo endereço (a == n), a comparação
     * retornará sucesso. Se os objetos não pertencerem a mesma classe, a
     * comparação falhará.
     * 
     * @param obj o objeto a ser comparado
     * @return true quando os objetos têm o mesmo estado, false caso contrário
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Person person = (Person)obj;
        // considerado que dateOfBirth nunca poderá ser null (validações)
        // note que estamos na classe Person, logo temos acesso também aos
        // atributos do outro objeto
        return
                id == person.id &&
                (name == person.name || name.equals(person.name)) &&
                (dateOfBirth == person.dateOfBirth || dateOfBirth.equals(person.dateOfBirth));
    }
    
    /**
     * Calcula um valor inteiro a partir do valor dos atributos do objeto
     * (estado), por meio de um XOR entre seus valores. Esta função deve ser
     * consistente, ou seja, se o estado do objeto não for alterado, o valor
     * retornado deve sempre ser o mesmo. Também deve manter a regra que sempre
     * que a.equals(b), então a.hashCode() deve ser igual a b.hashCode().
     * 
     * @return o valor calculado a partir do estado atual do objeto
     */
    @Override
    public int hashCode()
    {
        return id ^ (name.hashCode()) ^ (dateOfBirth.hashCode());
    }

    /**
     * Setter
     * 
     * @param email Email da pessoa
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Getter
     * 
     * @return Email da pessoa
     */
    @Override
    public String getEmail() {
        return this.email;
    }
}
