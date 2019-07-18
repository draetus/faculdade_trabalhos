/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafotad;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.event.GraphEvent;
import edu.uci.ics.jung.graph.event.GraphEvent.Edge;
import edu.uci.ics.jung.graph.event.GraphEvent.Vertex;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.control.PluggableGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.TranslatingGraphMousePlugin;
import edu.uci.ics.jung.visualization.decorators.PickableVertexPaintTransformer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.picking.PickedInfo;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.xml.transform.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

/**
 *
 * @author Gabriel
 */
public class GrafoTAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Interface i = new Interface();
        //i.main(args);
        GrafoD grafo = new GrafoD();

        Vertice a = new Vertice("a");
        Vertice b = new Vertice("b");
        Vertice c = new Vertice("c");
        Vertice d = new Vertice("d");
        Vertice e = new Vertice("e");
        Vertice f = new Vertice("f");
        Vertice g = new Vertice("g");
        Vertice h = new Vertice("h");

        grafo.addVerticeByType(a);
        grafo.addVerticeByType(b);
        grafo.addVerticeByType(c);
        grafo.addVerticeByType(d);
        grafo.addVerticeByType(e);
        grafo.addVerticeByType(f);
        grafo.addVerticeByType(g);
        grafo.addVerticeByType(h);

        grafo.addAresta(a, b, 22, "a1");
        grafo.addAresta(a, c, 14, "a2");
        grafo.addAresta(a, d, 13, "a3");
        grafo.addAresta(a, e, 11, "a4");
        grafo.addAresta(a, f, 19, "a5");
        grafo.addAresta(a, g, 12, "a6");
        grafo.addAresta(a, h, 12, "a7");
        
        grafo.addAresta(b, c, 12, "b1");
        grafo.addAresta(b, d, 9, "b2");
        grafo.addAresta(b, e, 8, "b3");
        grafo.addAresta(b, f, 10, "b4");
        grafo.addAresta(b, g, 13, "b5");
        grafo.addAresta(b, h, 5, "b6");

        grafo.addAresta(c, d, 7, "c1");
        grafo.addAresta(c, e, 14, "c2");
        grafo.addAresta(c, f, 11, "c3");
        grafo.addAresta(c, g, 23, "c4");
        grafo.addAresta(c, h, 11, "c5");

        grafo.addAresta(d, e, 17, "d1");
        grafo.addAresta(d, f, 22, "d2");
        grafo.addAresta(d, g, 12, "d3");
        grafo.addAresta(d, h, 12, "d4");

        grafo.addAresta(e, f, 11, "e1");
        grafo.addAresta(e, g, 45, "e2");
        grafo.addAresta(e, h, 33, "e3");

        grafo.addAresta(f, g, 12, "f1");
        grafo.addAresta(f, h, 14, "f2");

        grafo.addAresta(g, h, 7, "g2");
        
        //desenhaGrafo();

        
        System.out.println("Adjacentes de A: ");
        
        for (Vertice v : grafo.getAdjacentes(a.getId())) 
        {
            System.out.println(v.getId());
        }
        grafo.welshPowel();
        
        ArrayList<Integer> cores = grafo.cores;
        System.out.println(cores.toString());


    }
    
    public static void desenhaGrafo()
    {
        Graph<String, String> graph3 = new SparseGraph<>();

        graph3.addVertex("a");
        graph3.addVertex("f");
        graph3.addVertex("b");
        graph3.addVertex("c");
        graph3.addVertex("d");
        graph3.addVertex("e");

        graph3.addEdge("RAD-A", "a", "f");
        graph3.addEdge("RAD-B", "a", "b");
        graph3.addEdge("RAD-C", "a", "c");
        graph3.addEdge("RAD-D", "a", "d");
        graph3.addEdge("RAD-E", "c", "e");

        Layout<Integer, String> layout = new CircleLayout(graph3);
        layout.setSize(new Dimension(300, 300));
        BasicVisualizationServer<Integer, String> vv
                = new BasicVisualizationServer<Integer, String>(layout);
        
        vv.setPreferredSize(new Dimension(350, 350));

        PluggableGraphMouse gm = new PluggableGraphMouse();
        gm.add(new TranslatingGraphMousePlugin(MouseEvent.BUTTON1_MASK));
        gm.add(new ScalingGraphMousePlugin(new CrossoverScalingControl(), 0, 1.1f, 0.9f));
        
        vv.getRenderContext().setVertexLabelRenderer(new DefaultVertexLabelRenderer(Color.green));
        vv.getRenderContext().setEdgeDrawPaintTransformer(new ConstantTransformer(Color.white));
        vv.getRenderContext().setEdgeStrokeTransformer(new ConstantTransformer(new BasicStroke(2.5f)));
        
        vv.getRenderContext().setVertexFillPaintTransformer(new PickableVertexPaintTransformer<Integer>(vv.getPickedVertexState(), Color.green, Color.yellow));

        vv.setBackground(Color.gray);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
        


        JFrame frame = new JFrame("Projet Algo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv); 
        frame.pack();
        frame.setVisible(true);
    }
    
    
    

        //newGraphDraw(grafoTeste);
//        System.out.println("Adjacentes de A: ");
//        
//        for (Vertice v : grafo.getAdjacentes(a.getId())) 
//        {
//            System.out.println(v.getId());
//        }
//        grafo.welshPowel();
//        
//        ArrayList<Integer> cores = grafo.cores;
//        System.out.println(cores.toString());
    //b.run(g, inicio, fim);
    //   }
}
