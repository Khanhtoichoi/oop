package OOP.GameProject;

import OOP.GameProject.GameStates.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class ClassPanel extends Lapanel{
    private BufferedImage Physics;
    private BufferedImage exercise;
    public ClassPanel(GamePlay game) {
        super(game);
        avatar = Load.getImg("TextBox/Prof.jpg");
        text[0] = Load.getImg("TextBox/ClassText.png");
        exercise = Load.getImg("TextBox/Exercise.png");
        for(int i=0; i<4; i++){
            for (int j=0; j<2; j++){
                ans[i][j] = Load.getImg("GameStates/Cans" + (i) + (j) + ".png");
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bg,0,0,gamewidth,gameheight,null);
        g.drawImage(img, 330,80,600,164,null);
        g.drawImage(avatar,340,90,145,145,null);
        g.drawImage(text[idx],500,100,400,19,null);
        g.drawImage(exercise,250,320,500,77,null);
        for(int i=0; i<4; i++){
            g.drawImage(ans[i][idxx[i]],850,290+i*40,102,22,null);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();
        if(x == KeyEvent.VK_W && pos>1) pos--;
        else if(x == KeyEvent.VK_S && pos<4) pos++;
        else if(x == KeyEvent.VK_ENTER){
            if(idx!=0){
                GameState.st = GameState.Play;
                idx = 0;
                pos = 1;
            }
            else if(pos == 3){
                idx = 1;
                check = true;
            }
            else if(pos !=3) idx=2;
        }
    }
}
