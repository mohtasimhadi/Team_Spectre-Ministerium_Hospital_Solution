package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;

import javax.swing.*;
import java.awt.event.*;

public class AdminLogin{
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField juserid;
    private JPasswordField jpassword;
    private JComboBox jusertype;
    private LogIn logIn = new LogIn();
    private Display display = new Display("Admin Log In", contentPanel);

    public AdminLogin() {
        display.DisplayOn();

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onExit();
            }
        });

        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLogIn();
                display.DisplayOff();
            }
        });
    }

    void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from admin where ID = ? and Password = ?";

        if(logIn.onLogIn(query, juserid.getText(), encryption.Encrypt(jpassword.getText()))){
            if(jusertype.getSelectedItem().toString()=="Human Resource Management Admin"){
                new AdminHR(juserid.getText());
            }
            if(jusertype.getSelectedItem().toString()=="Administrative Director"){
                new AdministrativeDirector(juserid.getText());
            }
        } else {
            new AdminLogin();
        }
    }

    /*void onLogIn() throws NoSuchAlgorithmException {
        Encryption encryption = new Encryption();
        String userid = juserid.getText();
        String password = encryption.Encrypt(jpassword.getText());
        String usertype = jusertype.getSelectedItem().toString();

        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "select * from admin where ID = ? and Password = ? and Designation = ?";
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.preparedStatement.setString(2,password);
            sqlConnector.preparedStatement.setString(3, usertype);

            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                if(usertype=="Human Resource Management Admin"){
                    AdminHR adminHR = new AdminHR(userid);
                }
                if(usertype=="Administrative Director"){
                    AdministrativeDirector administrativeDirector = new AdministrativeDirector(userid);
                }
            }
            else {
                JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
                AdminLogin adminLogin = new AdminLogin();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

    void onExit(){
        System.exit(0);
    }

    public static void main(String[] args){
        AdminLogin adminLogin = new AdminLogin();
    }
}
