package OOP.GameProject.TextBox;

import OOP.GameProject.Load;
import OOP.GameProject.Oldman;

import java.awt.*;
import java.awt.image.BufferedImage;

public class OldmanTB extends Textbox{
    private BufferedImage[][] text;
    private BufferedImage avatar;
    private int pos = 20;
    public OldmanTB() {
        idx = -1;
        create_img();
        avatar = Load.getImg("TextBox/Avatar.png");
    }
    public void create_img(){
        text = new BufferedImage[3][3];
        for (int i=0; i<2; i++){
            for (int j=0; j<2;j++) {
                text[i][j] = Load.getImg("TextBox/Old" + (i) +(j) + ".png");
            }
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        for (int i=0; i<2; i++){
            g.drawImage(text[idx][i], 160, pos + i * 20, 400, 19, null);
        }
        g.drawImage(avatar,33,28,90,92,null);
    }
}
