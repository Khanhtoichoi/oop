package OOP.GameProject.TextBox;

import OOP.GameProject.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ChestTextbox extends Textbox{
    private BufferedImage[] text;
    public ChestTextbox(){
        idx = -1;
        text = new BufferedImage[2];
        for(int i=0; i<2; i++){
            text[i] = Load.getImg("TextBox/Chest"+(i)+".png");
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawImage(text[idx],160,20,400,19,null);
    }
    public void update(){
        idx++;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheck() {
        return check;
    }
}
