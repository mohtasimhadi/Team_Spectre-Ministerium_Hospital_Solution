package Spectre.MHS.com;

import javax.swing.*;
import java.awt.event.*;

public class AdminLogin extends JFrame {
    private JPanel contentPane;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField userid;
    private JPasswordField password;
    private JComboBox usertype;

    public AdminLogin() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(exitButton);

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
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onExit();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    void onExit(){
        dispose();
        System.exit(0);
    }

    void onLogIn(){

    }

    public static void main(String[] args){
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.pack();
        adminLogin.setVisible(true);
    }
}
