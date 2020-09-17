package Spectre.MHS.com.LogIn;

import Spectre.MHS.com.Home;
import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Tools.Encryption;
import Spectre.MHS.com.UserProfile.ReceptionistRange;

import javax.swing.*;
import java.util.Arrays;

public class ReceptionistLogin extends LogIn{

    private JTextField userid;
    private JPanel contentPanel;
    private JPasswordField password;
    private JButton backButton, logInButton;
    private final Display display = new Display("Receptionist Log In", contentPanel);

    public ReceptionistLogin(){
        backButton.addActionListener(e -> onBack());
        logInButton.addActionListener(e -> onLogIn());
        display.displayOn();
    }

    private void onBack(){
        new Home();
        display.displayOff();
    }

    private void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from receptionist where ID = ? and Password = ?";

        if(passwordMatch(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            new ReceptionistRange(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new ReceptionistLogin();
        }
        display.displayOff();
    }
}