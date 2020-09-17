package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.MainLogin;
import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import javax.swing.*;
import java.util.Arrays;

public class DoctorLogin{
    private JTextField userid;
    private JPanel contentPanel;
    private JPasswordField password;
    private JButton logInButton, backButton;
    private final LogIn logIn = new LogIn();

    Display display = new Display("Doctor Log In", contentPanel);

    public DoctorLogin() {
        backButton.addActionListener(e -> onBack());
        logInButton.addActionListener(e -> onLogIn());
        display.displayOn();
    }

    private void onBack(){
        new MainLogin();
        display.displayOff();
    }

    private void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from doctor where ID = ? and Password = ?";

        if(logIn.onLogIn(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            new DoctorStation(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new DoctorLogin();
        }
        display.displayOff();
    }
}
