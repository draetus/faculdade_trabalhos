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
public class Thresholding {
    
    
    
    /**
     * Execute the proccess of thresholding
     * @param input Location of input image
     * @param tax Tax of thresholding
     * @return Image with thresholding applied
     */
    public static BufferedImage run(String input, int tax)
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
                value[0] = rgb[0] > tax ? 255 : 0;
                value[1] = value[0];
                value[2] = value[1];
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
    /**
     * Execute the proccess of thresholding
     * @param inputImage Location of input image
     * @param tax Tax of thresholding
     * @return Image with thresholding applied
     */
    public static BufferedImage run(BufferedImage inputImage, int tax)
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
                value[0] = rgb[0] > tax ? 255 : 0;
                value[1] = value[0];
                value[2] = value[1];
                newRaster.setPixel(i, j, value);
            }
        }
        return outputImage;
    }
    
}
