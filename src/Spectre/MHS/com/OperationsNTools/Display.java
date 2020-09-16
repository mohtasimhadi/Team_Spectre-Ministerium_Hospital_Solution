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

    public void changeSize(int height, int width){
        jFrame.setSize(width, height);
    }

    public void displayOn(){
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add((Component) contentPanel);
    }

    public void displayOff(){
        jFrame.setVisible(false);
    }
}
