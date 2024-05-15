package OOP.GameProject;

import OOP.GameProject.GameStates.*;
import OOP.GameProject.GameStates.Menu;

import java.awt.*;

public class GamePlay implements Runnable{
    private Menu menu;
    private Play play;
    private Loading loading;
    private Panel panel;
    private Lapanel lapanel;
    private TrainGUI gui;
    private Thread thread;
    private final int FPS = 120;
    private final int UPS = 120;
    public final static int gamewidth = 1248;
    public final static int gameheight = 672;
    public GamePlay(){
        panel = new Panel(this);
        lapanel = new Lapanel(this);
        menu = new Menu(this);
        play = new Play(this);
        loading = new Loading(this);
        gui = new TrainGUI(panel,lapanel);
        panel.requestFocusInWindow();
        thread = new Thread(this);
        thread.start();
    }
    public void update(){
        switch (GameState.st){
            case Menu -> menu.update();
            case Loading -> loading.update();
            case Play -> play.update();
            case Lapanel -> lapanel.update();
        }
    }
    public void render(Graphics g){
        switch (GameState.st){
            case Menu -> menu.render(g);
            case Loading -> loading.render(g);
            case Play -> play.render(g);
            case Lapanel -> lapanel.render(g);
        }
    }
    public Play getPlay() {
        return play;
    }
    public Player getPlayer(){
        return play.getPlayer();
    }

    public Menu getMenu() {
        return menu;
    }

    public Lapanel getLapanel() {
        return lapanel;
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
