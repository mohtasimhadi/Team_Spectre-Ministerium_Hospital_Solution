package Spectre.MHS.com.Doctor;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.Lists.DoctorList;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;

import javax.swing.*;

public class PatientInformationDoctor {

    private JPanel contentPanel;
    private JTextField patientID, dateOfRelease, doctorReferID, dateOfNewAppointment;
    private JTextArea prescription, pathologyTests;
    private JButton backButton, updateButton, viewDoctors, refreshButton, viewButton, referButton;
    private JLabel name, age, gender, dateOfAdmission, dateOfAppointment, bloodGroup, contactNo, email;
    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationDoctor(String userid) {
        this.userid = userid;
        display.displayOn();
        doctorReferID.setEditable(false);

        buttonVisibility(false);

        backButton.addActionListener(e -> onBack());
        refreshButton.addActionListener(e -> onRefresh());
        viewButton.addActionListener(e -> onView());
        updateButton.addActionListener(e -> onUpdate());
        viewDoctors.addActionListener(e -> new DoctorList(doctorReferID));
        referButton.addActionListener(e -> onRefer());
    }

    void onRefer(){
         String query = ("UPDATE Patient SET AppointedDoctor = ?, DateOfAppointment =? WHERE ID = ?");
         Update.onRefer(query, patientID.getText(),doctorReferID.getText(), dateOfNewAppointment.getText());
    }

    void onBack() {
        new DoctorStation(userid);
        display.displayOff();
    }

    void onRefresh() {
        display.displayOff();
        new PatientInformationDoctor(userid);
    }

    void onView() {
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

    void onUpdate() {
        String query = ("UPDATE Patient SET DateOfRelease = ?, PathologyTests = ?, Prescription = ?  WHERE ID = ?");
        Update.onUpdateDoctor(query, patientID.getText(), dateOfRelease.getText(), pathologyTests.getText(), prescription.getText());
    }

    private void buttonVisibility(Boolean bool){
        viewDoctors.setEnabled(bool);
        referButton.setEnabled(bool);
        updateButton.setEnabled(bool);
    }
}