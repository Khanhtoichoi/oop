package OOP.GameProject.TextBox;


import OOP.GameProject.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TutorialTB extends Textbox{
    private BufferedImage[][] text;
    private BufferedImage avatar;
    private int idx = 0;
    public TutorialTB() {
        create_img();
        avatar = Load.getImg("TextBox/Avatar.png");
    }
    private int pos = 20;
    @Override
    public void render(Graphics g) {
        super.render(g);
        for(int i=0; i<3
                ; i++){
            g.drawImage(text[idx][i],160,pos+i*20,400,19,null);
        }
        g.drawImage(avatar,33,28,90,92,null);
    }
    private void create_img(){
        text = new BufferedImage[3][3];
        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                text[i][j] = Load.getImg("TextBox/Text" + (i)+(j)+".png");
            }
        }
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }
}
