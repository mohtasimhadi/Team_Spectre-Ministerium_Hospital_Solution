package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;

import javax.swing.*;
import java.awt.event.*;

public class DoctorLogin{
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField juserid;
    private JPasswordField jpassword;
    private LogIn logIn = new LogIn();


    Display display = new Display("Doctor Log In", contentPanel);

    public DoctorLogin() {
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

    void onExit(){
        System.exit(0);
    }

    void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from doctor where ID = ? and Password = ?";

        if(logIn.onLogIn(query, juserid.getText(), encryption.Encrypt(jpassword.getText()))){
            new DoctorStation(juserid.getText());
        } else {
            new DoctorLogin();
        }
    }

    /* void onLogIn() throws NoSuchAlgorithmException {
        Encryption encryption = new Encryption();
        String userid = juserid.getText();
        String password = encryption.Encrypt(jpassword.getText());

        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "select * from doctor where ID = ? and Password = ?";
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.preparedStatement.setString(2,password);

            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if(sqlConnector.resultSet.next()){
                DoctorStation doctorStation = new DoctorStation(userid);
            }
            else {
                JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
                DoctorLogin doctorLogin = new DoctorLogin();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    } */


    public static void main(String[] args){
        DoctorLogin doctorLogin = new DoctorLogin();
    }
}
