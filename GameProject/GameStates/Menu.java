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
    private BufferedImage[][] img;
    private BufferedImage bg;
    private BufferedImage title;
    public Menu(GamePlay game){
        this.game = game;
        img = new BufferedImage[3][3];
        img[0][0] = Load.getImg("GameStates/Start.png");
        img[0][1] = Load.getImg("GameStates/Start1.png");
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
        g.drawImage(img[0][idx], 560, 500, 150, 44 , null);
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
        if(idx!=1){
            if( x == KeyEvent.VK_DOWN) idx++;
        }
        if(idx!=0){
            if( x== KeyEvent.VK_UP) idx--;
        }
        if(x == KeyEvent.VK_ENTER){
            if(idx == 0) GameState.st = GameState.Loading;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
