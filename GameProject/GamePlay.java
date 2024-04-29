package OOP.GameProject;
public class GamePlay implements Runnable{
    private Panel panel;
    private TrainGUI gui;
    private Thread thread;
    private final int FPS = 120;
    private final int UPS = 120;
    public GamePlay(){
        thread = new Thread(this);
        panel = new Panel();
        gui = new TrainGUI(panel);
        panel.requestFocusInWindow();
        thread.start();
    }
    public void update(){
        panel.updates();
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
