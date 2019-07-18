/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafotad;

/**
 *
 * @author Gabriel
 */
public class Aresta {
    
    
    private final Vertice vertices[] =  new Vertice[2];    
    private final float valor;
    private final String id;
    
    public Aresta(Vertice v1, Vertice v2, float valor, String id)
    {
        this.id = id;
        this.valor =  valor;
        this.vertices[0] = v1;
        this.vertices[1] = v2;        
    }
    
    public float getValor()
    {
        return this.valor;
    }
    public Vertice getVertice1()
    {
        return vertices[0];
    }
    
    public Vertice getVertice2()
    {
        return vertices[1];
    }
    
    public Vertice[] getVertices()
    {
        return vertices;
    }   
    
    public String getId()
    {
        return id;
    }
    
}
