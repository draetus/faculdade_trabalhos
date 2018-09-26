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
public class Valor_pixel {
    
    /**
     * Shows the value of a pixel
     * @param input Input image
     * @param x X value
     * @param y Y value
     * @return RGB Values of the pixel
     */   
    public static int[] run(String input, int x, int y)
    {
        BufferedImage inputImage = Leitura_imagens.readImage(input);
        Raster raster = inputImage.getData();
        int[] rgb = new int[3];
        rgb = raster.getPixel(x, y, rgb);
        return rgb;
    }
    
    /**
     * Shows the value of a pixel
     * @param inputImage Input image
     * @param x X value
     * @param y Y value
     * @return RGB Values of the pixel
     */   
    public static int[] run(BufferedImage inputImage, int x, int y)
    {
        Raster raster = inputImage.getData();
        int[] rgb = new int[3];
        rgb = raster.getPixel(x, y, rgb);
        return rgb;
    }
    
}
