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
        display.displayOn();
        usertype.setSelectedItem(null);
        backButton.addActionListener(e -> onBack());
        logInButton.addActionListener(e -> onLogIn());
    }

    void wrongTypeMessage(){
        JOptionPane.showMessageDialog(null, "Wrong User Type");
        display.displayOff();
        new AdminLogin();
    }

    void wrongUserNameOrPasswordMessage(){
        JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
        display.displayOff();
        new AdminLogin();
    }

    void logIntoHRAdmin(){
        display.displayOff();
        new AdminHR(userid.getText());
    }

    void logIntoAdministrativeAdmin(){
        display.displayOff();
        new AdministrativeDirector(userid.getText());
    }

    void onLogIn(){
        display.displayOff();
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
    }

    void onBack(){
        display.displayOff();
        new MainLogin();
    }
}
