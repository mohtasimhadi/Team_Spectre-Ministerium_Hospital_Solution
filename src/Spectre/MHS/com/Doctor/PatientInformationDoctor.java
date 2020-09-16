package Spectre.MHS.com.Doctor;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.DoctorList;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;

import javax.swing.*;

public class PatientInformationDoctor {

    private JPanel contentPanel;
    private JTextField patientID, dateOfRelease;
    private JTextArea prescription, pathologyTests;
    private JButton backButton, updateButton, viewDoctors, refreshButton, viewButton;
    private JLabel name, age, gender, dateOfAdmission, dateOfAppointment, bloodGroup, contactNo, email;
    private JTextField doctorReferID;
    private JButton referButton;
    private JTextField dateOfNewAppointment;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationDoctor(String userid) {
        this.userid = userid;
        display.displayOn();

        backButton.addActionListener(e -> onBack());

        refreshButton.addActionListener(e -> onRefresh());

        viewButton.addActionListener(e -> onView());

        updateButton.addActionListener(e -> onUpdate());

        viewDoctors.addActionListener(e -> onDoctorList());

        referButton.addActionListener(e -> onRefer());
    }

    void onDoctorList(){
        new DoctorList();
    }

    void onRefer(){
         String query = ("UPDATE Patient SET AppointedDoctor = ?, DateOfAppointment =? WHERE ID = ?");
         Update.onRefer(query, doctorReferID.getText(), dateOfNewAppointment.getText());
        JOptionPane.showMessageDialog(null, "Referred");
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
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID=" + patientID);
        PatientInfo patientInfo = new PatientInfo();
        patientInfo.getPatientInfoDoctor(query, name, age, gender, dateOfAdmission, dateOfAppointment, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
    }

    void onUpdate() {
        String query = ("UPDATE Patient SET DateOfRelease = ?, PathologyTests = ?, Prescription = ?  WHERE ID = ?");
        Update.onUpdateDoctor(query, patientID.getText(), dateOfRelease.getText(), pathologyTests.getText(), prescription.getText());
        JOptionPane.showMessageDialog(null, "Updated");
    }
}