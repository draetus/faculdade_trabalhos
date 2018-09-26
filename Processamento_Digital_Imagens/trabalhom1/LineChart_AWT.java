/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.awt.image.BufferedImage;
import java.io.IOException;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame {


   public LineChart_AWT(BufferedImage image,String applicationTitle , String chartTitle ) throws IOException {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Amplitude","Frequência",
         createDataset(Histograma.run(image)),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 800 , 800 ) );
      setContentPane( chartPanel );
      pack( );
      RefineryUtilities.centerFrameOnScreen( this );
      setVisible( true );
   }

   private DefaultCategoryDataset createDataset(int[][] rgb) throws IOException {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
      for(int i=0;i<256;i++){
          dataset.addValue( rgb[0][i] , "Vermelho" , Integer.toString(i) );
          dataset.addValue( rgb[1][i] , "Azul" , Integer.toString(i) );
          dataset.addValue( rgb[2][i] , "Verde" , Integer.toString(i) );
      }
      return dataset;
   }
   
  
}