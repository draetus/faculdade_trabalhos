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
public class GrafoTAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Interface i = new Interface();
        i.main(args);
        
//        Grafo grafo = new Grafo();
//        BuscaEmLargura bsc =  new BuscaEmLargura();
//        
//        Vertice a = new Vertice("a");
//        Vertice b = new Vertice("b");
//        Vertice c = new Vertice("c");
//        Vertice d = new Vertice("d");
//        Vertice e = new Vertice("e");
//        Vertice f = new Vertice("f");
//        Vertice g = new Vertice("g");
//        Vertice h = new Vertice("h");
//        
//        grafo.addVerticeByType(a);
//        grafo.addVerticeByType(b);
//        grafo.addVerticeByType(c);
//        grafo.addVerticeByType(d);
//        grafo.addVerticeByType(e);
//        grafo.addVerticeByType(f); 
//        grafo.addVerticeByType(g);
//        grafo.addVerticeByType(h);
//        
//        grafo.addAresta(a, b, 22, "a1");
//        grafo.addAresta(a, c, 14, "a2");
//        grafo.addAresta(a, d, 13, "a3");
//        grafo.addAresta(a, e, 11, "a4");
//        grafo.addAresta(a, f, 19, "a5");
//        grafo.addAresta(a, g, 12, "a6");
//        grafo.addAresta(a, h, 12, "a7");
//        
//        
//        grafo.addAresta(b, c, 12, "b1");
//        grafo.addAresta(b, d, 9, "b2");
//        grafo.addAresta(b, e, 8, "b3");
//        grafo.addAresta(b, f, 10, "b4");
//        grafo.addAresta(b, g, 13, "b5");
//        grafo.addAresta(b, h, 5, "b6");
//        
//        
//        grafo.addAresta(c, d, 7, "c1");
//        grafo.addAresta(c, e, 14, "c2");
//        grafo.addAresta(c, f, 11, "c3");
//        grafo.addAresta(c, g, 23, "c4");
//        grafo.addAresta(c, h, 11, "c5");
//        
//       
//        grafo.addAresta(d, e, 17, "d1");
//        grafo.addAresta(d, f, 22, "d2");
//        grafo.addAresta(d, g, 12, "d3");
//        grafo.addAresta(d, h, 12, "d4");
//        
//        
//        grafo.addAresta(e, f, 11, "e1");
//        grafo.addAresta(e, g, 45, "e2");
//        grafo.addAresta(e, h, 33, "e3");
//        
//        
//        grafo.addAresta(f, g, 12, "f1");
//        grafo.addAresta(f, h, 14, "f2");
//        
//        grafo.addAresta(g, h, 7, "g2");
//        
//        
//        PRIM.run(grafo);
        
        
        //BuscaEmLargura.run(g,"a", "f");
        
        
//        ArrayList<Vertice> caminho = new ArrayList<>();
//        ArrayList<Vertice> resposta;
//        boolean[] visitados;
//        BuscaEmProfundidade bemp =  new BuscaEmProfundidade(g);
//        resposta =  bemp.buscaAte(g, a, f, caminho);
//        
//        for(Vertice v : resposta)
//        {
//            System.out.println(v.getId());
//        }
//        for(Apontador as:BuscaEmLargura.apontadores)
//        {
//            for(Vertice v: as.getVertices())
//            {
//                System.out.print(v.getId() + " ");
//            }
//            System.out.println();
//        }
        
//        for(Vertice v:BuscaEmLargura.apontadores.get(0).getVertices())
//        {
//            System.out.println(v.getId());
//        }
        
//        
//        float fl = g.buscaEmLargura("a", "f");
//        
//        System.out.println("Valor: "+fl);


        
        //b.run(g, inicio, fim);
    }
    
}
