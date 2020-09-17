package Spectre.MHS.com.PatientInformation;

import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Tools.Update;
import Spectre.MHS.com.UserProfile.PathologistLocale;

import javax.swing.*;

public class PatientInformationPathologist extends PatientInformation{

    private JPanel contentPanel;
    private JTextField patientID;
    private JTextArea pathologyTests;
    private JLabel name, age, gender, bloodGroup;
    private JButton backButton, updateButton, refreshButton, viewButton;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationPathologist(String userid) {
        this.userid = userid;
        backButton.addActionListener(e -> onBack());
        refreshButton.addActionListener(e -> onRefresh());
        viewButton.addActionListener(e -> onView());
        updateButton.addActionListener(e -> onUpdate());
        display.displayOn();
    }

    private void onBack(){
        new PathologistLocale(userid);
        display.displayOff();
    }

    private void onRefresh(){
        new PatientInformationPathologist(userid);
        display.displayOff();
    }

    private void onView(){
        if(patientID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Insert ID");
            return;
        }
        String query = ("SELECT * FROM patient WHERE ID="+patientID.getText());
        new PatientInformation().getPatientInfoPathologist(query, name, age, gender, bloodGroup, pathologyTests);
    }

    private void onUpdate(){
        String query = ("UPDATE patient SET PathologyTests = ?  WHERE ID = ?");
        Update.onUpdatePathologist(query, patientID.getText(),pathologyTests.getText());
        onRefresh();
    }
}
