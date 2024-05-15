package OOP.GameProject.GameStates;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;

import java.awt.*;
import java.awt.image.BufferedImage;

import static OOP.GameProject.Dir.getDir;
import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class Loading {
    private GamePlay game;
    private BufferedImage bg;
    private final int speed = 8;
    private int pos = 0, idx = 0, cnt = 0, count = 0;
    private BufferedImage[] images;
    public Loading(GamePlay game){
        this.game = game;
        bg = Load.getImg("GameStates/background.jpg");
        create();
    }
    public void render(Graphics g){
        g.drawImage(bg, 0,0,gamewidth, gameheight, null);
        g.drawImage(images[idx], 300+pos,gameheight-100,null);
    }

    public void update() {
        animation();
        if(count == 5){
            GameState.st = GameState.Play;
            count = 0;
        }
    }
    public void animation(){
        cnt++;
        if(cnt >= speed){
            cnt=0;
            idx++;
            pos+=100;
            if(idx>=8){
                idx=0;
                pos=0;
                count++;
            }
        }
    }
    public void create(){
        images = new BufferedImage[9];
        for(int i=0; i<9; i++){
            images[i] = Load.getImg("GameStates/Load"+(i+1)+".png");
        }
    }
}
