package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DoctorList {
    private JPanel contentPanel;
    private JButton backButton;
    private JButton referButton;
    private JTextField doctorID;
    private JTable table1;
    String[] columnNames = {"Doctor ID", "Name"};
    //String[][] data = {
    //        {"2001","Abal"},
    //        {"2002","Nabal"}
    //};
    DefaultTableModel model = new DefaultTableModel();

    public String userid;
    private final Display display = new Display("Doctor List", contentPanel);


    public DoctorList(String userid){
        display.displayOn();
        this.userid=userid;
        table1.setModel(model);
        table1.setFillsViewportHeight(true);
        model.addRow(columnNames);
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement("SELECT ID, Name FROM Doctor");
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();

            while (sqlConnector.resultSet.next()){
                String c[] = {sqlConnector.resultSet.getString(1),sqlConnector.resultSet.getString(2)};
            model.addRow(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        backButton.addActionListener(e -> {
            onBack();
        });

        referButton.addActionListener(e -> {
            onRefer();
        });
    }

    void onBack() {
        new PatientInformationDoctor(userid);
        display.displayOff();
    }

    void onRefer() {

    }
}
