package Spectre.MHS.com;

import javax.swing.*;

public class RecetionistLogin {

    private JPanel contentPane;
    private JTextField userid;
    private JPasswordField password;
    private JButton exitButton;
    private JButton logInButton;
    private JPanel ReceptionistLoginPanel;

    RecetionistLogin(){
        JFrame jf = new JFrame("Login Terminal");
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setSize(1280, 720);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(ReceptionistLoginPanel);
    }

    public static void main(String[] args) {
        new RecetionistLogin();
    }
}
