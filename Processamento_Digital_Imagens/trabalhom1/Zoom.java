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
public class Zoom {
    
    /**
     * Zoom in
     * @param input Image
     * @return Zoomed image
     */
    public static BufferedImage zoom_in(String input)
    {
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width*2, height*2);
        WritableRaster newRaster = outputImage.getRaster();
        int[] rgb = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb = raster.getPixel(i, j, rgb);
                newRaster.setPixel(i*2, j*2, rgb);
                newRaster.setPixel(i*2, j*2+1, rgb);
                newRaster.setPixel(i*2+1, j*2, rgb);
                newRaster.setPixel(i*2+1, j*2+1, rgb);
            }
        }
        
        return outputImage;
    }
    
    /**
     * Zoom in
     * @param inputImage Image
     * @return Zoomed image
     */
    public static BufferedImage zoom_in(BufferedImage inputImage)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width*2, height*2);
        WritableRaster newRaster = outputImage.getRaster();
        int[] rgb = new int[3];
        
        for (int i=0; i<width; i++)
        {
            for (int j=0; j<height; j++)
            {
                rgb = raster.getPixel(i, j, rgb);
                newRaster.setPixel(i*2, j*2, rgb);
                newRaster.setPixel(i*2, j*2+1, rgb);
                newRaster.setPixel(i*2+1, j*2, rgb);
                newRaster.setPixel(i*2+1, j*2+1, rgb);
            }
        }
        
        return outputImage;
    }
    
    
    /**
     * Zoom out
     * @param input Input image
     * @return Zoomed out image
     */
    public static BufferedImage zoom_out(String input)
    {
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width/2, height/2);
        WritableRaster newRaster = outputImage.getRaster();
        int[][] rgb = new int[4][3];
        int[] value = new int[3];
        
        for (int i=0; i<width-1; i=i+2)
        {
            for (int j=0; j<height-1; j=j+2)
            {
                rgb[0] = raster.getPixel(i, j, rgb[0]);
                rgb[1] = raster.getPixel(i+1, j, rgb[1]);
                rgb[2] = raster.getPixel(i, j+1, rgb[2]);
                rgb[3] = raster.getPixel(i+1, j+1, rgb[3]);
                value[0] = (rgb[0][0] + rgb[1][0] + rgb[2][0] + rgb[3][0])/4;
                value[1] = (rgb[0][1] + rgb[1][1] + rgb[2][1] + rgb[3][1])/4;
                value[2] = (rgb[0][2] + rgb[1][2] + rgb[2][2] + rgb[3][2])/4;
                newRaster.setPixel(i/2, j/2, value);
            }
        }
        
        return outputImage;
    }
    
    /**
     * Zoom out
     * @param inputImage Image
     * @return Zoomed out image
     */
    public static BufferedImage zoom_out(BufferedImage inputImage)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width/2, height/2);
        WritableRaster newRaster = outputImage.getRaster();
        int[][] rgb = new int[4][3];
        int[] value = new int[3];
        
        for (int i=0; i<width-1; i=i+2)
        {
            for (int j=0; j<height-1; j=j+2)
            {
                rgb[0] = raster.getPixel(i, j, rgb[0]);
                rgb[1] = raster.getPixel(i+1, j, rgb[1]);
                rgb[2] = raster.getPixel(i, j+1, rgb[2]);
                rgb[3] = raster.getPixel(i+1, j+1, rgb[3]);
                value[0] = (rgb[0][0] + rgb[1][0] + rgb[2][0] + rgb[3][0])/4;
                value[1] = (rgb[0][1] + rgb[1][1] + rgb[2][1] + rgb[3][1])/4;
                value[2] = (rgb[0][2] + rgb[1][2] + rgb[2][2] + rgb[3][2])/4;
                newRaster.setPixel(i/2, j/2, value);
            }
        }
        
        return outputImage;
    }
    
}
