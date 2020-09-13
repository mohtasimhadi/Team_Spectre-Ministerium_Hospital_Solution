package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.LogIn;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Encryption;
import javax.swing.*;

public class ReceptionistLogin {

    private JTextField juserid;
    private JPasswordField jpassword;
    private JButton exitButton;
    private JButton logInButton;
    private JPanel contentPanel;
    private LogIn logIn = new LogIn();
    private Display display = new Display("Receptionist Log In", contentPanel);

    ReceptionistLogin(){
        display.DisplayOn();
        exitButton.addActionListener(e -> onExit());
        logInButton.addActionListener(e -> {
            onLogIn();
            display.DisplayOff();
        });
    }

    void onExit(){
        System.exit(0);
    }

    void onLogIn(){
        Encryption encryption = new Encryption();
        String query = "select * from receptionist where ID = ? and Password = ?";

        if(logIn.onLogIn(query, juserid.getText(), encryption.encrypt(jpassword.getText()))){
            new ReceptionistRange(juserid.getText());
        } else {
            new ReceptionistLogin();
        }
    }

/*    void onLogIn() throws NoSuchAlgorithmException {
        Encryption encryption = new Encryption();
        String userid = juserid.getText();
        String password = encryption.Encrypt(jpassword.getText());

        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            String query = "select * from receptionist where ID = ? and Password = ?";
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.preparedStatement.setString(1, userid);
            sqlConnector.preparedStatement.setString(2, password);

            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            if (sqlConnector.resultSet.next()) {
                ReceptionistRange receptionistRange = new ReceptionistRange(userid);
            } else {
                JOptionPane.showMessageDialog(contentPanel, "Username or Password didn't match");
                ReceptionistLogin receptionistLogin = new ReceptionistLogin();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
        public static void main (String[]args){
            new ReceptionistLogin();
        }
}
