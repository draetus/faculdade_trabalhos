/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhom1;

import java.awt.image.BufferedImage;

/**
 *
 * @author Mauricio
 */
public class AbertFecha {
    
    /**
     * Opening
     * @param input Image that will pass through the opening
     * @param mask Mask used
     * @param size_mask Size of mask
     * @param tax Tax of threshold
     * @return Finished image
     */
    public static BufferedImage abertura(String input, int[][] mask, int size_mask, int tax)
    {
        BufferedImage image = Erosao.run(input, mask, size_mask, tax);
        return Dilatacao.run(image, mask, size_mask);
    }
    
    /**
     * Opening
     * @param input Image that will pass through the opening
     * @param mask Mask used
     * @param size_mask Size of mask
     * @return Finished image
     */
    public static BufferedImage abertura(BufferedImage input, int[][] mask, int size_mask)
    {
        BufferedImage image = Erosao.run(input, mask, size_mask);
        return Dilatacao.run(image, mask, size_mask);
    }
    
    /**
     * Closing
     * @param input Image that will pass through the closing
     * @param mask Mask used
     * @param size_mask Size of mask
     * @param tax Tax of threshold
     * @return Finished image
     */
    public static BufferedImage fechamento(String input, int[][] mask, int size_mask, int tax)
    {
        BufferedImage image = Dilatacao.run(input, mask, size_mask, tax);
        return Erosao.run(image, mask, size_mask);
    }
    
    /**
     * Closing
     * @param input Image that will pass through the closing
     * @param mask Mask used
     * @param size_mask Size of mask
     * @return Finished image
     */
    public static BufferedImage fechamento(BufferedImage input, int[][] mask, int size_mask)
    {
        BufferedImage image = Dilatacao.run(input, mask, size_mask);
        return Erosao.run(image, mask, size_mask);
    }
    
}
