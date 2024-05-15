package OOP.GameProject.GameStates;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;
import OOP.GameProject.Map.FireMap;
import OOP.GameProject.Map.MapManager;
import OOP.GameProject.Map.StartMap;
import OOP.GameProject.Player;
import OOP.GameProject.TextBox.FireTB;
import OOP.GameProject.TextBox.Textbox;
import OOP.GameProject.TextBox.TutorialTB;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import static OOP.GameProject.Dir.*;
import static OOP.GameProject.Dir.down;

public class Play implements State{
    private Random rnd;
    private Player player;
    private StartMap startMap;
    private FireMap fireMap;
    private GamePlay game;
    private BufferedImage img;
    private TutorialTB tutorialTB;
    private Textbox textbox;
    public Play(GamePlay game){
        this.game = game;
        player = new Player(180,200);
        startMap = new StartMap(game);
        fireMap = new FireMap(game);
        tutorialTB = new TutorialTB();
    }

    public Player getPlayer() {
        return player;
    }

    public void update(){
        player.update();
        switch (MapManager.map){
            case FireMap -> fireMap.update();
            case StartMap -> startMap.update();
        }
    }
    public void render(Graphics g){
        switch (MapManager.map){
            case StartMap -> startMap.render(g);
            case FireMap -> fireMap.render(g);
        }
        player.render(g);
        if(tutorialTB.getIdx()<5){
            tutorialTB.render(g);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();
        if(x == KeyEvent.VK_W){
            player.setAction(up);
        }
        else if ( x == KeyEvent.VK_A) {
            player.setAction(left);
        }
        else if (x == KeyEvent.VK_D){
            player.setAction(right);
        }
        else if (x == KeyEvent.VK_S) {
            player.setAction(down);
        }
        else if(x == KeyEvent.VK_ENTER){
            tutorialTB.update();
        }
        switch (MapManager.map){
            case StartMap -> {
                if(x == KeyEvent.VK_ENTER && player.getY()>=190 && player.getY()<=220 && player.getX()<=60){
                    startMap.getOldman().setOmcheck(true);
                    startMap.getOmtb().update();
                }
                if(x == KeyEvent.VK_ENTER && player.getY()>=150 && player.getY()<=180 && player.getX()>=780 && player.getX()<=810){
                    startMap.getChestTextbox().setCheck(true);
                    startMap.getChestTextbox().update();
                }
            }
            case FireMap -> {
                if (x == KeyEvent.VK_ENTER && player.getX()<=230 && game.getLapanel().isCheck() ){
                    fireMap.getFireTB().update();
                }
                if(x == KeyEvent.VK_ENTER && player.getX() >= 1030 && player.getX() <=1070 && player.getY()>=130 && player.getY()<=170){
                    
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int x = e.getKeyCode();
        if(x==KeyEvent.VK_D) {
            player.setAction(stand);
        }
        else if(x == KeyEvent.VK_A){
            player.setAction(stand);

        }
        else if (x == KeyEvent.VK_S){
            player.setAction(stand);

        }
        else if(x == KeyEvent.VK_W){
            player.setAction(stand);
        }
    }
}
