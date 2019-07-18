/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafotad;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class GrafoN {
    
    //private final ArrayList<Aresta> arestas = new ArrayList<>();
    private final ArrayList<Vertice> vertices =  new ArrayList<>();
    
    public void addVertice(String id)     
    {
        if(!existeVertice(id))
            vertices.add(new Vertice(id));
    }
    
    public void addAresta(Vertice v, Vertice w, float valor, String id)
    {
        if (!existeAresta(id))
        {
            Aresta a = new Aresta(v, w, valor, id);
            Aresta b = new Aresta(w, v, valor, id);
            
            v.addAresta(a);
            w.addAresta(a);
            
            v.addAresta(b);
            w.addAresta(b);
            
        }
    }
    
    public boolean existeVertice(String id)
    {
        for(Vertice v:vertices)
        {
            if(v.getId().equals(id))
                return true;
        }
        return false;
    }
    
    public boolean existeAresta(String id)
    {
        for(Vertice v:vertices)
        {
            for(Aresta a:v.getArestas())
            {
                if(a.getId().equals(id))
                    return true;
            }
        }
        return false;
    }
    
    public void removerAresta(String id)
    {
        Vertice v = getVertice(id);
        for(Aresta a:v.getArestas())
        {
            if(a.getId().equals(id))
            {
                a.getVertice1().getArestas().remove(a);
                a.getVertice2().getArestas().remove(a);
            }
        }      
    }
    
    public void removeVertice(String id)
    {
        Vertice v = getVertice(id);
        for(Aresta a:v.getArestas())
        {
            a.getVertice1().getArestas().remove(a);
            a.getVertice2().getArestas().remove(a);
        }
        vertices.remove(v);  
    }
    
    public Vertice getVertice(String id)
    {
        for(Vertice v:vertices)
        {
            if(v.getId().equals(id))
            {
                return v;
            }
        }
        return null;        
    }
    
    public boolean adjacencia(String id1, String id2)
    {
        Vertice v1 = getVertice(id1);
        Vertice v2 = getVertice(id2);
        for (Aresta a: v1.getArestas())
        {
            for(Aresta b: v2.getArestas())
            {
                if(a.getId().equals(b.getId()))
                    return true;
            }
        }
        return false;
    }
    
    public float getValorAresta(String id)
    {
        for(Vertice v:vertices)
        {
            for(Aresta a:v.getArestas())
            {
                if(a.getId().equals(id))
                    return a.getValor();
            }
        } 
        return -1;
    }
    
    public String[] getExtremidadesAresta(String id)
    {
        String[] ids = new String[2];
        for(Vertice v:vertices)
        {
            for(Aresta a:v.getArestas())
            {
                if(a.getId().equals(id))
                    ids[0] = a.getVertice1().getId();
                    ids[1] = a.getVertice2().getId();
            }
        } 
        return null;        
    }
    
    public ArrayList<Vertice> getAdjacentes(String id)
    {
        ArrayList<Vertice> x =  new ArrayList<>();
        Vertice v = getVertice(id);
        
        for (Vertice v1: vertices)
        {
            if(adjacencia(v.getId(), v1.getId()))
                x.add(v1);
        }
        return x;
    }
    
    public Aresta getArestaEntreVertices(String id1, String id2)
    {
        Vertice v1 = getVertice(id1);
        Vertice v2 = getVertice(id2);
        for (Aresta a: v1.getArestas())
        {
            for(Aresta b: v2.getArestas())
            {
                if(a.getId().equals(b.getId()))
                    return a;
            }
        }
        return null;        
    }
    
    public ArrayList<Vertice> getVertices()
    {
        return vertices;
    }
    
    public void addVerticeByType(Vertice v)
    {
        if(!existeVertice(v.getId()))
            vertices.add(v);
    }
    
}
