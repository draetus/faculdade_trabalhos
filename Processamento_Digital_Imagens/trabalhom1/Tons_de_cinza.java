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
public class Tons_de_cinza {
    
    /**
     * Converts an image to grayscale (simple conversion)
     * @param input Location of the image to be converted
     * @return Image in grayscale
     */
    public static BufferedImage media(String input)
    {
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb = raster.getPixel(i, j, rgb);
                value[0] = (rgb[0] + rgb[1] + rgb[2])/3;
                value[1] = value[0];
                value[2] = value[1];
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
    /**
     * Converts an image to grayscale (simple conversion)
     * @param inputImage Location of the image to be converted 
     * @return Image in grayscale
     */
    public static BufferedImage media(BufferedImage inputImage)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb = raster.getPixel(i, j, rgb);
                value[0] = (rgb[0] + rgb[1] + rgb[2])/3;
                value[1] = value[0];
                value[2] = value[1];
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
    /**
     * Converts an image to grayscale (weighted conversion)
     * @param input Location of the image to be converted
     * @return Image converted in grayscale
     */
    public static BufferedImage ponderada(String input)
    {
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb = raster.getPixel(i, j, rgb);
                value[0] = (int)(rgb[0]*0.299 + rgb[1]*0.587 + rgb[2]*0.114);
                value[1] = value[0];
                value[2] = value[1];
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
    /**
     * Converts an image to grayscale (weighted conversion)
     * @param inputImage Location of the image to be converted
     * @return Image converted in grayscale
     */
    public static BufferedImage ponderada(BufferedImage inputImage)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb = raster.getPixel(i, j, rgb);
                value[0] = (int)(rgb[0]*0.299 + rgb[1]*0.587 + rgb[2]*0.114);
                value[1] = value[0];
                value[2] = value[1];
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
}
