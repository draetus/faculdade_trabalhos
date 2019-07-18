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
public class GrafoD {
    
    //private final ArrayList<Aresta> arestas = new ArrayList<>();
    private final ArrayList<Vertice> vertices =  new ArrayList<>();
    
    public ArrayList<Integer> cores = new ArrayList<>();
    ArrayList<Vertice> vert = new ArrayList<>();
    
    public ArrayList<Vertice> verticesDijkstra = new ArrayList<>();
    public ArrayList<Float> estimativaDijkstra = new ArrayList<>();
    public ArrayList<Vertice> precedentesDijkstra = new ArrayList<>();
    
    
    
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
            v.addAresta(a);
            w.addAresta(a);
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
                Vertice[] verticesA = a.getVertices();
                Vertice[] verticesB = b.getVertices();
                System.out.println("id1: "+v1.getId()+ " vertices: " + verticesA[0].getId() + " / " +verticesA[1].getId());
                System.out.println("id2: "+v2.getId()+ " vertices: " + verticesB[0].getId() + " / " +verticesB[1].getId());
                if( verticesA[0].getId().equals(v1.getId()) && verticesA[1].getId().equals(v2.getId()) )
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
            if (v1 == v) 
            {
                continue;
            }
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
    
    public ArrayList<Aresta> getArestas()
    {
        ArrayList<Aresta> arestas = new ArrayList<>();
        for (Vertice v: vertices)
        {
            for (Aresta a: v.getArestas())
            {
                if (!arestas.contains(a))
                {
                    arestas.add(a);
                }
            }
        }
        return arestas;
        
    }
    
    private boolean checa_ciclo()
    {
        for (Vertice z: vertices)
        {
            for (Vertice x: vertices)
            {
                for (Vertice y: vertices)
                {
                    if (this.adjacencia(z.getId(), x.getId()) &&
                        this.adjacencia(z.getId(), y.getId()) &&
                        this.adjacencia(y.getId(), x.getId()))
                    {return true;}
                }
            }
        }
        return false;
    }
    
    public boolean checaPlanaridade() 
    {
        int qtde_vertices = vertices.size();
        int qtde_arestas = this.getArestas().size();
        
        if (qtde_vertices < 3)
            return true;
        
        if (this.checa_ciclo())
            return (qtde_arestas <= 3*qtde_vertices - 6);
        else
            return (qtde_arestas <= 2*qtde_vertices - 4);
    }
    
    public void welshPowel()
    {       
        int cor = 1;
        Vertice inicial = vertices.get(0);
        
        for(Vertice v : vertices)
        {
            if(inicial.getArestas().size() < v.getArestas().size())
            {
                inicial = v;
            }
        }
        vert.add(inicial);
        cores.add(cor);       
        
        
        while (cores.size() < vertices.size()) 
        {       
            cor = 1;
            inicial = getMaiorSaturacao();
            ArrayList<Vertice> adjacentes = getAdjacentes(inicial.getId());
            for (int i = 0; i < adjacentes.size(); i++) 
            {
                System.out.println(i);
                System.out.println(vert.contains(adjacentes.get(i)));
                //System.out.println(cores.get(vert.indexOf(adjacentes.get(i))));
                
                if (vert.contains(adjacentes.get(i))) 
                {
                    if (cores.get(vert.indexOf(adjacentes.get(i))) == cor) 
                    {
                        cor++;
                        i = 0;
                    }
                }                
            }
            vert.add(inicial);
            cores.add(cor);
        }
    }
    
    private Vertice getMaiorSaturacao()
    {
        ArrayList<Integer> saturacoes =  new ArrayList<>();    
        
        int saturacao ;
        for (Vertice v : vertices) 
        {
            saturacao = 0;
            for (Vertice z : getAdjacentes(v.getId())) {
                if (vert.contains(z)) 
                {
                    saturacao++;
                }
            }
            saturacoes.add(saturacao);
        }
        
        int maior = 0;
        
        for (int i = 0; i < vertices.size(); i++) {
            if ( !vert.contains(vertices.get(i)) ) 
            {
                maior = i;
            }            
        }        
        for (int i = 0; i < vertices.size(); i++) 
        {
            if (!vert.contains(vertices.get(i)) && (saturacoes.get(maior) < saturacoes.get(i))) 
            {
                maior = i;
            }
        }
        return vertices.get(maior);
    }
    
     public void Dijkstra(String id)
    {
        ArrayList<Boolean> aberto = new ArrayList<>();
        /*
        null -> Indiferente
        true -> Aberto
        false -> Fechado
        */
        
        //Inicialização
        for (Vertice v: vertices)
        {
            verticesDijkstra.add(v);
            estimativaDijkstra.add(null);
            precedentesDijkstra.add(null);
            aberto.add(null);
        }
        
        //Pegando primeiro vertice
        int index = verticesDijkstra.indexOf(getVertice(id));
        Vertice selecionado = verticesDijkstra.get(index);
        
        //Setando o primeiro vertice
        estimativaDijkstra.set(index, (float)0);
        precedentesDijkstra.set(index, getVertice(id));
        aberto.set(index, false);
        
        //Abrindo os vertices adjancentes do primeiro
        for (Aresta a: selecionado.getArestas())
        {
            if (a.getVertice2() != selecionado && aberto.get(verticesDijkstra.indexOf(a.getVertice2())) == null)
            {
                aberto.set(verticesDijkstra.indexOf(a.getVertice2()), true);
                estimativaDijkstra.set(verticesDijkstra.indexOf(a.getVertice2()), a.getValor());
                precedentesDijkstra.set(verticesDijkstra.indexOf(a.getVertice2()), selecionado);
            }
        }
        
        for (Vertice v: verticesDijkstra)
        {
            System.out.print(v.getId() + "\t");
        }
        System.out.println("");
        
        for (float est: estimativaDijkstra)
        {
            System.out.print(est + "\t");
        }
        System.out.println("");
        
        for (Vertice v: precedentesDijkstra)
        {
            System.out.print(v.getId() + "\t");
        }
        System.out.println("");
        
        for (boolean v: aberto)
        {
            System.out.print(v + "  ");
        }
        System.out.println("");
        
        System.out.println("-----------------------------------");
        
        
        //Resto do algoritmo
        while (aberto.contains(true))
        {   
            //Seleciona o primeiro aberto que achar
            for (Vertice v: verticesDijkstra)
            {
                if (aberto.get(verticesDijkstra.indexOf(v)) == true)
                {
                    selecionado = v;
                    index = verticesDijkstra.indexOf(selecionado);
                    break;
                }
            }
            //Seleciona o aberto com menor estimativa
            for (Vertice v: verticesDijkstra)
            {
                if (aberto.get(verticesDijkstra.indexOf(v)) == true && estimativaDijkstra.get(index) > estimativaDijkstra.get(verticesDijkstra.indexOf(v)))
                {
                    selecionado = v;
                    index = verticesDijkstra.indexOf(selecionado);
                }
            }
            
            //Fecha o vertice selecionado
            aberto.set(index, false);
            
            //Abre os vertices adjacentes
            for (Aresta a: selecionado.getArestas())
            {
                if (a.getVertice2() != selecionado && aberto.get(verticesDijkstra.indexOf(a.getVertice2())) == null)
                {
                    aberto.set(verticesDijkstra.indexOf(a.getVertice2()), true);
                    estimativaDijkstra.set(verticesDijkstra.indexOf(a.getVertice2()), a.getValor());
                    precedentesDijkstra.set(verticesDijkstra.indexOf(a.getVertice2()), selecionado);
                }
            }
            
            //Recalcula as rotas dos vertices abertos adjacentes
            for (Aresta a: selecionado.getArestas())
            {
                if (aberto.get(verticesDijkstra.indexOf(a.getVertice2())) == true && estimativaDijkstra.get(verticesDijkstra.indexOf(a.getVertice2())) > a.getValor())
                {
                    estimativaDijkstra.set(verticesDijkstra.indexOf(a.getVertice2()), a.getValor());
                    precedentesDijkstra.set(verticesDijkstra.indexOf(a.getVertice2()), selecionado);
                }
            }
            
            for (Vertice v: verticesDijkstra)
            {
                System.out.print(v.getId() + "\t");
            }
            System.out.println("");

            for (float est: estimativaDijkstra)
            {
                System.out.print(est + "\t");
            }
            System.out.println("");

            for (Vertice v: precedentesDijkstra)
            {
                System.out.print(v.getId() + "\t");
            }
            System.out.println("");

            for (boolean v: aberto)
            {
                System.out.print(v + "  ");
            }
            System.out.println("");

            System.out.println("-----------------------------------");
            
        }
        
    }
    
}
