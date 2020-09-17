package Spectre.MHS.com.LogIn;

import Spectre.MHS.com.UserProfile.AdminHR;
import Spectre.MHS.com.UserProfile.AdministrativeDirector;
import Spectre.MHS.com.Home;
import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Tools.Encryption;
import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class AdminLogin extends LogIn{
    private JPanel contentPanel;
    private JButton logInButton, backButton;
    private JTextField userid;
    private JPasswordField password;
    private JComboBox<String> usertype;
    private final Display display = new Display("Admin Log In", contentPanel);

    public AdminLogin() {
        usertype.setSelectedItem(null);
        backButton.addActionListener(e -> onBack());
        logInButton.addActionListener(e -> onLogIn());
        display.displayOn();
    }

    private void wrongTypeMessage(){
        JOptionPane.showMessageDialog(null, "Wrong User Type");
        display.displayOff();
        new AdminLogin();
    }

    private void wrongUserNameOrPasswordMessage(){
        JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
        display.displayOff();
        new AdminLogin();
    }

    private void logIntoHRAdmin(){
        new AdminHR(userid.getText());
        display.displayOff();
    }

    private void logIntoAdministrativeAdmin(){
        new AdministrativeDirector(userid.getText());
        display.displayOff();
    }

    private void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from admin where ID = ? and Password = ?";
        if(usertype.getSelectedItem() == null){
            wrongTypeMessage();
            return;
        }
        if(passwordMatch(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            if(Objects.requireNonNull(usertype.getSelectedItem()).toString().equals("Human Resource Management Admin")){
                if(userTypeFound.equals("Human Resource Management Admin"))
                    logIntoHRAdmin();
                else
                    wrongTypeMessage();
            }
            else {
                if(userTypeFound.equals("Administrative Director"))
                    logIntoAdministrativeAdmin();
                else
                    wrongTypeMessage();
            }
        } else
            wrongUserNameOrPasswordMessage();
        display.displayOff();
    }

    void onBack(){
        new Home();
        display.displayOff();
    }
}