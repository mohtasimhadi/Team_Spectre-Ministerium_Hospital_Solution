package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.*;

public class DoctorLogin extends JFrame {
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField userid;
    private JPasswordField password;

    public DoctorLogin() {

        JFrame jFrame = new JFrame("Doctor Log In");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(1280, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(contentPanel);

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
        DoctorLogin doctorLogin = new DoctorLogin();
    }
}
