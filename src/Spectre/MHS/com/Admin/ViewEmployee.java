package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.PersonalInfo;

import javax.swing.*;

public class ViewEmployee {
    private JPanel contentPanel;
    private JButton backButton, viewEmployeeButton, updateInformationButton, removeEmployeeButton;
    private JTextField userID, name, dateOfBirth, address,  contactNo,  Gender,  email,  designation,  bloodGroup, joiningDate;
    private String userid;
    private final Display display = new Display("View Employee", contentPanel);

    public ViewEmployee(String userid, String usertype){
        this.userid = userid;
        display.displayOn();
        backButton.addActionListener(e -> onBackButton(usertype));
        removeEmployeeButton.addActionListener(e -> onRemoveEmployeeButton());
        updateInformationButton.addActionListener(e -> onUpdateInformationButton());
        viewEmployeeButton.addActionListener(e -> onViewEmployeeButton());
    }

    void onRemoveEmployeeButton(){

    }

    void onUpdateInformationButton(){

    }

    void onViewEmployeeButton(){
        
    }

    void onBackButton(String usertype){
        if(usertype.equals("Human Resource Management Admin")){
            new AdminHR(userid);
        } else {
            new AdministrativeDirector(userid);
        }
        display.displayOff();
    }
}
