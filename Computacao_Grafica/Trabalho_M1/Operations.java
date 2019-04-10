package trabalho_m1;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mauricio
 */
public class Operations {
    
    public static void translation(int[] xPoints1, int[] yPoints1, int xMove, int yMove, BufferedImage image)
    {
        int[] xPoints = xPoints1.clone();
        int[] yPoints = yPoints1.clone();
        for (int i=0; i<xPoints.length; i++)
        {
            xPoints[i] += xMove;
        }
        
        for (int i=0; i<yPoints.length; i++)
        {
            yPoints[i] += yMove;
        }
        
        Drawing.draw(xPoints, yPoints, "Translation", image);
    }
    
    public static void scale(int[] xPoints1, int[] yPoints1, float xScala, float yScala, BufferedImage image)
    {
        int[] xPoints = xPoints1.clone();
        int[] yPoints = yPoints1.clone();
        for (int i=0; i<xPoints.length; i++)
        {
            xPoints[i] = (int)(xPoints[i] * xScala);
        }
        
        for (int i=0; i<yPoints.length; i++)
        {
            yPoints[i] = (int)(yPoints[i] * yScala);
        }
        
        Drawing.draw(xPoints, yPoints, "Scala", image);
    }
    
    public static void rotation(int[] xPoints1, int[] yPoints1, float grau, BufferedImage image)
    {   
        int[] xPoints = xPoints1.clone();
        int[] yPoints = yPoints1.clone();
        int [] xPointsAux = new int[xPoints.length];
        int [] yPointsAux = new int[yPoints.length];
        
        int xAux = xPoints[0];
        int yAux = yPoints[0];
        
        
        for (int i=0; i<xPoints.length; i++){
            xPoints[i] = xPoints[i] - xAux;
        }
        
        for (int i=0; i<yPoints.length; i++){
            yPoints[i] = yPoints[i] - yAux;
        }
        
        for (int i=0; i<xPoints.length; i++)
        {
            xPointsAux[i] = (int)(xPoints[i] * Math.cos(Math.toRadians(grau)) - yPoints[i] * Math.sin(Math.toRadians(grau)));
        }
        
        for (int i=0; i<yPoints.length; i++)
        {
            yPointsAux[i] = (int)(xPoints[i] * Math.sin(Math.toRadians(grau)) + yPoints[i] * Math.cos(Math.toRadians(grau)));
        }
        
        for (int i=0; i<xPoints.length; i++){
            xPointsAux[i] += xAux;
        }
        
        for (int i=0; i<yPoints.length; i++){
            yPointsAux[i] += yAux;
        }
        
        Drawing.draw(xPointsAux, yPointsAux, "Rotation", image);
    }
    
    public static void bresenham(int x0, int y0, int x1, int y1)
    {
        int linha = 1280;
        int col = 1280;
        
        final BufferedImage img = new BufferedImage(linha, col,
            BufferedImage.TYPE_INT_RGB);
        
        boolean[][] matrizQuadrante = new boolean[linha/40][col/40];
        for (int i=0; i<linha/40; i++)
        {
            for (int j=0; j<col/40; j++)
            {
                matrizQuadrante[i][j] = false;
            }
        }
        
        
        
        int quadrantex, quadrantey;
        
        for (int i=0; i<linha; i+=40)
        {
            for (int j=0; j<col; j++)
            {
                img.setRGB(i, j, Color.WHITE.getRGB());
            }
        }
        
        for (int i=0; i<linha; i+=40)
        {
            for (int j=0; j<col; j++)
            {
                img.setRGB(j, i, Color.WHITE.getRGB());
            }
        }
        
        int dx = Math.abs(x1 - x0);
        int dy = Math.abs(y1 - y0);
        
        int sx = x0 < x1 ? 1 : -1; 
        int sy = y0 < y1 ? 1 : -1; 
        
        int err = dx-dy;
        int e2;
        
        while(true)
        {
            quadrantex = (int)x0/40;
            quadrantey = (int)y0/40;
            
            if (!matrizQuadrante[quadrantex][quadrantey])
            {
                matrizQuadrante[quadrantex][quadrantey] = true;
                quadrantex = quadrantex*40;
                quadrantey = quadrantey*40;

                for (int i=quadrantex; i<quadrantex+40; i++)
                {
                    for (int j=quadrantey; j<quadrantey+40; j++)
                    {
                        img.setRGB(i, j, Color.WHITE.getRGB());
                    }
                }
            }
            
            img.setRGB(x0, y0, Color.RED.getRGB());
            
            if (x0 == x1 && y0 == y1) 
                break;
            
            e2 = 2 * err;
            if (e2 > -dy) 
            {
                err = err - dy;
                x0 = x0 + sx;
            }
            
             if (e2 < dx) 
            {
                err = err + dx;
                y0 = y0 + sy;
            }
        }
        
        Drawing.show(img, "Bresenham");
    }
    
    public static float[][] rotation3d(float[][] points, float grau, int eixo)
    {
        
        float [][] pointsAux = points;
        switch(eixo)
        {
            case 1: //x
                for (int i=0; i<points.length; i++)
                {
                    pointsAux[i][1] = (float) (points[i][1]* Math.cos(Math.toRadians(grau)) - points[i][2] * Math.sin(Math.toRadians(grau)));
                    pointsAux[i][2] = (float) (points[i][1]* Math.sin(Math.toRadians(grau)) + points[i][2] * Math.cos(Math.toRadians(grau)));
                }
                break;
                
                
            case 2: //y
                for (int i=0; i<points.length; i++)
                {
                    pointsAux[i][0] = (float) (points[i][0]* Math.cos(Math.toRadians(grau)) + points[i][2] * Math.sin(Math.toRadians(grau)));
                    pointsAux[i][2] = (float) (-points[i][0]* Math.sin(Math.toRadians(grau)) + points[i][2] * Math.cos(Math.toRadians(grau)));
                }
                break;
                
                
            case 3: //z
                for (int i=0; i<points.length; i++)
                {
                    pointsAux[i][0] = (float) (points[i][0]* Math.cos(Math.toRadians(grau)) - points[i][1] * Math.sin(Math.toRadians(grau)));
                    pointsAux[i][1] = (float) (points[i][0]* Math.sin(Math.toRadians(grau)) + points[i][1] * Math.cos(Math.toRadians(grau)));
                }
                break;
        }
        
        return pointsAux;
    }
    
}
