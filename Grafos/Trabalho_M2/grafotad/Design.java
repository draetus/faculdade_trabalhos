/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafotad;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;

import javax.swing.JFrame;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.picking.PickedInfo;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 *
 * @author Gabriel
 */
public class Design {
    public Graph<Integer, String> g;
    public Design() 
    {    
         g.addVertex(1);
         g.addVertex(2);
         g.addVertex(3);
         g.addVertex(4);
         g.addVertex(5);
         g.addVertex(6);
 
         g.addEdge("RAD-A", 1, 2);
         g.addEdge("RAD-B", 1, 3);
    }

    private static class VertexPaintTransformer implements Transformer<Integer,Paint> {

        private final PickedInfo<Integer> pi;

        VertexPaintTransformer ( PickedInfo<Integer> pi ) { 
            super();
            if (pi == null)
                throw new IllegalArgumentException("PickedInfo instance must be non-null");
            this.pi = pi;
        }

        @Override
        public Paint transform(Integer i) {
            Color p = null;
            //Edit here to set the colours as reqired by your solution
            if ( i % 2 == 0)
                p = Color.GREEN;
            else
                p =  Color.RED;
            //Remove if a selected colour is not required
            if ( pi.isPicked(i)){
                p = Color.yellow;
            }
            return p;
        }
    }
    
    public static <Paint> void main(String[] args) {
        Design sgv = new Design(); 
        Layout<Integer, String> layout = new FRLayout(sgv.g);
        layout.setSize(new Dimension(800,800));  
        VisualizationViewer<Integer, String> vv = new VisualizationViewer<Integer, String>(layout);

        Transformer<Integer,Paint> vertexPaint = new Transformer<Integer,Paint>() {

            @Override
            public Paint transform(Integer i) {
                if ( i % 2 == 0)
                    return (Paint) Color.GREEN;
                else
                    return  (Paint) Color.RED;
            }
        };  

        vv.setPreferredSize(new Dimension(850,850));
        vv.getRenderContext().setVertexLabelRenderer(new DefaultVertexLabelRenderer(Color.green));
        vv.getRenderContext().setEdgeDrawPaintTransformer(new ConstantTransformer(Color.white));
        vv.getRenderContext().setEdgeStrokeTransformer(new ConstantTransformer(new BasicStroke(2.5f)));

        vv.getRenderContext().setVertexFillPaintTransformer(new VertexPaintTransformer(vv.getPickedVertexState()));

        DefaultModalGraphMouse graphMouse = new DefaultModalGraphMouse();
        graphMouse.setMode(edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode.PICKING);
        vv.setGraphMouse(graphMouse);

        vv.setBackground(Color.gray);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<Integer>());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);


        JFrame frame = new JFrame("Projet Algo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv); 
        frame.pack();
        frame.setVisible(true);       
    }
}

