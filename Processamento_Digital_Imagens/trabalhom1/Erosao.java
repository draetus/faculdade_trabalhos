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
public class Erosao {
    
    /**
     * Generates an eroded image
     * @param input Image that will be eroded, already thresholded
     * @param mask Mask that is used in the erosion
     * @param size_mask Size of the mask
     * @param tax Tax of the thresholding
     * @return Eroded image
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
        boolean detected;
        
        for (int i=size_mask/2; i<width-size_mask/2; i++)
        {
            for (int j=size_mask/2; j<height-size_mask/2; j++)
            {
                detected = true;
                for (int m=0; m<size_mask; m++)
                {
                    for (int n=0; n<size_mask; n++)
                    {
                        if (raster.getSample(i+m-size_mask/2, j+n-size_mask/2, 0) != mask[m][n] && mask[m][n] == 255)
                        {
                            detected = false;
                            break;
                        }
                    }
                }
                if (detected)
                {
                    newRaster.setPixel(i, j, new int[]{255,255,255});
                }
                else
                {
                    newRaster.setPixel(i, j, new int[]{0,0,0});
                }
            }
        }
        return outputImage;
    }
    
    /**
     * Generates an eroded image, version with Buffered Image in parameter 
     * @param inputImage Image that will be eroded, already thresholded
     * @param mask Mask that is used in the erosion
     * @param size_mask Size of the mask
     * @return Eroded image
     */
    public static BufferedImage run(BufferedImage inputImage, int[][] mask, int size_mask)
    {
        Raster raster = inputImage.getData();
        int width = raster.getWidth();
        int height = raster.getHeight();
        BufferedImage outputImage = Leitura_imagens.createSample(width, height);
        WritableRaster newRaster = outputImage.getRaster();
        int rgb[] = new int[3];
        boolean detected;
        
        for (int i=size_mask/2; i<width-size_mask/2; i++)
        {
            for (int j=size_mask/2; j<height-size_mask/2; j++)
            {
                detected = true;
                for (int m=0; m<size_mask; m++)
                {
                    for (int n=0; n<size_mask; n++)
                    {
                        if (raster.getSample(i+m-size_mask/2, j+n-size_mask/2, 0) != mask[m][n] && mask[m][n] == 255)
                        {
                            detected = false;
                            break;
                        }
                    }
                }
                if (detected)
                {
                    newRaster.setPixel(i, j, new int[]{255,255,255});
                }
                else
                {
                    newRaster.setPixel(i, j, new int[]{0,0,0});
                }
            }
        }
        return outputImage;
    }
    
}
