package matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade;

/**
 * Gerencia as caracteristicas de um Cliente.
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class Cliente {

    /**
     * Nome do cliente.
     */
    private final String nome;

    /**
     * Telefone do cliente.
     */
    private final String telefone;

    /**
     * CPF do cliente.
     */
    private final String cpf;

    /**
     * Endereco completo do cliente.
     */
    private final String endereco;

    /**
     * @param nome Nome do cliente
     * @param telefone Telefone do cliente
     * @param cpf CPF do cliente
     * @param endereco Endereco completo do cliente
     */
    public Cliente(String nome, String telefone, String cpf, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }
    
    /**
     * Getter
     * @return Nome do cliente
     */
    public String getNome()
    {
        return this.nome;
    }
    
    /**
     * Getter
     * @return Telefone do cliente
     */
    public String getTelefone()
    {
        return this.telefone;
    }
    
    /**
     * Getter
     * @return Cpf do cliente
     */
    public String getCpf()
    {
        return this.cpf;
    }
    
    /**
     * Getter
     * @return Endereco do cliente
     */
    public String getEndereco()
    {
        return this.endereco;
    }
}