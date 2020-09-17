package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.awt.*;

public class Display {
    private final JFrame jFrame;
    private final Object contentPanel;
    public Display(String title, Object contentPanel){
        this.jFrame = new JFrame(title);
        this.contentPanel = contentPanel;
    }

    public void displayDialogueBox(int height, int width){
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.add((Component) contentPanel);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void displayOn(){
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add((Component) contentPanel);
    }

    public void displayOff(){
        jFrame.dispose();
    }
}
