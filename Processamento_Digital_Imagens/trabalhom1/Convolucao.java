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
public class Convolucao {
    
    /**
     * Convolution
     * @param input Input image
     * @param mask Mask used
     * @param size_mask Size of mask used
     * @param tax Tax of thresholding
     * @return Convoluted image
     */
    public static BufferedImage run(String input, int[][] mask, int size_mask, int tax)
    {
        BufferedImage inputImage = Thresholding.run(input, tax);
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int rgb[] = new int[3];
        int value;
        
        for (int i=size_mask/2; i<width-size_mask/2; i++)
        {
            for (int j=size_mask/2; j<height-size_mask/2; j++)
            {
                value = 0;
                for (int m=0; m<size_mask; m++)
                {
                    for (int n=0; n<size_mask; n++)
                    {
                        value += raster.getSample(i+m-size_mask/2, j+m-size_mask/2, 0) * mask[m][n];
                    }
                }
                newRaster.setPixel(i, j, new int[]{value,value,value});
            }
        }
        
        return outputImage;
    }
    
    /**
     * Convolution
     * @param inputImage Input image
     * @param mask Mask used
     * @param size_mask Size of mask used
     * @return Convoluted image
     */
    public static BufferedImage run(BufferedImage inputImage, int[][] mask, int size_mask)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int rgb[] = new int[3];
        int value;
        
        for (int i=size_mask/2; i<width-size_mask/2; i++)
        {
            for (int j=size_mask/2; j<height-size_mask/2; j++)
            {
                value = 0;
                for (int m=0; m<size_mask; m++)
                {
                    for (int n=0; n<size_mask; n++)
                    {
                        value += raster.getSample(i+m-size_mask/2, j+m-size_mask/2, 0) * mask[m][n];
                    }
                }
                newRaster.setPixel(i, j, new int[]{value,value,value});
            }
        }
        
        return outputImage;
    }
    
}
