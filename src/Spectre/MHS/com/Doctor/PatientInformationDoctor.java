package Spectre.MHS.com.Doctor;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;

import javax.swing.*;

public class PatientInformationDoctor {

    private JPanel contentPanel;
    private JTextField patientID;
    private JTextArea prescription;
    private JTextArea pathologyTests;
    private JTextField dateOfRelease;
    private JButton backButton, updateButton, referButton, refreshButton, viewButton;
    private JLabel name, age, gender, dateOfAdmission, dateOfAppointment, bloodGroup, contactNo, email;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationDoctor(String userid) {
        this.userid = userid;
        display.displayOn();

        backButton.addActionListener(e -> {
            onBack();
            display.displayOff();
        });

        refreshButton.addActionListener(e -> {
            onRefresh();
        });

        viewButton.addActionListener(e -> {
            onView();

        });

        updateButton.addActionListener(e -> {
            onUpdate();

        });
    }

    void onBack(){
        new DoctorStation(userid);
    }

    void onRefresh(){
        display.displayOff();
        new PatientInformationDoctor(userid);
    }

    void onView(){
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        //if(())              //Rafi HELP
        patientInfo.getPatientInfoDoctor(query, name, age, gender, dateOfAdmission, dateOfAppointment, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

    void onUpdate(){
        String patientID = this.patientID.getText();
        String dateOfRelease = this.dateOfRelease.getText();
        String prescription= this.prescription.getText();
        String pathologyTests= this.pathologyTests.getText();
        PatientInfo patientInfo = new PatientInfo();
        String query = ("UPDATE patient SET DateOfRelease ='"+dateOfRelease+ "', Prescription ='"+prescription+"', PathologyTests ='"+pathologyTests+"' WHERE ID ="+patientID);
        //if(())              //Rafi HELP
        patientInfo.updatePatientInfo(query);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }
}
