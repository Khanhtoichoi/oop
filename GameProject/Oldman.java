package OOP.GameProject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Oldman extends Characterr{
    private BufferedImage img;
    private boolean omcheck = false;
    public Oldman(int x, int y) {
        super(x, y);
        img = Load.getImg("Pip/Oldman.png");
    }
    public void render(Graphics g){
        g.drawImage(img,x,y,null);
    }

    public void setOmcheck(boolean omcheck) {
        this.omcheck = omcheck;
    }

    public boolean isOmcheck() {
        return omcheck;
    }
}
