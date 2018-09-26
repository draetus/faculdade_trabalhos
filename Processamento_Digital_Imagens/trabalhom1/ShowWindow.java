package trabalhom1;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import org.opencv.core.Mat;

/**
 *
 * @author Mauricio
 */
public class ShowWindow extends JFrame{
    public static JFrame frame;
    public static Mat picture;  
    public static BufferedImage image;
    public static int larg;
    public static int alt;
    public static int modo;
    
    public static void showWindow(String nomeJanela, Mat picture){
        frame = new JFrame(nomeJanela);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(800,800);//largura e altura
        image = matToBufferedImage(picture);
        JPanel panel = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
            //BufferedImage image = null; // get your buffered image.
            //Graphics2D graphics2d = (Graphics2D) g;
            //graphics2d.drawImage(image, 0, 0, null);
            g.drawImage(image,0,0,frame.getWidth(),frame.getHeight(), this);
            super.paintComponents(g);
            
        }
    };
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    
    
    public static void showWindow(String nomeJanela, Mat picture, int l, int a){
        frame = new JFrame(nomeJanela);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);//largura e altura
        image = matToBufferedImage(picture);
        if(l == 0){alt = image.getHeight(); larg = image.getWidth();}
        larg = l;
        alt = a;
        JPanel panel = new JPanel(){
        @Override
        public void paintComponent(Graphics g) {
             g.drawImage(image,0,0,larg,alt, this);
             super.paintComponents(g);    
        }
    };
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    
    
    /**  
    * Converts/writes a Mat into a BufferedImage.  
    *  
    * @param matrix Mat of type CV_8UC3 or CV_8UC1  
    * @return BufferedImage of type TYPE_3BYTE_BGR or TYPE_BYTE_GRAY  
    */  
   public static BufferedImage matToBufferedImage(Mat matrix) {  
     int cols = matrix.cols();  
     int rows = matrix.rows();  
     int elemSize = (int)matrix.elemSize();  
     byte[] data = new byte[cols * rows * elemSize];  
     int type;  
     matrix.get(0, 0, data);  
     switch (matrix.channels()) {  
       case 1:  
         type = BufferedImage.TYPE_BYTE_GRAY;  
         break;  
       case 3:  
         type = BufferedImage.TYPE_3BYTE_BGR;  
         // bgr to rgb  
         byte b;  
         for(int i=0; i<data.length; i=i+3) {  
           b = data[i];  
           data[i] = data[i+2];  
           data[i+2] = b;  
         }  
         break;  
       default:  
         return null;  
     }  
     BufferedImage image = new BufferedImage(cols, rows, type);  
     image.getRaster().setDataElements(0, 0, cols, rows, data);  
     return image;  
   }  
}