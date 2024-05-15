package OOP.GameProject;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import static OOP.GameProject.Dir.stand;

public class TrainGUI {
    private JFrame frame;
    private JButton button;
    public TrainGUI(Panel panel, Lapanel lapanel) {
        frame = new JFrame();
        frame.setTitle("Pip Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setResizable(false);
        frame.repaint();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {

            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                panel.getGame().getPlayer().setAction(stand);
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
