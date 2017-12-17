package matheus_mauricio.mhs.pizzariaOnline.pizzaria.entidade;

import java.util.*;

/**
 * Gerencia as caracteristicas de uma Pizza.
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 */
public class Pizza {
    
    /**
     * @param nome
     * @param ingredientes
     */
    public Pizza(String nome, ArrayList<String> ingredientes) {
        this.nome = nome;
        this.ingredientes = ingredientes;
    }

    /**
     * Nome da pizza.
     */
    private final String nome;

    /**
     * Lista de ingredientes da pizza.
     */
    private final ArrayList<String> ingredientes;

    /**
     * @return
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Getter
     * @return Coleção de ingredientes
     */
    public ArrayList<String> getIngredients()
    {
        return ingredientes;
    }
}