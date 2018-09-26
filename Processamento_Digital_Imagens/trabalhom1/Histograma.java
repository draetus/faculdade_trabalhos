/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;

/**
 *
 * @author Mauricio
 */
public class Histograma {
    
    /**
     * Generates an histogram
     * @param input Input image
     * @return Histogram
     */
    public static int[][] run(String input)
    {
        int[][] rgb = new int[3][256];
        int[] rgb_aux = new int[3];
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        
        for (int i=0; i<raster.getWidth(); i++)
        {
            for (int j=0; j<raster.getHeight(); j++)
            {
                rgb_aux = raster.getPixel(i, j, rgb_aux);
                rgb[0][rgb_aux[0]]++;
                rgb[1][rgb_aux[1]]++;
                rgb[2][rgb_aux[2]]++;
            }
        }
        return rgb;
    }
    
    /**
     * Generates an histogram
     * @param inputImage Input image
     * @return Histogram
     */
    public static int[][] run(BufferedImage inputImage)
    {
        int[][] rgb = new int[3][256];
        int[] rgb_aux = new int[3];
        Raster raster = inputImage.getData();
        
        for (int i=0; i<raster.getWidth(); i++)
        {
            for (int j=0; j<raster.getHeight(); j++)
            {
                rgb_aux = raster.getPixel(i, j, rgb_aux);
                rgb[0][rgb_aux[0]]++;
                rgb[1][rgb_aux[1]]++;
                rgb[2][rgb_aux[2]]++;
            }
        }
        return rgb;
    }
    
}
