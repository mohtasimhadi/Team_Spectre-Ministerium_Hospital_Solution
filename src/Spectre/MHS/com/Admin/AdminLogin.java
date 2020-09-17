package Spectre.MHS.com.Admin;

import Spectre.MHS.com.MainLogin;
import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;

import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class AdminLogin{
    private JPanel contentPanel;
    private JButton logInButton, backButton;
    private JTextField userid;
    private JPasswordField password;
    private JComboBox<String> usertype;
    private final LogIn logIn = new LogIn();
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
        if(logIn.onLogIn(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            if(Objects.requireNonNull(usertype.getSelectedItem()).toString().equals("Human Resource Management Admin")){
                if(logIn.userTypeFound.equals("Human Resource Management Admin"))
                    logIntoHRAdmin();
                else
                    wrongTypeMessage();
            }
            else {
                if(logIn.userTypeFound.equals("Administrative Director"))
                    logIntoAdministrativeAdmin();
                else
                    wrongTypeMessage();
            }
        } else
            wrongUserNameOrPasswordMessage();
        display.displayOff();
    }

    void onBack(){
        new MainLogin();
        display.displayOff();
    }
}