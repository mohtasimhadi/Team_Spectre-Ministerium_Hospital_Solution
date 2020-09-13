package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;

public class Display {
    private final JFrame jFrame;
    private final JPanel contentPanel;

    public Display(String title, JPanel contentPanel){
        this.jFrame = new JFrame(title);
        this.contentPanel = contentPanel;
    }

    public void DisplayOn(){
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);
    }

    public void DisplayOff(){
        jFrame.setVisible(false);
    }
}
