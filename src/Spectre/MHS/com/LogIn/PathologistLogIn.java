package Spectre.MHS.com.LogIn;

import Spectre.MHS.com.Home;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import Spectre.MHS.com.UserProfile.PathologistLocale;

import javax.swing.*;
import java.util.Arrays;

public class PathologistLogIn extends LogIn{
    private JTextField userid;
    private JPanel contentPanel;
    private JPasswordField password;
    private JButton logInButton, backButton;
    private final Display display = new Display("Pathologist Log In", contentPanel);

    public PathologistLogIn() {
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
        String query = "select * from pathologist where ID = ? and Password = ?";

        if(passwordMatch(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            new PathologistLocale(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new PathologistLogIn();
        }
        display.displayOff();
    }
}