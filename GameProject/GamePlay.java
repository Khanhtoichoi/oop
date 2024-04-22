package OOP.GameProject;
public class GamePlay {
    private Panel panel;
    private TrainGUI gui;
    public GamePlay(){
        panel = new Panel();
        gui = new TrainGUI(panel);
        panel.requestFocusInWindow();
    }
}
