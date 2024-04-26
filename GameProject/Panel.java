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
import java.util.Objects;

import static OOP.GameProject.Dir.*;

public class Panel extends JPanel {
   private int horizon = 50;
   private int vertical = 50;
   private BufferedImage[][] pip;
   private int cnt=0, index=0;
   private final int speed = 15;
   private int action = stand;
   private int tmp = 0;
    public Panel(){
        create_img();
        setPreferredSize(new Dimension(1280,800));
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int x = e.getKeyCode();
                if(x == KeyEvent.VK_W) vertical-=10;
                else if ( x == KeyEvent.VK_A) {
                    horizon-=10;
                }
                else if (x == KeyEvent.VK_D){
                    action = right;
                    horizon+=10;
                }
                else if (x == KeyEvent.VK_S) {
                    if(vertical > 800) vertical = 0;
                    vertical += 10;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                int x = e.getKeyCode();
                if(x==KeyEvent.VK_D) {
                    tmp = action-1;
                    action = stand;
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
    private void create_img()  {
        pip = new BufferedImage[5][6];
        for(int j=0; j<2; j++){
        for(int i=0; i<getDir(j); i++){
            InputStream x = getClass().getResourceAsStream("Pip/Pip"+(i+1)+".png");
            try {
                pip[j][i] = ImageIO.read(x);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    x.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }}
    private void stable_animation(){
        cnt++;
        if(cnt >= speed){
            cnt=0;
            index++;
            if(index>=getDir(action)){
                index=0;
            }
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(action!=0){
            stable_animation();
            g.drawImage(pip[action][index],horizon,vertical,200,200,null);
        }
        else g.drawImage(pip[0][tmp],horizon,vertical,200,200,null);
    }
}
