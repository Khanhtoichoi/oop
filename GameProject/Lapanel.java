package OOP.GameProject;

import OOP.GameProject.GameStates.GameState;
import OOP.GameProject.GameStates.State;
import OOP.GameProject.TextBox.Textbox;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.security.Key;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class Lapanel extends Textbox {
    protected GamePlay game;
    protected int pos = 1;
    protected BufferedImage bg, matrix,avatar, text[];
    protected BufferedImage[][] ans;
    protected int[] idxx;
    private int rand = 0;
    public Lapanel(GamePlay game){
        this.game = game;
        ans = new BufferedImage[4][2];
        idxx = new int[4];
        text = new BufferedImage[3];
        bg = Load.getImg("GameStates/La.jpg");
        avatar = Load.getImg("TextBox/Avatar.png");
        matrix = Load.getImg("GameStates/Matrix.png");
        text[0] = Load.getImg("TextBox/LaText.png");
        text[1] = Load.getImg("TextBox/Right.png");
        text[2] = Load.getImg("TextBox/Wrong.png");
        for(int i=0; i<4; i++){
            for (int j=0; j<2; j++){
                ans[i][j] = Load.getImg("GameStates/Ans" + (i) + (j) + ".png");
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bg,0,0,gamewidth,gameheight,null);
        g.drawImage(img, 330,80,600,164,null);
        g.drawImage(avatar,370,108,90,92,null);
        g.drawImage(text[idx],500,100,400,19,null);
        g.drawImage(matrix,280,250,450,227,null);
        for(int i=0; i<4; i++){
            g.drawImage(ans[i][idxx[i]],850,290+i*40,80,22,null);
        }
    }

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
             else if(pos == 1){
                 idx = 1;
                 check = true;
            }
             else if(pos !=1) {
                 idx = 2;
                 game.getPlayer().HPupdate();
            }
        }
    }


    public void update(){
        if(pos == 1){
            idxx[0] = 1;
            idxx[1] = 0;
            idxx[2] = 0;
            idxx[3] = 0;
        }
        else if(pos == 2) {
            idxx[0] = 0;
            idxx[1] = 1;
            idxx[2] = 0;
            idxx[3] = 0;
        }
        else if (pos == 3) {
            idxx[0] = 0;
            idxx[1] = 0;
            idxx[2] = 1;
            idxx[3] = 0;
        }
        else {
            idxx[0] = 0;
            idxx[1] = 0;
            idxx[2] = 0;
            idxx[3] = 1;
        }

    }
}
