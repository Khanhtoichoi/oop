package OOP.GameProject;

import java.awt.*;

public class GamePlay implements Runnable{
    private Panel panel;
    private TrainGUI gui;
    private Thread thread;
    private Player player;
    private final int FPS = 120;
    private final int UPS = 120;
    public GamePlay(){
        player = new Player(200,200);
        panel = new Panel(this);
        gui = new TrainGUI(panel);
        panel.requestFocusInWindow();
        thread = new Thread(this);
        thread.start();
    }
    public void update(){
        player.update();
    }
    public void render(Graphics g){
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
