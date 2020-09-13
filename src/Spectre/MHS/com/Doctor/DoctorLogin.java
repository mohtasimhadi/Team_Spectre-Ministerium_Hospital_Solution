package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;

import javax.swing.*;

public class DoctorLogin{
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField userid;
    private JPasswordField password;
    private LogIn logIn = new LogIn();


    Display display = new Display("Doctor Log In", contentPanel);

    public DoctorLogin() {
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
        String query = "select * from doctor where ID = ? and Password = ?";

        if(logIn.onLogIn(query, userid.getText(), encryption.encrypt(password.getText()))){
            new DoctorStation(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new DoctorLogin();
        }
    }

    public static void main(String[] args){
        new DoctorLogin();
    }
}
