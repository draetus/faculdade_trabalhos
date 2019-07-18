/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafotad;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Vertice {
    
    private final String id;
    private ArrayList<Aresta> arestas = new ArrayList<>();
    
    public Vertice(String id)
    {
        this.id = id;
    }
    
    public String getId()
    {
        return id;
    }
    
    public ArrayList<Aresta> getArestas()
    {
        return arestas;
    }
    
    public void addAresta(Aresta a)
    {
        arestas.add(a);
    }  
    
    
}
