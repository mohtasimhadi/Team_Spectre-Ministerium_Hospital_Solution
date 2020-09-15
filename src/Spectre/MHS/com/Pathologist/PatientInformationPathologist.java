package Spectre.MHS.com.Pathologist;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PatientInfo;
import Spectre.MHS.com.OperationsNTools.Update;

import javax.swing.*;

public class PatientInformationPathologist {
    private JButton backButton, updateButton, refreshButton, viewButton;
    private JPanel contentPanel;
    private JTextArea pathologyTests;
    private JTextField patientID;
    private JLabel name, age, gender, bloodGroup;
    private final String userid;
    private final Display display = new Display("Patient Information", contentPanel);

    public PatientInformationPathologist(String userid) {
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
        new PathologistLocale(userid);
    }

    void onRefresh(){
        display.displayOff();
        new PatientInformationPathologist(userid);
    }

    void onView(){
        String patientID = this.patientID.getText();
        String query = ("SELECT * FROM patient WHERE ID="+patientID);
        PatientInfo patientInfo = new PatientInfo();
        //if(sqlConnector.resultSet.getString(1).equals(encryption.encrypt(oldPassword)))
        //if(())              //Rafi HELP
        patientInfo.getPatientInfoPathologist(query, name, age, gender, bloodGroup, pathologyTests);
        //else
        //    JOptionPane.showMessageDialog(null, "No Patient With That ID");
    }

    void onUpdate(){
        String query = ("UPDATE patient SET PathologyTests = ? WHERE ID = ?");

        Update.onUpdate(query, patientID.getText(), pathologyTests.getText());
    }
}
