package OOP.GameProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {
   private int horizon = 50;
   private int vertical = 50;
   private int xDir = 1;
   private int yDir = 1;
   List<Rect> rects = new ArrayList<>();
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
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
       addMouseListener(new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
               horizon = e.getX();
               vertical = e.getY();
               Rect rect = new Rect(horizon,vertical);
               rects.add(rect);
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
    private void update(){
       horizon+=xDir;
       vertical+=yDir;
       if(horizon > 350 || horizon <0){
           xDir*=-1;
       }
       if(vertical > 250 || vertical < 0){
           yDir*=-1;
       }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Rect rect : rects){
            rect.draw(g);
            rect.update();
        }
    }
}
