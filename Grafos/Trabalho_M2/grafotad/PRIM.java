package grafotad;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class PRIM {
    
    public static ArrayList<Aresta> run(GrafoN g)
    {
        float [][] pesos = new float[g.getVertices().size()][g.getVertices().size()];
        int [][] linhas = new int[g.getVertices().size()][g.getVertices().size()];
        ArrayList<Aresta> arestas = new ArrayList<>();
        ArrayList<Vertice> vertices = new ArrayList<>();
        
        //Cria matriz de pesos
        for (int i=0; i<g.getVertices().size(); i++)
        {
            for (int j=0; j<i; j++)
            {
                if (g.adjacencia(g.getVertices().get(i).getId(), g.getVertices().get(j).getId()))
                {
                    pesos[i][j] = g.getArestaEntreVertices(g.getVertices().get(i).getId(), g.getVertices().get(j).getId()).getValor();
                }
            }
        }
        
        //Lida com o primeiro escolhido
        int[] indices = pegaPrimeiro(g, pesos);
        arestas.add(g.getArestaEntreVertices(g.getVertices().get(indices[0]).getId(), g.getVertices().get(indices[1]).getId()));
        for (int i=0; i<g.getVertices().size(); i++)
        {
            if (linhas[indices[0]][i] < 2)
                linhas[indices[0]][i]++;
            
            if (linhas[i][indices[0]] < 2)
                linhas[i][indices[0]]++;
            
            if (linhas[indices[1]][i] < 2)
                linhas[indices[1]][i]++;
            if (linhas[i][indices[1]] < 2)
                linhas[i][indices[1]]++;
        }
        
        //lIDA COM O RESTO
        while(!checaConcluido(g, linhas))
        {
            indices = pegaMenor(g, pesos, linhas);
            if (indices != null)
            {
                arestas.add(g.getArestaEntreVertices(g.getVertices().get(indices[0]).getId(), g.getVertices().get(indices[1]).getId()));
                for (int i=0; i<g.getVertices().size(); i++)
            {
                if (linhas[indices[0]][i] < 2)
                    linhas[indices[0]][i]++;
                
                if (linhas[i][indices[0]] < 2)
                    linhas[i][indices[0]]++;
                
                if (linhas[indices[1]][i] < 2)
                    linhas[indices[1]][i]++;
                
                if (linhas[i][indices[1]] < 2)
                    linhas[i][indices[1]]++;
            }
            }
        }
        
//        for (Aresta a: arestas)
//        {
//            System.out.println(a.getVertice1().getId() + " - " + a.getVertice2().getId());
//        }
        
        return arestas;
        
    }
    
    public static int[] pegaMenor(GrafoN g, float[][] pesos, int[][] linhas)
    {
        int[] indices = new int[2];
        boolean conclui = true;
        for (int i=0; i<g.getVertices().size(); i++)
        {
            for (int j=0; j<i; j++)
            {
                if (linhas[i][j] == 1 && pesos[i][j] != 0 && j!=i)
                {
                    indices[0] = i;
                    indices[1] = j;
                    conclui = false;
                    break;
                }
            }
        }
        
        if (conclui)
        {
            for (int i=0; i<g.getVertices().size(); i++)
            {
                for (int j=0; j<i; j++)
                {
                    linhas[i][j] = 2;
                }
            }
            return null;
        }
        for (int i=0; i<g.getVertices().size(); i++)
        {
            for (int j=0; j<i; j++)
            {
                if (pesos[i][j] < pesos[indices[0]][indices[1]] && linhas[i][j] == 1 && pesos[i][j] != 0 && j!=i)
                {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }
    
    public static int[] pegaPrimeiro(GrafoN g, float[][] pesos)
    {
        int[] indices = new int[2];
        for (int i=0; i<g.getVertices().size(); i++)
        {
            for (int j=0; j<i; j++)
            {
                if (pesos[i][j] != 0 && j!=i)
                {
                    indices[0] = i;
                    indices[1] = j;
                    break;
                }
            }
        }
        for (int i=0; i<g.getVertices().size(); i++)
        {
            for (int j=0; j<i; j++)
            {   
                if (pesos[i][j] < pesos[indices[0]][indices[1]] && pesos[i][j] != 0 && j!=i)
                {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices;
    }
    
    public static boolean checaConcluido(GrafoN g, int[][] linhas)
    {
        for (int i=0; i<g.getVertices().size(); i++)
        {
            for (int j=0; j<i; j++)
            {
                if (linhas[i][j] == 1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
}
