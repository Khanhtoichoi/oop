package OOP.GameProject.GameStates;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface State {
    public void update();
    public void render(Graphics g);
    public void keyPressed(KeyEvent e);
    public void keyReleased(KeyEvent e);
}
