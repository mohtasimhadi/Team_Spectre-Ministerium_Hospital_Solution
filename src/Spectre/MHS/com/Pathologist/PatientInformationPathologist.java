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
        display.displayOn();

        backButton.addActionListener(e -> onBack());
        refreshButton.addActionListener(e -> onRefresh());
        viewButton.addActionListener(e -> onView());
        updateButton.addActionListener(e -> onUpdate());
    }

    void onBack(){
        display.displayOff();
        new PathologistLocale(userid);
    }

    void onRefresh(){
        display.displayOff();
        new PatientInformationPathologist(userid);
    }

    void onView(){
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.getPatientInfoPathologist(query, name, age, gender, bloodGroup, pathologyTests);
    }

    void onUpdate(){
        String query = ("UPDATE patient SET PathologyTests = ?  WHERE ID = ?");
        Update.onUpdatePathologist(query, patientID.getText(),pathologyTests.getText());
        onRefresh();
    }
}
