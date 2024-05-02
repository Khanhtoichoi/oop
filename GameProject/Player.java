package OOP.GameProject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static OOP.GameProject.Dir.*;

public class Player extends Characterr {
    private BufferedImage[][] pip;
    private BufferedImage[][] pipstand;
    public static int cnt=0, index=0;
    private final int speed = 10;
    private int action = stand;
    private int tmp = 1;
    public int getTmp() {
        return tmp;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }
    public Player(int x, int y) {
        super(x,y);
        create_img();
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void update(){
        movement();
        stable_animation();
    }
    public void render(Graphics g){
        if(action!=0){
            g.drawImage(pip[action][index],x,y,50,50,null);
        }
        else g.drawImage(pip[0][tmp],x,y,50,50,null);
    }
    private void create_img()  {
        pip = new BufferedImage[5][6];
        for(int i=1; i<=4; i++){
            pip[0][i] = Load.getImg("Pip/Pip"+(i)+1+".png");
        }
        for(int j=1; j<=4; j++){
            for(int i=0; i<getDir(j); i++){
                pip[j][i] = Load.getImg("Pip/Pip"+j+(i+1)+".png");
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
    private void movement(){
        if(action == left){
            tmp = action;
            x-=2;
        }
        else if(action == right){
            tmp = action;
            x+=2;
        }
        else if(action == up){
            tmp = action;
            y-=2;
        }
        else if(action == down){
            tmp = action;
            y+=2;
        }
    }

}
