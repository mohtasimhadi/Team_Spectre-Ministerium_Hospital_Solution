package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.OperationsNTools.DatePicker;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;
import javax.swing.*;
import java.util.Date;

public class PatientInformationReceptionist {

    private JPanel contentPanel;
    private JTextField patientID;
    private DatePicker dateOfRelease;
    private JTextArea prescription, pathologyTests;
    private JButton backButton, viewButton, refreshButton, updateButton;
    private JLabel name, age, gender, appointedDoctor, contactNo, email, bloodGroup;
    private DatePicker dateOfAdmission, dateOfAppointment;

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

    private void onBack(){
        display.displayOff();
        new ReceptionistRange(userid);
    }
    private void onRefresh(){
        display.displayOff();
        new PatientInformationReceptionist(userid);
    }
    private void onView(){
        if(patientID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter a Patient ID");
            return;
        }
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.getPatientInfoReceptionist(query, name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
    }

    private void onUpdate(){
        String query = ("UPDATE patient SET DateOfRelease = ?  WHERE ID = ?");
        Update.onUpdateReceptionist(query, patientID.getText(),dateOfRelease.getText());
    }
}
