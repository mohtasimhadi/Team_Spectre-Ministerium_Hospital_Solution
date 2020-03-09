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
        setContentPane(contentPanel);
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

        contentPanel.registerKeyboardAction(new ActionListener() {
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
        DoctorLogin doctorLogin = new DoctorLogin();
        doctorLogin.pack();
        doctorLogin.setVisible(true);
    }
}
