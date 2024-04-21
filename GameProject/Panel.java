package OOP.GameProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel {
    public Panel(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = e.getKeyCode();
                if(x == KeyEvent.VK_W) System.out.print("W");
                else if(x == KeyEvent.VK_A) System.out.print("A");
                else if(x == KeyEvent.VK_S) System.out.print("S");
                else if(x == KeyEvent.VK_D) System.out.print("D");

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(50,50,50,50);
    }
}
