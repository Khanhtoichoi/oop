package OOP.GameProject.Map;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;
import OOP.GameProject.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class StartMap extends Map{
    private GamePlay game;
    private BufferedImage img;
    private BufferedImage chest;
    public StartMap(GamePlay game){
        this.game = game;
        img = Load.getImg("Map/Map1.png");
        chest = Load.getImg("Map/chest.png");
    }
    public void render(Graphics g){
        g.drawImage(img, 0,0,gamewidth,gameheight,null);
        g.drawImage(chest ,800, 150, 50,50,null);
    }
    public void update(){
        if(game.getPlayer().getX() >= gamewidth-20){
            MapManager.map = MapManager.FireMap;
            game.getPlayer().setX(0);
            game.getPlayer().setY(0);
        }
    }

    public static boolean checkcollision(int x, int y,int gamewidth,int gameheight){
        if(x<0 || x>gamewidth) return false;
        if(y<0 || y>gameheight) return false;
        if(y >= 370 && y<=410 && x<=520 ) return true;
        if(x>=60 && x<=90 && y>=150 && y<=390) return true;
        if(y >=190 && y<=220 && x<230) return true;
        if(x>=160 && x<=190 && y>=390) return true;
        if(y>=340 && y<=370 && x<=600) return true;
        if(y>=250 && y<=360 && x>=550 && x<=700) return true;
        if(y>=230 && y<= 270 && x>=690 && x<=800) return true;
        if(x>=700 && x<=800 && y<=240 && y>=150) return true;
        if(y>=150 && y<=220 && x>=790 && x<=1200) return true;
        if(y>=140 && y<=300 && x>=1180 && x<=gamewidth) return true;
        if(x>=450 && x<=490 && y>= 390) return true;
        if(x>=910 && x<=950 && y>=200) return true;
        return false;
    }
}

