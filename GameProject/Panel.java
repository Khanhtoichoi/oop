package OOP.GameProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {
   private int horizon = 50;
   private int vertical = 50;
   private BufferedImage image;
    public Panel(){
        setPreferredSize(new Dimension(1280,800));
        create_img();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = e.getKeyCode();
                if(x == KeyEvent.VK_W) vertical-=10;
                else if ( x == KeyEvent.VK_A) horizon-=10;
                else if (x == KeyEvent.VK_D) horizon+=10;
                else if (x == KeyEvent.VK_S) vertical+=10;
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
    private void create_img()  {
        InputStream x = getClass().getResourceAsStream("Pip.png");
        try {
            image = ImageIO.read(x);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image , horizon, vertical, null);
    }
}
