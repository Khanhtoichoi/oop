package OOP.GameProject;

import java.awt.*;
import java.util.Collections;
import java.util.Random;

public class Rect {
    private int x;
    private int y;
    private int w,h;
    private int xDir = 1;
    private int yDir = 1;
    private Random random = new Random();
    public Rect(int x, int y){
        this.x = x;
        this.y = y;
        w = random.nextInt(50);
        h = w;
    }
    public void update(){
        this.x += xDir;
        this.y += yDir;
        if(x > 400 || x < 0){
            xDir*=-1;
        }
        if(y > 300 || y < 0){
            yDir*=-1;
        }
    }
    public void draw(Graphics g){
        g.fillRect(x,y,w,h);
    }
}
