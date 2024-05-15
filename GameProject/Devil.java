package OOP.GameProject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Devil extends Characterr{
    private BufferedImage image;
    public Devil(int x, int y) {
        super(x, y);
        image = Load.getImg("Pip/Devil.png");
    }
    public void render(Graphics g){
        g.drawImage(image,x,y,50,49,null);
    }
}
