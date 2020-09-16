package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import java.awt.*;

public class Display {
    private final JFrame jFrame;
    private final Object contentPanel;
    static GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public Display(String title, Object contentPanel){
        this.jFrame = new JFrame(title);
        this.contentPanel = contentPanel;
    }

    public void changeSize(int height, int width){
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void displayOn(){
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add((Component) contentPanel);
        graphicsDevice.setFullScreenWindow(jFrame);
    }

    public void displayOff(){
        jFrame.setVisible(false);
    }
}
