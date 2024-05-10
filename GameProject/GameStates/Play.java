package OOP.GameProject.GameStates;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;
import OOP.GameProject.Map.StartMap;
import OOP.GameProject.Player;
import OOP.GameProject.TextBox.TutorialTB;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static OOP.GameProject.Dir.*;
import static OOP.GameProject.Dir.down;

public class Play implements State{
    private Player player;
    private StartMap map;
    private GamePlay game;
    private BufferedImage img;
    private TutorialTB tutorialTB;
    public Play(GamePlay game){
        this.game = game;
        player = new Player(180,200);
        map = new StartMap(game);
        tutorialTB = new TutorialTB();
    }

    public Player getPlayer() {
        return player;
    }

    public void update(){
        player.update();
        map.update();
    }
    public void render(Graphics g){
        map.render(g);
        player.render(g);
        if(tutorialTB.getIdx()<3){
            tutorialTB.render(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
            tutorialTB.setIdx(tutorialTB.getIdx()+1);
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
