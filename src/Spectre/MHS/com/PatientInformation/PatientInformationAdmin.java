package Spectre.MHS.com.PatientInformation;

import Spectre.MHS.com.OperationsNTools.DatePicker;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.UserProfile.AdministrativeDirector;

import javax.swing.*;

public class PatientInformationAdmin {

    private JPanel contentPanel;
    private JTextField patientID;
    private JTextArea prescription, pathologyTests;
    private JButton backButton, viewButton, refreshButton;
    private JLabel name, age, gender, appointedDoctor, contactNo, email, bloodGroup;
    private DatePicker dateOfAdmission, dateOfAppointment, dateOfRelease;

    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationAdmin(String userid){
        this.userid = userid;
        backButton.addActionListener(e -> onBack());
        refreshButton.addActionListener(e -> onRefresh());
        viewButton.addActionListener(e -> onView());
        display.displayOn();
    }

    private void onBack(){
        new AdministrativeDirector(userid);
        display.displayOff();
    }

    private void onRefresh(){
        new PatientInformationAdmin(userid);
        display.displayOff();
    }
    
    private void onView(){
        if(patientID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Insert ID");
        } else {
            String query = ("SELECT * FROM patient WHERE ID="+patientID.getText());
            PatientInfo patientInfo = new PatientInfo();
            patientInfo.getPatientInfoReceptionist(query, name, age, gender, dateOfAdmission, dateOfAppointment, appointedDoctor, dateOfRelease, contactNo, email, bloodGroup, prescription, pathologyTests);
        }
    }
}
