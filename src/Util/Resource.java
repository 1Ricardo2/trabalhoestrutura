package Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Resource {
    public static BufferedImage getResourceImage(String diretorio){
    BufferedImage img = null;
        try {
            img = ImageIO.read(new File(diretorio));
        } catch (IOException ex) {
         ex.printStackTrace();
        }
        return img;
    }
}
