package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import javax.swing.*;
import java.util.Arrays;

public class PathologistLogIn{
    private JTextField userid;
    private JPanel contentPanel;
    private JPasswordField password;
    private JButton logInButton, exitButton;
    private final LogIn logIn = new LogIn();
    private final Display display = new Display("Pathologist Log In", contentPanel);

    public PathologistLogIn() {
        display.displayOn();

        exitButton.addActionListener(e -> onExit());
        logInButton.addActionListener(e -> onLogIn());
    }

    void onExit(){
        System.exit(0);
    }

    void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from pathologist where ID = ? and Password = ?";

        if(logIn.onLogIn(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            new PathologistLocale(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new PathologistLogIn();
        }
        display.displayOff();
    }
        public static void main(String[] args){
        new PathologistLogIn();
    }
}