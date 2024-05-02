package OOP.GameProject;

import OOP.GameProject.Map.StartMap;

import java.awt.*;

public class GamePlay implements Runnable{
    private Panel panel;
    private TrainGUI gui;
    private Thread thread;
    private Player player;
    private StartMap map;
    private final int FPS = 120;
    private final int UPS = 120;
    public final static int tilesdsize = 32;
    public final static double scale = 1.5f;
    public final static int tileswidth = 26;
    public final static int tilesheight = 14;
    public final static int tilessize = (int)(tilesdsize*scale);
    public final static int gamewidth = tilessize*tileswidth;
    public final static int gameheight = tilessize*tilesheight;
    public GamePlay(){
        player = new Player(200,200);
        map = new StartMap(this, player);
        panel = new Panel(this);
        gui = new TrainGUI(panel);
        panel.requestFocusInWindow();
        thread = new Thread(this);
        thread.start();
    }
    public void update(){
        player.update();
        map.update();
    }
    public void render(Graphics g){
        map.render(g);
        player.render(g);
    }
    public Player getPlayer() {
        return player;
    }

    @Override
    public void run() {
        double tpf = (double) 1000000000/FPS;
        double upf = (double) 1000000000/UPS;
        double deltaU = 0, deltaF = 0;
        double previous = System.nanoTime();
        while (true){
            double current = System.nanoTime();
            deltaU += (current - previous)/upf;
            deltaF += (current - previous)/tpf;
            previous = current;
            if(deltaU >= 1){
                update();
                deltaU--;
            }
            if(deltaF >= 1){
                panel.repaint();
                deltaF--;
            }
        }
    }
}
