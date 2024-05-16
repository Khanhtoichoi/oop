package OOP.GameProject.TextBox;

import OOP.GameProject.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ProfTB extends Textbox{
    private BufferedImage[][] text;
    private BufferedImage avatar;
    public ProfTB(){
        idx = -1;
        create_img();
        avatar = Load.getImg("TextBox/Prof.jpg");
    }

    private void create_img() {
        text = new BufferedImage[3][3];
        for(int i=0;i<2; i++){
            for(int j=0; j<3; j++){
                text[i][j] = Load.getImg("TextBox/Prof"+(i)+(j)+".png");
            }
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        for (int i=0; i<3; i++){
            g.drawImage(text[idx][i], 160, 20 + i * 20, 400, 19, null);
        }
        g.drawImage(avatar,9,9,145,145,null);
    }
}
