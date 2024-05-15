package OOP.GameProject.Map;

import OOP.GameProject.Devil;
import OOP.GameProject.GamePlay;
import OOP.GameProject.GameStates.GameState;
import OOP.GameProject.Load;
import OOP.GameProject.TextBox.FireTB;

import java.awt.*;
import java.awt.image.BufferedImage;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class FireMap extends Map{
    private Devil devil;
    private static FireTB fireTB;
    public FireMap(GamePlay game){
        this.game = game;
        img = Load.getImg("Map/Map.jpg");
        fireTB = new FireTB();
        devil = new Devil(1030,150);
    }
    @Override
    public void render(Graphics g) {
        g.drawImage(img,0,0,gamewidth,gameheight,null);
        if(MapManager.map == MapManager.FireMap && fireTB.getIdx()>=0 && fireTB.getIdx()<1){
            fireTB.render(g);
        }
        devil.render(g);
    }

    @Override
    public void update() {
        if (game.getPlayer().getX()<0){
            MapManager.map = MapManager.StartMap;
            game.getPlayer().setX(1200);
            game.getPlayer().setY(200);
        }
    }
    public static boolean checkcollision(int x, int y,int width,int height){
        if(x<-20 || x>gamewidth) return false;
        if(y<-20 || y>gameheight) return false;
        if(fireTB.getIdx()<=0){
            if(x>=230 && x<=320 && y<=100) return false;
            if(x>=180 && x<=300 && y>=80 && y<=180) return false;
            if(x>=50 && x<=170 && y>=110 && y<=160) return false;
            if(y>=150 && y<=250 && x>=100 && x<=200) return false;
            if(x<=200 && y>=240 && y<=300) return false;
        }
        return true;
    }

    public FireTB getFireTB() {
        return fireTB;
    }
}
