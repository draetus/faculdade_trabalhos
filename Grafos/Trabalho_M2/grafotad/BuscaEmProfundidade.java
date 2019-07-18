/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafotad;

import java.util.ArrayList;

/**
 *
 * @author 6309453
 */
public class BuscaEmProfundidade {
    private GrafoN g;
    public BuscaEmProfundidade(GrafoN g)
    {
        this.g = g;
    }
    
    public ArrayList<Vertice> busca(GrafoN g, Vertice i, ArrayList<Vertice> caminho)
    {
        int posicao = g.getVertices().indexOf(i);
        caminho.add(i);
        ArrayList<Aresta> arestas = i.getArestas();
        
        for(Aresta aresta : arestas)
        {
            Vertice v1 = aresta.getVertice1();
            Vertice v2 = aresta.getVertice2();
            
            if(!foiVisitado(v1, caminho))
            {
                busca(g, v1, caminho);
            }
            else
            {
                if(!foiVisitado(v2, caminho))
                {
                    busca(g, v2, caminho);
                }
            }
        }        
        return caminho;        
    }
    
    public ArrayList<Vertice> buscaAte(GrafoN g, Vertice i, Vertice f, ArrayList<Vertice> caminho)
    {
        int posicao = g.getVertices().indexOf(i);
        caminho.add(i);
        ArrayList<Aresta> arestas = i.getArestas();
        
        for(Aresta aresta : arestas)
        {
            Vertice v1 = aresta.getVertice1();
            Vertice v2 = aresta.getVertice2();
            
            if(v1.getId().equals(f.getId()))
            {
                caminho.add(v1);
                return caminho;
            }
            if(v2.getId().equals(f.getId()))
            {
                caminho.add(v2);
                return caminho;
            }
            
            if(!foiVisitado(v1, caminho))
            {
                buscaAte(g, v1, f, caminho);
            }
            else
            {
                if(!foiVisitado(v2, caminho))
                {
                    buscaAte(g, v2, f, caminho);
                }
            }
        }        
        return caminho;        
    }
    
    private boolean foiVisitado(Vertice v, ArrayList<Vertice> visitados)
    {
        return visitados.contains(v);
    }
    
    
    
    
    
//    public void printAcessados()
//    {
//        for(boolean b : acessados)
//        {
//            System.out.println(b);
//        }
//    }
    
}
