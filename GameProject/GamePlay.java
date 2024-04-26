package OOP.GameProject;
public class GamePlay implements Runnable{
    private Panel panel;
    private TrainGUI gui;
    private Thread thread;
    private final int FPS = 120;
    public GamePlay(){
        thread = new Thread(this);
        panel = new Panel();
        gui = new TrainGUI(panel);
        panel.requestFocusInWindow();
        thread.start();
    }

    @Override
    public void run() {
        double tpf = (double) 1000000000/FPS;
        double now = System.nanoTime();
        double lastframe = System.nanoTime();
        while (true){
            now = System.nanoTime();
            if(now - lastframe >= tpf){
                panel.repaint();
                lastframe = now;
            }
        }
    }
}
