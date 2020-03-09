package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.*;

public class PathologistLogIn{
    private JPanel contentPane;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField userid;
    private JPasswordField password;
    private JComboBox usertype;

    public PathologistLogIn() {
        JFrame jFrame = new JFrame("Pathologist Log In");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPane);


        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogIn();
            }
        });
    }

    void onExit(){
        System.exit(0);
    }

    void onLogIn(){

    }

    public static void main(String[] args){
        PathologistLogIn pathologistLogIn = new PathologistLogIn();
    }
}
