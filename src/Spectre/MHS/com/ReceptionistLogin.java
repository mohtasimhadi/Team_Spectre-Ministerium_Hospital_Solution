package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistLogin {

    private JPanel contentPane;
    private JTextField userid;
    private JPasswordField password;
    private JButton exitButton;
    private JButton logInButton;
    private JPanel ReceptionistLoginPanel;

    ReceptionistLogin(){
        JFrame jf = new JFrame("Login Terminal");
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setSize(1280, 720);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(ReceptionistLoginPanel);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });
    }

    void onExit(){
        System.exit(0);
    }
    public static void main(String[] args) {
        new ReceptionistLogin();
    }
}
