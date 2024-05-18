package OOP.GameProject.GameStates;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Lapanel;
import OOP.GameProject.Load;
import OOP.GameProject.Map.ClassMap;
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
    private ClassMap classMap;
    private GamePlay game;
    private BufferedImage win, lose,scho;
    private TutorialTB tutorialTB;
    private Textbox textbox;
    private int idx = 0;
    public Play(GamePlay game){
        this.game = game;
        player = new Player(180,200);
        startMap = new StartMap(game);
        fireMap = new FireMap(game);
        classMap = new ClassMap(game);
        tutorialTB = new TutorialTB();
        win = Load.getImg("GameStates/Win.png");
        scho = Load.getImg("GameStates/Scho.png");
        lose = Load.getImg("GameStates/Lose.png");
    }

    public Player getPlayer() {
        return player;
    }

    public void update(){
        player.update();
        switch (MapManager.map){
            case FireMap -> fireMap.update();
            case StartMap -> startMap.update();
            case ClassMap -> classMap.update();
        }
    }
    public void render(Graphics g){
        switch (MapManager.map){
            case StartMap -> startMap.render(g);
            case FireMap -> fireMap.render(g);
            case ClassMap -> classMap.render(g);
        }
        player.render(g);
        if(tutorialTB.getIdx()<5){
            tutorialTB.render(g);
        }
        if(game.getChestPanel().isCheck()){
            GameState.st = GameState.Icepanel;
            g.drawImage(win,300,170,null);
            g.drawImage(scho,300,350,null);
            if(idx>=1) System.exit(0);
        }
        else if(game.getChestPanel().isCheckfalse() || player.getHP()==0){
            GameState.st = GameState.Icepanel;
            g.drawImage(lose,250,170,null);
            if(idx>=1) System.exit(0);
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
        if(x== KeyEvent.VK_ENTER){
        switch (MapManager.map) {
            case StartMap -> {
                if (player.getY() >= 190 && player.getY() <= 220 && player.getX() <= 60) {
                    startMap.getOldman().setOmcheck(true);
                    startMap.getOmtb().update();
                }
                if (player.getY() >= 150 && player.getY() <= 180 && player.getX() >= 780 && player.getX() <= 830) {
                    startMap.getChestTextbox().setCheck(true);
                    if(game.getFirepanel().isCheck() && game.getLapanel().isCheck() && game.getClassPanel().isCheck()){
                        if(startMap.getChestTextbox().getIdx()>=1){
                            startMap.getChestTextbox().update();
                        }
                        else startMap.getChestTextbox().setIdx(1);
                    }
                    else startMap.getChestTextbox().update();
                }
                if (player.getX() >= 450 && player.getX() <= 490 && player.getY() >= 600 && player.getY() <= 650 && game.getFirepanel().isCheck()) {
                    startMap.getClassTB().update();
                }
                if(game.getChestPanel().isCheck()) {
                    idx++;
                }
                else if(game.getChestPanel().isCheckfalse() || player.getHP()==0) {
                    idx++;
                }
            }

            case FireMap -> {
                if (player.getX() <= 230 && game.getLapanel().isCheck()) {
                    fireMap.getFireTB().update();
                }
                if (player.getX() >= 1000 && player.getX() <= 1050 && player.getY() >= 80 && player.getY() <= 130) {
                    fireMap.getDevilTB().setCheck(true);
                    fireMap.getDevilTB().update();
                }
            }
            case ClassMap -> {
                if(player.getX()>=580 && player.getX()<=630){
                    classMap.getProfTB().setCheck(true);
                    classMap.getProfTB().update();
                }
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
