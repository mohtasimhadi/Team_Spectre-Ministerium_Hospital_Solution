package Spectre.MHS.com;

import Spectre.MHS.com.Admin.AdminLogin;
import Spectre.MHS.com.Doctor.DoctorLogin;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.Pathologist.PathologistLogIn;
import Spectre.MHS.com.Receptionist.ReceptionistLogin;
import javax.swing.*;
import java.util.Objects;

public class MainLogin {
    private JPanel contentPanel;
    private JComboBox loginType;
    private JButton selectButton;
    private JButton exitButton;
    private final Display display = new Display("Ministerium Hospital Solution", contentPanel);

    public MainLogin() {
        selectButton.addActionListener(e -> onSelectButton());
        exitButton.addActionListener(e -> onExit());
        loginType.setSelectedItem(null);
        display.displayOn();
    }

    private void onSelectButton(){
        String designation = Objects.requireNonNull(loginType.getSelectedItem()).toString();
        if (designation.equals("Admin")){
            new AdminLogin();
            display.displayOff();
        } else if (designation.equals("Doctor")){
            new DoctorLogin();
            display.displayOff();
        } else if (designation.equals("Pathologist")){
            new PathologistLogIn();
            display.displayOff();
        } else if (designation.equals("Receptionist")){
            new ReceptionistLogin();
            display.displayOff();
        } else {
            JOptionPane.showMessageDialog(null, "Select Designation Please");
        }
    }

    void onExit(){
        System.exit(0);
    }

    public static void main(String[] args){
        new MainLogin();
    }

}
