package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;
import javax.swing.*;

public class PatientInformationReceptionist {

    private JPanel contentPanel;
    private JTextField patientID, dateOfRelease;
    private JTextArea prescription, pathologyTests;
    private JButton backButton, viewButton, refreshButton, updateButton;
    private JLabel name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, contactNo, email, bloodGroup;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    PatientInformationReceptionist(String userid){
        this.userid = userid;
        display.displayOn();

        backButton.addActionListener(e -> onBack());
        refreshButton.addActionListener(e -> onRefresh());
        viewButton.addActionListener(e -> onView());
        updateButton.addActionListener(e -> onUpdate());
    }

    void onBack(){
        display.displayOff();
        new ReceptionistRange(userid);
    }
    void onRefresh(){
        display.displayOff();
        new PatientInformationReceptionist(userid);
    }
    void onView(){
        if(patientID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter a Patient ID");
            return;
        }
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.getPatientInfoReceptionist(query, name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
    }

    void onUpdate(){
        String query = ("UPDATE patient SET DateOfRelease = ?  WHERE ID = ?");
        Update.onUpdateReceptionist(query, patientID.getText(),dateOfRelease.getText());
    }
}
