package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.DatePicker;
import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import Spectre.MHS.com.OperationsNTools.Update;
import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;

public class ViewEmployee {
    private JPanel contentPanel;
    private JButton backButton, viewEmployeeButton, updateInformationButton, removeEmployeeButton;
    private JTextField userID, name, address, contactNo, email, educationQualification;
    private JComboBox<String> gender, bloodGroup;
    private JLabel designation;
    private JButton refreshButton;
    private DatePicker dateOfBirth, joiningDate;
    private final String userid, userType;
    private final Display display = new Display("View Employee", contentPanel);
    SQLConnector sqlConnector;

    public ViewEmployee(String userid, String usertype){
        this.userid = userid;
        this.userType = usertype;

        sqlConnector = new SQLConnector();
        //sqlConnector.connect();

        updateAndDeleteButtonVisibility(false);

        gender.setSelectedItem(null);
        bloodGroup.setSelectedItem(null);

        backButton.addActionListener(e -> onBackButton(usertype));
        removeEmployeeButton.addActionListener(e -> onRemoveEmployeeButton());
        updateInformationButton.addActionListener(e -> onUpdateInformationButton());
        viewEmployeeButton.addActionListener(e -> onViewEmployeeButton());
        refreshButton.addActionListener(e -> onRefresh());

        display.displayOn();
    }

    private void onRefresh(){
        new ViewEmployee(userid, userType);
        display.displayOff();
    }

    private void onRemoveEmployeeButton(){
        runDML("DELETE FROM doctor WHERE ID = " + userID.getText());
        runDML("DELETE FROM admin WHERE ID = " + userID.getText());
        runDML("DELETE FROM pathologist WHERE ID = " + userID.getText());
        runDML("DELETE FROM receptionist WHERE ID = " + userID.getText());
        JOptionPane.showMessageDialog(null, "Employee Removed");
        onRefresh();
    }

    private void onUpdateInformationButton(){
        runUpdate("admin");
        runUpdate("doctor");
        runUpdate("pathologist");
        runUpdate("receptionist");
        JOptionPane.showMessageDialog(null, "Updated");
    }

    private void runUpdate(String table){
        String query = ("UPDATE "+table+" SET Name = ?, DateOfBirth = ?, Address = ?, ContactNo = ?, Email = ?, Gender = ?, EducationQualification = ?, Designation = ?, BloodGroup = ?, DateOfJoin = ?  WHERE ID = ?");
        Update.onUpdateHR(query, userID.getText(), name.getText(), dateOfBirth.getText(), address.getText(), contactNo.getText(), email.getText(), Objects.requireNonNull(gender.getSelectedItem()).toString(), educationQualification.getText(), designation.getText(), Objects.requireNonNull(bloodGroup.getSelectedItem()).toString(), joiningDate.getText());
    }

    private void runDML(String query){
        try {
            sqlConnector.statement = sqlConnector.connection.createStatement();
            sqlConnector.statement.executeUpdate(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private void onViewEmployeeButton(){
        if(userID.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Insert ID");
        } else {

            String query = "SELECT * FROM doctor WHERE ID = " + userID.getText() +
                    " UNION SELECT * FROM pathologist WHERE ID = " + userID.getText() +
                    " UNION SELECT * FROM receptionist WHERE ID = " + userID.getText() +
                    " UNION SELECT * FROM admin WHERE ID = " + userID.getText();

            try {
                sqlConnector.executeQuery(query, false);
                if(!sqlConnector.resultSet.next()){
                    JOptionPane.showMessageDialog(null, "Employee does not Exist");
                    return;
                }
                name.setText(sqlConnector.resultSet.getString("Name"));
                dateOfBirth.setText(sqlConnector.resultSet.getString("DateOfBirth"));
                address.setText(sqlConnector.resultSet.getString("Address"));
                contactNo.setText(sqlConnector.resultSet.getString("ContactNo"));
                gender.setSelectedItem(sqlConnector.resultSet.getString("Gender"));
                email.setText(sqlConnector.resultSet.getString("email"));
                educationQualification.setText(sqlConnector.resultSet.getString("educationQualification"));
                bloodGroup.setSelectedItem(sqlConnector.resultSet.getString("BloodGroup"));
                designation.setText(sqlConnector.resultSet.getString("Designation"));
                joiningDate.setText(sqlConnector.resultSet.getString("DateOfJoin"));
                updateAndDeleteButtonVisibility(true);
            } catch (SQLException | ParseException e){
                e.printStackTrace();
            }
        }
    }

    private void updateAndDeleteButtonVisibility(Boolean bool){
        removeEmployeeButton.setEnabled(bool);
        updateInformationButton.setEnabled(bool);
    }
    private void onBackButton(String usertype){
        if(usertype.equals("Human Resource Management Admin")){
            new AdminHR(userid);
        } else {
            new AdministrativeDirector(userid);
        }
        display.displayOff();
    }
}
