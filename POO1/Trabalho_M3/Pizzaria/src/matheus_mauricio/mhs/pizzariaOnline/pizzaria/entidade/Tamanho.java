package matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade;

/**
 * Gerencia caracteristicas de tamanho de uma pizza
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class Tamanho {

    /**
     * Descrição do tamanho da pizza (pequeno, medio, grande)
     */
    private final String description;
    
    /**
     * Numero de fatias correspondente ao tamanho
     */
    private final int tamanho;
    
    /**
     * Construtor
     * @param description Descrição do tamanho da pizza (pequeno, medio, grande)
     * @param tamanho Numero de fatias correspondente ao tamanho
     */
    public Tamanho(String description, int tamanho) {
        this.description = description;
        this.tamanho = tamanho;
    }
    
    /**
     * Getter
     * @return Descrição do tamanho da pizza (pequeno, medio, grande)
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Getter
     * @return Numero de fatias correspondente ao tamanho
     */
    public int getTamanho()
    {
        return tamanho;
    }
    
    /**
     * Sobrecarga do método padrão de todo Object equals()
     * @param obj Objeto a ser comparado
     * @return Indicador se o objeto é equivalente ou não
     */
    @Override
    public boolean equals(Object obj)
    {
        Tamanho objeto = (Tamanho)obj;
        return this.description.equals(objeto.getDescription()) &&
                this.tamanho == objeto.tamanho;
    }
}
