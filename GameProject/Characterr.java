package OOP.GameProject;

import java.awt.*;

public abstract class Characterr {
    protected int x,y;
    Characterr(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract void render(Graphics g);
}
