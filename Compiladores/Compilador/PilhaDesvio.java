

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class PilhaDesvio {
    
    private ArrayList<Integer> pilha = new ArrayList<>();
    
    public void add(int elemento)
    {
        pilha.add(elemento);
    }
    
    public int get()
    {
        int termo = pilha.get(pilha.size() - 1);
        pilha.remove(pilha.size() - 1);
        return termo;
    }
    
}
