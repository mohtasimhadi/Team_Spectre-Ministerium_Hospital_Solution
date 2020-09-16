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
        display.displayOn();

        backButton.addActionListener(e -> {
            onBack();
            display.displayOff();
        });

        refreshButton.addActionListener(e -> onRefresh());

        viewButton.addActionListener(e -> onView());
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
        if(patientID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Insert ID");
        } else {
            String query = ("SELECT * FROM patient WHERE ID="+patientID.getText());
            PatientInfo patientInfo = new PatientInfo();
            patientInfo.getPatientInfoReceptionist(query, name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
        }

    }

}
