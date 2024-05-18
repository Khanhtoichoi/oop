package OOP.GameProject;

import OOP.GameProject.GameStates.GameState;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class ChestPanel extends Lapanel{
    private boolean checkfalse = false;
    private BufferedImage[] text;
    public ChestPanel(GamePlay game) {
        super(game);
        text = new BufferedImage[2];
        for (int i=0; i<2; i++){
            text[i] = Load.getImg("TextBox/Ches"+(i)+".png");
        }
        for (int i=0; i<4; i++){
            for (int j=0; j<2; j++){
                ans[i][j] = Load.getImg("GameStates/Chans"+(i)+(j)+".png");
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bg,0,0,gamewidth,gameheight,null);
        g.drawImage(img, 330,80,600,164,null);
        for(int i=0; i<2; i++){
            g.drawImage(text[i],500,100+i*20,400,19,null);
        }
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
            GameState.st = GameState.Play;
            pos = 1;
            if(pos == 1){
                idx = 1;
                check = true;
            }
            else checkfalse = true;
        }
    }

    public boolean isCheckfalse() {
        return checkfalse;
    }
}
