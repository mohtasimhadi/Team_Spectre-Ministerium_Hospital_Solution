package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;

import javax.swing.*;

public class PatientInformationAdmin {

    private JPanel contentPanel;
    private JTextField patientID, dateOfRelease;
    private JTextArea prescription, pathologyTests;
    private JButton backButton, viewButton, refreshButton;
    private JLabel name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, contactNo, email, bloodGroup;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

     public PatientInformationAdmin(String userid){
        this.userid = userid;
        display.displayOff();

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
    }

    void onBack(){
        display.displayOff();
        new AdministrativeDirector(userid);
    }

    void onRefresh(){
        display.displayOff();
        new PatientInformationAdmin(userid);
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

}
