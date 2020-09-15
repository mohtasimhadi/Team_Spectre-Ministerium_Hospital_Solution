package Spectre.MHS.com.Receptionist;

import Spectre.MHS.com.Doctor.PatientInformationDoctor;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;

import javax.swing.*;

public class PatientInformationReceptionist {
    private JButton backButton;
    private JButton viewButton;
    private JButton refreshButton;
    private JButton updateButton;
    private JPanel contentPanel;
    private JTextField patientID;
    private JLabel name;
    private JLabel age;
    private JLabel gender;
    private JLabel dateOfAdmission;
    private JLabel dateOfAppointment;
    private JLabel appointedDoctor;
    private JTextField dateOfRelease;
    private JLabel contactNo;
    private JLabel email;
    private JLabel bloodGroup;
    private JTextArea prescription;
    private JTextArea pathologyTests;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    PatientInformationReceptionist(String userid){
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
        display.displayOff();
        new ReceptionistRange(userid);
    }
    void onRefresh(){
        display.displayOff();
        new PatientInformationReceptionist(userid);
    }
    void onView(){
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        //if(())              //Rafi HELP
        patientInfo.getPatientInfoReceptionist(query, name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

    void onUpdate(){
        String query = ("UPDATE patient SET DateOfRelease = ?  WHERE ID = ?");

        Update.onUpdateReceptionist(query, patientID.getText(),dateOfRelease.getText());
    }

    public static void main(String[] args) {
        String asd = null;
        new PatientInformationReceptionist(asd);
    }
}
