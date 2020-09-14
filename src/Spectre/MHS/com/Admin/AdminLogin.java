package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import javax.swing.*;
import java.util.Arrays;
import java.util.Objects;

public class AdminLogin{
    private JPanel contentPanel;
    private JButton logInButton;
    private JButton exitButton;
    private JTextField userid;
    private JPasswordField password;
    private JComboBox usertype;
    private final LogIn logIn = new LogIn();
    private final Display display = new Display("Admin Log In", contentPanel);

    public AdminLogin() {
        display.displayOn();

        exitButton.addActionListener(e -> onExit());

        logInButton.addActionListener(e -> {
            onLogIn();
            display.displayOff();
        });
    }

    void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from admin where ID = ? and Password = ?";

        if(logIn.onLogIn(query, userid.getText(), encryption.encrypt(Arrays.toString(password.getPassword())))){
            if(Objects.requireNonNull(usertype.getSelectedItem()).toString().equals("Human Resource Management Admin")){
                new AdminHR(userid.getText());
            }
            if(usertype.getSelectedItem().toString().equals("Administrative Director")){
                new AdministrativeDirector(userid.getText());
            }
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
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
        new AdminLogin();
    }
}
