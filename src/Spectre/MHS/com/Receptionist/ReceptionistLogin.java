package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.MainLogin;
import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import javax.swing.*;
import java.util.Arrays;

public class ReceptionistLogin {

    private JTextField userid;
    private JPanel contentPanel;
    private JPasswordField password;
    private JButton backButton, logInButton;

    private final LogIn logIn = new LogIn();
    private final Display display = new Display("Receptionist Log In", contentPanel);

    public ReceptionistLogin(){
        display.displayOn();
        backButton.addActionListener(e -> onBack());
        logInButton.addActionListener(e -> onLogIn());
    }

    private void onBack(){
        display.displayOff();
        new MainLogin();
    }

    private void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from receptionist where ID = ? and Password = ?";

        if(logIn.onLogIn(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            new ReceptionistRange(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new ReceptionistLogin();
        }
        display.displayOff();
    }
}