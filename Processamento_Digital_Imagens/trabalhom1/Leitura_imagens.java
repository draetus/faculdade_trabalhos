package trabalhom1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Mauricio
 */
public class Leitura_imagens {
    
    /**
     * Reads an image
     * @param pathname Location of the image
     * @return Image
     */
    public static BufferedImage readImage(String pathname)
    {
        try
        {
            BufferedImage image = ImageIO.read(new File(pathname));
            return image;
        } 
        catch (IOException ex) 
        {
            System.err.println("Arquivo inválido");
        }
        return null;
    }
    
    /**
     * Writes an image
     * @param pathname Location to save to image
     * @param format Format of the image (jpg, png)
     * @param image Image to be saved
     */
    public static void writeImage(String pathname, String format, BufferedImage image)
    {
        try
        {
            ImageIO.write(image, format, new File(pathname));
        } 
        catch (IOException ex) 
        {
            System.out.println("Falha na escrita");
        }
    }
    
    /**
     * Create sample image, all black
     * @param width Width of the sample
     * @param height Height of the sample
     * @return Sample image
     */
    public static BufferedImage createSample(int width, int height)
    {
        return new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
    }
    
}
