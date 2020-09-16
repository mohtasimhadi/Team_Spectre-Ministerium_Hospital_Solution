package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class AdminLogin{
    private JPanel contentPanel;
    private JButton logInButton, exitButton;
    private JTextField userid;
    private JPasswordField password;
    private JComboBox usertype;
    private final LogIn logIn = new LogIn();
    private final Display display = new Display("Admin Log In", contentPanel);

    public AdminLogin() {
        display.displayOn();
        usertype.setSelectedItem(null);
        exitButton.addActionListener(e -> onExit());
        logInButton.addActionListener(e -> onLogIn());
    }

    void wrongTypeMessage(){
        JOptionPane.showMessageDialog(null, "Wrong User Type");
        new AdminLogin();
    }

    void wrongUserNameOrPasswordMessage(){
        JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
        new AdminLogin();
    }

    void logIntoHRAdmin(){
        new AdminHR(userid.getText());
    }

    void logIntoAdministrativeAdmin(){
        new AdministrativeDirector(userid.getText());
    }

    void onLogIn(){
        display.displayOff();
        Encryption encryption = new Encryption();
        String query = "select * from admin where ID = ? and Password = ?";

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

    void onExit(){
        System.exit(0);
    }

    public static void main(String[] args){
        new AdminLogin();
    }
}
