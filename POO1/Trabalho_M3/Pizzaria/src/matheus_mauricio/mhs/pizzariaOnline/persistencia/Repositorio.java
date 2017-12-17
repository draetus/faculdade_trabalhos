package matheus_mauricio.mhs.pizzariaOnline.persistencia;

import java.util.*;

/**
 * Repositorio que armazena elementos.
 * 
 * @author Matheus Henrique Schaly e Mauricio Macario de Farias Junior
 * @param <T> Tipo que o repositorio suporta
 */
public class Repositorio<T> {

    public ArrayList<T> elementos = new ArrayList<>();
    
    /**
     * Default constructor
     */
    public Repositorio() {}
    
    /**
     * 
     * @param elemento Elemento que vai ser salvo
     */
    public void salva(T elemento)
    {
        elementos.add(elemento);
    }

    /**
     * 
     * @return 
     */
    public ArrayList getAll() 
    {
        return elementos;
    }
    
    /**
     * 
     * @param posicao
     * @return 
     */
    public T get(int posicao)
    {
        return elementos.get(posicao);
    }
}