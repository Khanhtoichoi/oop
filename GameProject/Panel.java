package OOP.GameProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel {
   private int horizon = 0;
   private int vertical = 0;
    public Panel(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = e.getKeyCode();
                if(x == KeyEvent.VK_W){
                    vertical-=10;
                }
                else if(x == KeyEvent.VK_A) horizon-=10;
                else if(x == KeyEvent.VK_S) vertical+=10;
                else if(x == KeyEvent.VK_D) horizon+=10;
                repaint();
            }
            @Override
            public void keyReleased(KeyEvent e) {

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
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawRect(50+horizon,50+vertical,50,50);
    }
}
