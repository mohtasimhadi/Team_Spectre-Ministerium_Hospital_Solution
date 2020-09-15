package Spectre.MHS.com.Admin;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import Spectre.MHS.com.OperationsNTools.Update;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;

public class ViewEmployee {
    private JPanel contentPanel;
    private JButton backButton, viewEmployeeButton, updateInformationButton, removeEmployeeButton;
    private JTextField userID, name, dateOfBirth, address, contactNo, email, joiningDate, educationQualification;
    private JComboBox gender, bloodGroup;
    private JLabel designation;
    private String userid;
    private final Display display = new Display("View Employee", contentPanel);
    SQLConnector sqlConnector;

    public ViewEmployee(String userid, String usertype){
        this.userid = userid;
        display.displayOn();

        sqlConnector = new SQLConnector();
        sqlConnector.connect();

        backButton.addActionListener(e -> onBackButton(usertype));
        removeEmployeeButton.addActionListener(e -> onRemoveEmployeeButton());
        updateInformationButton.addActionListener(e -> onUpdateInformationButton());
        viewEmployeeButton.addActionListener(e -> onViewEmployeeButton());
    }

    void runDML(String query){
        try {
            sqlConnector.statement = sqlConnector.connection.createStatement();
            sqlConnector.statement.executeUpdate(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void onRemoveEmployeeButton(){
        runDML("DELETE FROM doctor WHERE ID = " + userID.getText());
        runDML("DELETE FROM admin WHERE ID = " + userID.getText());
        runDML("DELETE FROM pathologist WHERE ID = " + userID.getText());
        runDML("DELETE FROM receptionist WHERE ID = " + userID.getText());
    }

    void onUpdateInformationButton(){
        runUpdate("admin");
        runUpdate("doctor");
        runUpdate("pathologist");
        runUpdate("receptionist");
    }

    void runUpdate(String table){
        String query = ("UPDATE "+table+" SET Name = ?, DateOfBirth = ?, Address = ?, ContactNo = ?, Email = ?, Gender = ?, EducationQualification = ?, Designation = ?, BloodGroup = ?, DateOfJoin = ?  WHERE ID = ?");
        Update.onUpdateHR(query, userID.getText(), name.getText(), dateOfBirth.getText(), address.getText(), contactNo.getText(), email.getText(), Objects.requireNonNull(gender.getSelectedItem()).toString(), educationQualification.getText(), designation.getText(), Objects.requireNonNull(bloodGroup.getSelectedItem()).toString(), joiningDate.getText());
    }

    void onViewEmployeeButton(){
        String query = "SELECT * FROM doctor WHERE ID = " + userID.getText() +
                " UNION SELECT * FROM pathologist WHERE ID = " + userID.getText() +
                " UNION SELECT * FROM receptionist WHERE ID = " + userID.getText() +
                " UNION SELECT * FROM admin WHERE ID = " + userID.getText();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
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

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    void onBackButton(String usertype){
        if(usertype.equals("Human Resource Management Admin")){
            new AdminHR(userid);
        } else {
            new AdministrativeDirector(userid);
        }
        display.displayOff();
    }

    public static void main(String[] args) {
        ViewEmployee v = new ViewEmployee("asd", "asd");
        Display d = new Display("tit", v.contentPanel);
    }

}
