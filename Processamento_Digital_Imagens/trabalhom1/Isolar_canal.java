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
public class Isolar_canal {
    
    /**
     * Isolates one color channel from the RGB
     * @param input Location of input image
     * @param option The channel that will be isolated, 1->Red, 2->Gree, 3->Blue
     * @return The image with the channel chosed isolated
     */
    public static BufferedImage run(String input, int option)
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
                        value[0] = rgb[0];
                        value[1] = 0;
                        value[2] = 0;
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
                        value[0] = 0;
                        value[1] = rgb[1];
                        value[2] = 0;
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
                        value[0] = 0;
                        value[1] = 0;
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
        }
        return outputImage;
    }
    
    /**
     * Isolates one color channel from the RGB
     * @param inputImage Location of input image
     * @param option The channel that will be isolated, 1->Red, 2->Gree, 3->Blue
     * @return The image with the channel chosed isolated
     */
    public static BufferedImage run(BufferedImage inputImage, int option)
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
                        value[0] = rgb[0];
                        value[1] = 0;
                        value[2] = 0;
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
                        value[0] = 0;
                        value[1] = rgb[1];
                        value[2] = 0;
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
                        value[0] = 0;
                        value[1] = 0;
                        value[2] = rgb[2];
                        newRaster.setPixel(i, j, value);
                    }
                }
                break;
        }
        return outputImage;
    }
    
}
