package OOP.GameProject.TextBox;

import OOP.GameProject.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DevilTB extends  Textbox{
    private BufferedImage avatar;
    private BufferedImage[] text;
    public DevilTB(){
        idx = -1;
        avatar = Load.getImg("TextBox/Devil.jpg");
        create_img();
    }
    public void create_img(){
        text = new BufferedImage[3];
        for(int i=0; i<3; i++){
            text[i] = Load.getImg("TextBox/Devil"+(i)+".png");
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawImage(text[idx],160,20,400,19,null);
        g.drawImage(avatar,11,11,145,145,null);
    }
}
