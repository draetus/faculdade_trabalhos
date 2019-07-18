package grafotad;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class BuscaEmLargura {
    
    private static ArrayList<Vertice> vertices = new ArrayList<>();
    private static boolean[] visitados;
    public static ArrayList<Apontador> apontadores = new ArrayList<>();
    
    public BuscaEmLargura()
    {
        
    }
    
    public static void run(Grafo g, String inicio, String fim)
    {
        int aux = 0;
        int aux2 = 0;
        
        vertices = g.getVertices();
        visitados = new boolean[vertices.size()];
        
        ArrayList<Vertice> abertos = new ArrayList<>();
        ArrayList<Vertice> fechados = new ArrayList<>();
        
        abertos.add(g.getVertice(inicio));
        
        for (int i=0; i<g.getAdjacentes(inicio).size(); i++)
        {
            ArrayList<Vertice> x = new ArrayList<>();
            x.add(g.getVertice(inicio));
            apontadores.add(new Apontador(x, 0));
        }
        
        Vertice v;
        
        do
        {
            if (abertos.isEmpty())
            {
                return;
            }
            
            v = abertos.get(0);
            abertos.remove(0);
            fechados.add(v);
            for (int i=0; i<vertices.size(); i++)
            {
                if (v.getId().equals(vertices.get(i).getId()))
                {
                    visitados[i] = true;
                }
            }
            
            for (Vertice i: g.getAdjacentes(v.getId()))
            {
                if (!BuscaEmLargura.foiVisistado(i))
                {
                    aux++;
                }
            }
            
            for (Apontador x: apontadores)
            {
                if (x.getVertices().get(x.getVertices().size()-1).getId().equals(v.getId()))
                    aux2++;
            }
            
            for (int i=0; i<aux-aux2; i++)
            {
                for (Apontador x: apontadores)
                {
                    if (x.getVertices().get(x.getVertices().size()-1).getId().equals(v.getId()))
                    {
                        ArrayList<Vertice> y = new ArrayList<>();
                        for (Vertice z : x.getVertices())
                        {
                            y.add(z);
                        }
                        apontadores.add(new Apontador(y, x.getValor()));
                    }
                }
            }
            
            for (Vertice i: g.getAdjacentes(v.getId()))
            {
                if (!BuscaEmLargura.foiVisistado(i) && !abertos.contains(i))
                {
                    abertos.add(i);
                    for (Apontador x: apontadores)
                    {
                        if (x.getVertices().get(x.getVertices().size()-1).getId().equals(v.getId()))
                        {
                            x.setValor(x.getValor() + g.getArestaEntreVertices(v.getId(), i.getId()).getValor());
                            x.addVertice(i);
                            break;
                        }
                    }
                }
            }
            aux = 0;
            aux2 = 0;
            
        } while (!v.getId().equals(g.getVertice(fim)));
        
    }
    
    private static boolean foiVisistado(Vertice v)
    {
        for (int i=0; i<vertices.size(); i++)
        {
            if (v.getId().equals(vertices.get(i).getId()))
            {
                return visitados[i];
            }
        }
        return false;
    }
}
