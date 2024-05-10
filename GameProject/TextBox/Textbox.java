package OOP.GameProject.TextBox;

import OOP.GameProject.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Textbox {
    protected boolean check;
    protected BufferedImage img;
    protected BufferedImage enter;
    public Textbox(){
        check = true;
        img = Load.getImg("TextBox/R.png");
        enter = Load.getImg("TextBox/Enter.png");
    }
    public void update(){

    }
    public void render(Graphics g){
        g.drawImage(img,0,0,600,164,null);
        g.drawImage(enter,330,120,250,14,null);
    }
    public boolean getCheck(){
        return check;
    }
}
