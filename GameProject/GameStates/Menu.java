package OOP.GameProject.GameStates;

import OOP.GameProject.GamePlay;
import OOP.GameProject.Load;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;
public class Menu implements State{
    private GamePlay game;
    private int idx = 0;
    private BufferedImage[] img, imgg;
    private BufferedImage bg;
    private BufferedImage title;
    public Menu(GamePlay game){
        this.game = game;
        img = new BufferedImage[3];
        imgg = new BufferedImage[3];
        img[0]= Load.getImg("GameStates/Start.png");
        img[1] = Load.getImg("GameStates/Start1.png");
        imgg[0] = Load.getImg("GameStates/Exit.png");
        imgg[1] = Load.getImg("GameStates/Exit1.png");
        bg = Load.getImg("GameStates/background.jpg");
        title = Load.getImg("GameStates/Title.png");
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawImage(bg,0,0,gamewidth,gameheight, null);
        g.drawImage(title,430,50,null);
        g.drawImage(img[idx],560,450,150,44,null);
        g.drawImage(imgg[1-idx], 558, 500, 150, 34 , null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();
        if(idx!=1){
            if( x == KeyEvent.VK_S) idx++;
        }
        if(idx!=0){
            if( x== KeyEvent.VK_W) idx--;
        }
        if(x == KeyEvent.VK_ENTER){
            if(idx == 0) GameState.st = GameState.Loading;
            else System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
