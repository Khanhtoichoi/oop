package OOP.GameProject.GameStates;

import OOP.GameProject.GamePlay;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu implements State{
    private GamePlay game;
    public Menu(GamePlay game){
        this.game = game;
    }
    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.drawString("Menu", 630,200);
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
        if(x == KeyEvent.VK_ENTER) GameState.st = GameState.Play;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
