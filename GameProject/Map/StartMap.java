package OOP.GameProject.Map;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;
import OOP.GameProject.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class StartMap {
    private Player player;
    private GamePlay game;
    private BufferedImage img;
    private BufferedImage nextMap;
    public StartMap(GamePlay game,Player player){
        this.game = game;
        this.player = player;
        img = Load.getImg("Map/Map1.png");
        nextMap = Load.getImg("Map/Map.jpg");
    }
    public void render(Graphics g){
        g.drawImage(img, 0,0,gamewidth,gameheight,null);
    }
    public void update(){
        if(player.getX() > gamewidth){
            img = nextMap;
            player.setX(0);
            player.setY(0);
        }
    }
}
