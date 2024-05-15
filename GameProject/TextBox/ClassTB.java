package OOP.GameProject.TextBox;

import OOP.GameProject.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ClassTB extends Textbox{
    private BufferedImage text;
    public ClassTB(){
        idx = -1;
        text = Load.getImg("TextBox/Class.png");
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawImage(text, 160,20,400,19,null);
    }
}
