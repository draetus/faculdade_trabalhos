package trabalho_m1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Mauricio
 */
public class Drawing {
    
    public static BufferedImage run(int[] xPoints, int[] yPoints, String windowName)
    {
            final BufferedImage image = new BufferedImage(1280, 1280,
                BufferedImage.TYPE_INT_RGB);
            JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());   // <== make panel fill frame
        frame.add(canvas, BorderLayout.CENTER);
        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setTitle(windowName);

        // do you drawing somewhere else, maybe a different thread
        Graphics g = image.getGraphics();
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        g.dispose();
        canvas.repaint();
        return image;
    }
    
    public static void show(BufferedImage image, String windowName)
    {
            JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());   // <== make panel fill frame
        frame.add(canvas, BorderLayout.CENTER);
        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setTitle(windowName);

        // do you drawing somewhere else, maybe a different thread
        Graphics g = image.getGraphics();
        g.drawPolygon(new int[0], new int[0], 0);

        g.dispose();
        canvas.repaint();
        }
    
    public static void draw(int[] xPoints, int[] yPoints, String windowName, BufferedImage image)
    {
            JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, this);
            }
        };


        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());   // <== make panel fill frame
        frame.add(canvas, BorderLayout.CENTER);
        frame.setSize(250, 250);
        frame.setVisible(true);
        frame.setTitle(windowName);

        // do you drawing somewhere else, maybe a different thread
        Graphics g = image.getGraphics();
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        g.dispose();
        canvas.repaint();
        }
    
    public static BufferedImage create_image(int[] xPoints, int[] yPoints)
    {
            final BufferedImage image = new BufferedImage(1280, 1280,
                BufferedImage.TYPE_INT_RGB);

        // do you drawing somewhere else, maybe a different thread
        Graphics g = image.getGraphics();
        g.drawPolygon(xPoints, yPoints, xPoints.length);

        g.dispose();
        return image;
    }
    
}
