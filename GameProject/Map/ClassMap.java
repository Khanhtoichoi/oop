package OOP.GameProject.Map;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;

import java.awt.*;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class ClassMap extends Map{
    public ClassMap(GamePlay game){
        this.game = game;
        img = Load.getImg("Map/Map2.jpg");
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(img, 0, 0, gamewidth, gameheight, null);
    }

    @Override
    public void update() {

    }
    public static boolean checkcollision(int x, int y, int width, int height){
        if(x<0 || x>gamewidth) return false;
        if(y<0 || y>gameheight) return false;
        if(y>=0 && y<=130) return false;
        if(x<=90 || x >=1100) return false;
        if(x<=400 && y<=200) return false;
        if(x>=950 && y<=200) return false;
        if(x>=470 && x<=720){
            if(y>=210 && y<=300) return false;
            if(y>=360 && y<=430) return false;
            if(y>=510 && y<=580) return false;
        }
        if(x>=240 && x<=400){
            if(y>=360 && y<=430) return false;
            if(y>=510 && y<=580) return false;
        }
        if(x<=950 && x>=790){
            if(y>=360 && y<=430) return false;
            if(y>=510 && y<=580) return false;
        }
        if(y>=510 && x<=170) return false;
        if(x>=1020 && y>=510) return false;
        return true;
    }
}
