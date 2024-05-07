package OOP.GameProject;

import OOP.GameProject.GameStates.GameState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static OOP.GameProject.Dir.*;
import static OOP.GameProject.GamePlay.gameheight;
import static OOP.GameProject.GamePlay.gamewidth;

public class Panel extends JPanel {
    private GamePlay game;
    public Panel(GamePlay game){
        this.game = game;
        setPreferredSize(new Dimension(gamewidth,gameheight));
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (GameState.st){
                    case Menu -> game.getMenu().keyPressed(e);
                    case Play -> game.getPlay().keyPressed(e);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                switch (GameState.st){
                    case Menu -> game.getMenu().keyReleased(e);
                    case Play -> game.getPlay().keyReleased(e);
                }
            }

        });
       addMouseListener(new MouseListener() {
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
           public void mouseEntered(MouseEvent e) {

           }

           @Override
           public void mouseExited(MouseEvent e) {

           }
       });
       addMouseMotionListener(new MouseMotionListener() {
           @Override
           public void mouseDragged(MouseEvent e) {

           }

           @Override
           public void mouseMoved(MouseEvent e) {

           }
       });
    }

    public GamePlay getGame() {
        return game;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }


}
