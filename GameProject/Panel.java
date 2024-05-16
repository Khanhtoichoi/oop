package OOP.GameProject;

import OOP.GameProject.GameStates.GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
                    case Lapanel -> game.getLapanel().keyPressed(e);
                    case Firepanel -> game.getFirepanel().keyPressed(e);
                    case Classpanel -> game.getClassPanel().keyPressed(e);
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

    }

    public GamePlay getGame() {
        return game;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        game.render(g);
    }


}
