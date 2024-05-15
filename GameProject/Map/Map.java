package OOP.GameProject.Map;


import OOP.GameProject.GamePlay;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Map {
    protected static GamePlay game;
    protected BufferedImage img;
    public abstract void render(Graphics g);
    public abstract void update();
}
