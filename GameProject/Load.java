package OOP.GameProject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Load {
    private static BufferedImage img = null;
    public static BufferedImage getImg(String s){
        InputStream x = Load.class.getResourceAsStream(s);
        try {
            img = ImageIO.read(x);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                x.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return img;
    }
}
