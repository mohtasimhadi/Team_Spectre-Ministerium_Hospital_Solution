package Spectre.MHS.com.LogIn;

import Spectre.MHS.com.UserProfile.DoctorStation;
import Spectre.MHS.com.Home;
import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Tools.Encryption;
import javax.swing.*;
import java.util.Arrays;

public class DoctorLogin extends LogIn{
    private JTextField userid;
    private JPanel contentPanel;
    private JPasswordField password;
    private JButton logInButton, backButton;

    Display display = new Display("Doctor Log In", contentPanel);

    public DoctorLogin() {
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
        String query = "select * from doctor where ID = ? and Password = ?";

        if(passwordMatch(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            new DoctorStation(userid.getText());
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
            new DoctorLogin();
        }
        display.displayOff();
    }
}
