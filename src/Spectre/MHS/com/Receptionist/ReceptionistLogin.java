package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import javax.swing.*;

public class ReceptionistLogin {

    private JTextField userid;
    private JPasswordField password;
    private JButton exitButton;
    private JButton logInButton;
    private JPanel contentPanel;
    private final LogIn logIn = new LogIn();
    private final Display display = new Display("Receptionist Log In", contentPanel);

    ReceptionistLogin(){
        display.DisplayOn();
        exitButton.addActionListener(e -> onExit());
        logInButton.addActionListener(e -> {
            onLogIn();
            display.DisplayOff();
        });
    }

    void onExit(){
        System.exit(0);
    }

    void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from receptionist where ID = ? and Password = ?";

        if(logIn.onLogIn(query, userid.getText(), encryption.encrypt(password.getText()))){
            new ReceptionistRange(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new ReceptionistLogin();
        }
    }
        public static void main (String[]args){
            new ReceptionistLogin();
        }
}