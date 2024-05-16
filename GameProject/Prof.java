package OOP.GameProject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Prof extends Characterr{
    private BufferedImage img;
    public Prof(int x, int y) {
        super(x, y);
        img = Load.getImg("Pip/Prof.png");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(img,x,y,40,53,null);
    }
}
