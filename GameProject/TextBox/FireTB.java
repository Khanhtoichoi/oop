package OOP.GameProject.TextBox;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;
import OOP.GameProject.Map.FireMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FireTB extends Textbox{
    private BufferedImage[] text;
    public FireTB(){
        idx = -1;
        text = new BufferedImage[3];
        for(int i=0; i<1; i++){
            text[i] = Load.getImg("TextBox/Fire"+(i)+".png");
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        for(int i=0; i<1; i++){
            g.drawImage(text[i],160,20+i*20,400,19,null);
        }
    }
}
