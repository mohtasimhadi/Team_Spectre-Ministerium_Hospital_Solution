package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;
import javax.swing.*;

public class PatientInformationPathologist {

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
        new PatientInfo().getPatientInfoPathologist(query, name, age, gender, bloodGroup, pathologyTests);
    }

    private void onUpdate(){
        String query = ("UPDATE patient SET PathologyTests = ?  WHERE ID = ?");
        Update.onUpdatePathologist(query, patientID.getText(),pathologyTests.getText());
        onRefresh();
    }
}
