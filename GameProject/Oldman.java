package OOP.GameProject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Oldman extends Characterr{
    private BufferedImage img;
    public Oldman(int x, int y) {
        super(x, y);
        img = Load.getImg("Pip/Oldman.png");
    }
    public void render(Graphics g){
        g.drawImage(img,x,y,null);
    }
}
