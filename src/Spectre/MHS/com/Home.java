package Spectre.MHS.com;

import Spectre.MHS.com.LogIn.AdminLogin;
import Spectre.MHS.com.LogIn.DoctorLogin;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.Operations.InitialTableCreator;
import Spectre.MHS.com.LogIn.PathologistLogIn;
import Spectre.MHS.com.LogIn.ReceptionistLogin;
import javax.swing.*;
import java.util.Objects;

public class Home {
    private JPanel contentPanel;
    private JComboBox<String> loginType;
    private JButton selectButton;
    private JButton exitButton;
    private JButton initializeDatabaseButton;
    private final Display display = new Display("Ministerium Hospital Solution", contentPanel);

    public Home() {
        selectButton.addActionListener(e -> onSelectButton());
        exitButton.addActionListener(e -> onExit());
        initializeDatabaseButton.addActionListener(e -> onInitializeDatabase());
        loginType.setSelectedItem(null);
        display.displayOn();
    }

    private void onSelectButton(){
        if (loginType.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Select Designation Please");
            new Home();
            display.displayOff();
            return;
        }
        String designation = Objects.requireNonNull(loginType.getSelectedItem()).toString();
        switch (designation) {
            case "Admin":
                new AdminLogin();
                display.displayOff();
                break;
            case "Doctor":
                new DoctorLogin();
                display.displayOff();
                break;
            case "Pathologist":
                new PathologistLogIn();
                display.displayOff();
                break;
            case "Receptionist":
                new ReceptionistLogin();
                display.displayOff();
                break;
        }
    }

    private void onInitializeDatabase(){
        InitialTableCreator.createDBTable();
    }

    void onExit(){
        System.exit(0);
    }

    public static void main(String[] args){
        new Home();
    }

}
