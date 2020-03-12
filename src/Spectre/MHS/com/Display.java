package Spectre.MHS.com;

import javax.swing.*;

public class Display {

    JFrame jFrame = new JFrame();
    public Display(String title){
        JFrame jFrame = new JFrame(title);
        this.jFrame = jFrame;
    }

    void DisplayOn(JPanel contentPanel){
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
