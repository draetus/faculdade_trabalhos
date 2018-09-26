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
public class Incrementar_canal {
    
    /**
     * Increments color channel by quantity
     * @param input Location of input image
     * @param option The channel that will be incremented, 1->Red, 2->Gree, 3->Blue, 4->All
     * @param quantidade Number to be added to the chosen channel
     * @return Image with the channel incremented by quantity
     */
    public static BufferedImage quantidade(String input, int option, int quantidade)
    {
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        switch (option)
        {
            case 1: 
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+quantidade<256 ? rgb[0]+quantidade : 255;
                        value[1] = rgb[1];
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                    
            case 2:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1]+quantidade<256 ? rgb[1]+quantidade : 255;
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 3:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1];
                        value[2] = rgb[2]+quantidade<256 ? rgb[2]+quantidade : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 4:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+quantidade<256 ? rgb[0]+quantidade : 255;
                        value[1] = rgb[1]+quantidade<256 ? rgb[1]+quantidade : 255;
                        value[2] = rgb[2]+quantidade<256 ? rgb[2]+quantidade : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
        }
        
        return outputImage;
    }
    
    /**
     * Increments color channel by quantity
     * @param inputImage Location of input image
     * @param option The channel that will be incremented, 1->Red, 2->Gree, 3->Blue, 4->All
     * @param quantidade Number to be added to the chosen channel
     * @return Image with the channel incremented by quantity
     */
    public static BufferedImage quantidade(BufferedImage inputImage, int option, int quantidade)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        switch (option)
        {
            case 1: 
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+quantidade<256 ? rgb[0]+quantidade : 255;
                        value[1] = rgb[1];
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                    
            case 2:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1]+quantidade<256 ? rgb[1]+quantidade : 255;
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 3:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1];
                        value[2] = rgb[2]+quantidade<256 ? rgb[2]+quantidade : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 4:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+quantidade<256 ? rgb[0]+quantidade : 255;
                        value[1] = rgb[1]+quantidade<256 ? rgb[1]+quantidade : 255;
                        value[2] = rgb[2]+quantidade<256 ? rgb[2]+quantidade : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
        }
        
        return outputImage;
    }
    
    /**
     * Increments color channel by percentage
     * @param input Location of input image
     * @param option The channel that will be incremented, 1->Red, 2->Gree, 3->Blue, 4->All
     * @param quantidade Percentage to be added to the chosen channel
     * @return Image with the channel incremented by percentage
     */
    public static BufferedImage porcentagem(String input, int option, int quantidade)
    {
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        switch (option)
        {
            case 1: 
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+rgb[0]*(quantidade/100)<256 ? rgb[0]+rgb[0]*(quantidade/100) : 255;
                        value[1] = rgb[1];
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                    
            case 2:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1]+rgb[1]*(quantidade/100)<256 ? rgb[1]+rgb[1]*(quantidade/100) : 255;
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 3:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1];
                        value[2] = rgb[2]+rgb[2]*(quantidade/100)<256 ? rgb[2]+rgb[2]*(quantidade/100) : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 4:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+rgb[0]*(quantidade/100)<256 ? rgb[0]+rgb[0]*(quantidade/100) : 255;
                        value[1] = rgb[1]+rgb[1]*(quantidade/100)<256 ? rgb[1]+rgb[1]*(quantidade/100) : 255;
                        value[2] = rgb[2]+rgb[2]*(quantidade/100)<256 ? rgb[2]+rgb[2]*(quantidade/100) : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
        }
        
        return outputImage;
    }
    
    /**
     * Increments color channel by percentage
     * @param inputImage Location of input image 
     * @param option The channel that will be incremented, 1->Red, 2->Gree, 3->Blue, 4->All
     * @param quantidade Percentage to be added to the chosen channel
     * @return Image with the channel incremented by percentage
     */
    public static BufferedImage porcentagem(BufferedImage inputImage, int option, int quantidade)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int[] value = new int[3], rgb = new int[3];
        switch (option)
        {
            case 1: 
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+rgb[0]*(quantidade/100)<256 ? rgb[0]+rgb[0]*(quantidade/100) : 255;
                        value[1] = rgb[1];
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                    
            case 2:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1]+rgb[1]*(quantidade/100)<256 ? rgb[1]+rgb[1]*(quantidade/100) : 255;
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 3:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0];
                        value[1] = rgb[1];
                        value[2] = rgb[2]+rgb[2]*(quantidade/100)<256 ? rgb[2]+rgb[2]*(quantidade/100) : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
                
            case 4:
                for (int i=0; i<width; i++)
                {
                    for (int j=0; j<height; j++)
                    {
                        rgb = raster.getPixel(i, j, rgb);
                        value[0] = rgb[0]+rgb[0]*(quantidade/100)<256 ? rgb[0]+rgb[0]*(quantidade/100) : 255;
                        value[1] = rgb[1]+rgb[1]*(quantidade/100)<256 ? rgb[1]+rgb[1]*(quantidade/100) : 255;
                        value[2] = rgb[2]+rgb[2]*(quantidade/100)<256 ? rgb[2]+rgb[2]*(quantidade/100) : 255;
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
        }
        
        return outputImage;
    }
    
}
