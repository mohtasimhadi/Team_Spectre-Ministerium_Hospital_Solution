package Spectre.MHS.com;

import javax.swing.*;

public class Display {
    private JFrame jFrame;
    private JPanel contentPanel;

    public Display(String title, JPanel contentPanel){
        JFrame jFrame = new JFrame(title);
        this.jFrame = jFrame;
        this.contentPanel = contentPanel;
    }

    void DisplayOn(){
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);
    }

    void DisplayOff(){
        jFrame.setVisible(false);
    }
}
