package OOP.GameProject.TextBox;

import OOP.GameProject.Load;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Textbox {
    protected boolean check = false;
    protected BufferedImage img;
    protected BufferedImage enter;
    protected int idx = 0;
    public Textbox(){
        img = Load.getImg("TextBox/R.png");
        enter = Load.getImg("TextBox/Enter.png");
    }


    public void update(){
        idx++;
    }
    public void render(Graphics g){
        g.drawImage(img,0,0,600,164,null);
        g.drawImage(enter,330,120,250,14,null);
    }
    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
