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
public class Dilatacao {
    
    /**
     * Generates dilated image
     * @param input Image that will be dilated 
     * @param mask Mask that will be used
     * @param size_mask Size of the mask that will be used
     * @param tax Tax of thresholding used
     * @return Dilated image
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
        
        for (int i=size_mask/2; i<width-size_mask/2; i++)
        {
            for (int j=size_mask/2; j<height-size_mask/2; j++)
            {
                if (raster.getSample(i, j, 0) == 255)
                {
                    for (int m=0; m<size_mask; m++)
                    {
                        for (int n=0; n<size_mask; n++)
                        {
                            if (mask[m][n]==255)
                            {
                                newRaster.setPixel(i+m-size_mask/2, j+n-size_mask/2, new int[]{255,255,255});
                            }
                        }
                    }
                }
            }
        }
        
        return outputImage;
    }
    
    /**
     * Generates dilated image, version with Buffered Image in parameter 
     * @param inputImage Image that will be dilated
     * @param mask Mask that will be used
     * @param size_mask Size of the mask that will be used
     * @return Dilated image
     */
    public static BufferedImage run(BufferedImage inputImage, int[][] mask, int size_mask)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int rgb[] = new int[3];
        
        for (int i=size_mask/2; i<width-size_mask/2; i++)
        {
            for (int j=size_mask/2; j<height-size_mask/2; j++)
            {
                if (raster.getSample(i, j, 0) == 255)
                {
                    for (int m=0; m<size_mask; m++)
                    {
                        for (int n=0; n<size_mask; n++)
                        {
                            if (mask[m][n]==255)
                            {
                                newRaster.setPixel(i+m-size_mask/2, j+n-size_mask/2, new int[]{255,255,255});
                            }
                        }
                    }
                }
            }
        }
        
        return outputImage;
    }
    
}
