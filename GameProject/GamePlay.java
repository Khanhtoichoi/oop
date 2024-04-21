package OOP.GameProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GamePlay {
    private Panel panel;
    private TrainGUI gui;
    public GamePlay(){
        panel = new Panel();
        gui = new TrainGUI(panel);
        panel.requestFocusInWindow();
    }
}
