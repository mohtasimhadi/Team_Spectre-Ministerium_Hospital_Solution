package Spectre.MHS.com.PatientInformation;
import Spectre.MHS.com.OperationsNTools.DatePicker;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Lists.DoctorList;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;
import Spectre.MHS.com.UserProfile.DoctorStation;

import javax.swing.*;

public class PatientInformationDoctor {

    private JPanel contentPanel;
    private JTextField patientID, doctorReferID;
    private JTextArea prescription, pathologyTests;
    private JButton backButton, updateButton, viewDoctors, refreshButton, viewButton, referButton;
    private JLabel name, age, gender, bloodGroup, contactNo, email;
    private DatePicker dateOfRelease, dateOfNewAppointment, dateOfAdmission, dateOfAppointment;
    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationDoctor(String userid) {
        this.userid = userid;
        doctorReferID.setEditable(false);

        buttonVisibility(false);

        backButton.addActionListener(e -> onBack());
        refreshButton.addActionListener(e -> onRefresh());
        viewButton.addActionListener(e -> onView());
        updateButton.addActionListener(e -> onUpdate());
        viewDoctors.addActionListener(e -> new DoctorList(doctorReferID));
        referButton.addActionListener(e -> onRefer());
        display.displayOn();
    }

    private void onRefer(){
         String query = ("UPDATE Patient SET AppointedDoctor = ?, DateOfAppointment =? WHERE ID = ?");
         Update.onRefer(query, patientID.getText(),doctorReferID.getText(), dateOfNewAppointment.getText());
    }

    private void onBack() {
        new DoctorStation(userid);
        display.displayOff();
    }

    private void onRefresh() {
        new PatientInformationDoctor(userid);
        display.displayOff();
    }

    private void onView() {
        if(patientID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Enter a Patient ID");
            return;
        }
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID=" + patientID);
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.getPatientInfoDoctor(query, name, age, gender, dateOfAdmission, dateOfAppointment, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
        buttonVisibility(true);
    }

    private void onUpdate() {
        String query = ("UPDATE Patient SET DateOfRelease = ?, PathologyTests = ?, Prescription = ?  WHERE ID = ?");
        Update.onUpdateDoctor(query, patientID.getText(), dateOfRelease.getText(), pathologyTests.getText(), prescription.getText());
    }

    private void buttonVisibility(Boolean bool){
        viewDoctors.setEnabled(bool);
        referButton.setEnabled(bool);
        updateButton.setEnabled(bool);
    }
}