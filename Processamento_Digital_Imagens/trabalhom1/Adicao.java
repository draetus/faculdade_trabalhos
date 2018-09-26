/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

/**
 *
 * @author Mauricio
 */
public class Adicao {
    
    /**
     * Sums two image into one
     * @param input1 First input image
     * @param input2 Second input image
     * @return Sum of the two images
     */
    public static BufferedImage simples(String input1, String input2)
    {
        BufferedImage inputImage1 = Leitura_imagens.readImage(input1);
        Raster raster1 = inputImage1.getData();
        BufferedImage inputImage2 = Leitura_imagens.readImage(input2);
        Raster raster2 = inputImage2.getData();
        int width = raster1.getWidth() < raster2.getWidth() ? raster1.getWidth() : raster2.getWidth();
        int height = raster1.getHeight() < raster2.getHeight() ? raster1.getHeight() : raster2.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb1 = new int[3], rgb2 = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb1 = raster1.getPixel(i, j, rgb1);
                rgb2 = raster2.getPixel(i, j, rgb2);
                //value[0] = (rgb1[0] + rgb2[0])/2;
                //value[1] = (rgb1[1] + rgb2[1])/2;
                //value[2] = (rgb1[2] + rgb2[2])/2;
                value[0] = (int)(rgb1[0]*0.50 + rgb2[0]*0.50);
                value[1] = (int)(rgb1[1]*0.50 + rgb2[1]*0.50);
                value[2] = (int)(rgb1[2]*0.50 + rgb2[2]*0.50);
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
    /**
     * Sums two image into one
     * @param inputImage1 First input image
     * @param inputImage2 Second input image
     * @return Sum of the two images
     */

    public static BufferedImage simples(BufferedImage inputImage1, BufferedImage inputImage2)
    {
        Raster raster1 = inputImage1.getData();
        Raster raster2 = inputImage2.getData();
        int width = raster1.getWidth() < raster2.getWidth() ? raster1.getWidth() : raster2.getWidth();
        int height = raster1.getHeight() < raster2.getHeight() ? raster1.getHeight() : raster2.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb1 = new int[3], rgb2 = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb1 = raster1.getPixel(i, j, rgb1);
                rgb2 = raster2.getPixel(i, j, rgb2);
                //value[0] = (rgb1[0] + rgb2[0])/2;
                //value[1] = (rgb1[1] + rgb2[1])/2;
                //value[2] = (rgb1[2] + rgb2[2])/2;
                value[0] = (int)(rgb1[0]*0.50 + rgb2[0]*0.50);
                value[1] = (int)(rgb1[1]*0.50 + rgb2[1]*0.50);
                value[2] = (int)(rgb1[2]*0.50 + rgb2[2]*0.50);
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
    /**
     * Sums two image into one, with proportions
     * @param input1 First input image
     * @param input2 Second input image
     * @param proporcao1 Proportion of first image
     * @param proporcao2 Proportion of second image
     * @return Sum of the images by proportion
     */
    public static BufferedImage ponderada(String input1, String input2, float proporcao1, float proporcao2)
    {
        BufferedImage inputImage1 = Leitura_imagens.readImage(input1);
        Raster raster1 = inputImage1.getData();
        BufferedImage inputImage2 = Leitura_imagens.readImage(input2);
        Raster raster2 = inputImage2.getData();
        int width = raster1.getWidth() < raster2.getWidth() ? raster1.getWidth() : raster2.getWidth();
        int height = raster1.getHeight() < raster2.getHeight() ? raster1.getHeight() : raster2.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb1 = new int[3], rgb2 = new int[3];
        proporcao1 = proporcao1/100;
        proporcao2 = proporcao2/100;
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb1 = raster1.getPixel(i, j, rgb1);
                rgb2 = raster2.getPixel(i, j, rgb2);
                //value[0] = (rgb1[0] + rgb2[0])/2;
                //value[1] = (rgb1[1] + rgb2[1])/2;
                //value[2] = (rgb1[2] + rgb2[2])/2;
                value[0] = (int)(rgb1[0]*proporcao1 + rgb2[0]*proporcao2);
                value[1] = (int)(rgb1[1]*proporcao1 + rgb2[1]*proporcao2);
                value[2] = (int)(rgb1[2]*proporcao1 + rgb2[2]*proporcao2);
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
    /**
     * Sums two image into one, with proportions
     * @param inputImage1 First input image
     * @param inputImage2 Second input image
     * @param proporcao1 Proportion of first image
     * @param proporcao2 Proportion of second image
     * @return Sum of the images by proportion
     */
    public static BufferedImage ponderada(BufferedImage inputImage1, BufferedImage inputImage2, float proporcao1, float proporcao2)
    {
        Raster raster1 = inputImage1.getData();
        Raster raster2 = inputImage2.getData();
        int width = raster1.getWidth() < raster2.getWidth() ? raster1.getWidth() : raster2.getWidth();
        int height = raster1.getHeight() < raster2.getHeight() ? raster1.getHeight() : raster2.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb1 = new int[3], rgb2 = new int[3];
        proporcao1 = proporcao1/100;
        proporcao2 = proporcao2/100;
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb1 = raster1.getPixel(i, j, rgb1);
                rgb2 = raster2.getPixel(i, j, rgb2);
                //value[0] = (rgb1[0] + rgb2[0])/2;
                //value[1] = (rgb1[1] + rgb2[1])/2;
                //value[2] = (rgb1[2] + rgb2[2])/2;
                value[0] = (int)(rgb1[0]*proporcao1 + rgb2[0]*proporcao2);
                value[1] = (int)(rgb1[1]*proporcao1 + rgb2[1]*proporcao2);
                value[2] = (int)(rgb1[2]*proporcao1 + rgb2[2]*proporcao2);
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
}
