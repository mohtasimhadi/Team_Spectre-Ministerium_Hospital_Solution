package Spectre.MHS.com.Doctor;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import java.util.Vector;

public class DoctorList {
    private JPanel contentPanel;
    private JButton backButton;
    private JButton referButton;
    private JTextField doctorID;
    private JPanel doctorListDB;
    private JTable doctorTable;

    public String userid;
    private final Display display = new Display("Doctor List", contentPanel);

    public DoctorList(String userid){
        this.userid=userid;
        display.displayOn();
        Vector v2 = new Vector(2);
        SQLConnector sqlConnector = new SQLConnector();
        sqlConnector.connect();

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement("SELECT ID, Name FROM Doctor");
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
            Vector v = new Vector();

            while (sqlConnector.resultSet.next()){
                v.add(sqlConnector.resultSet.getInt(1));
                v.add(sqlConnector.resultSet.getString(2));
            }
            JTable table = new JTable(v,v2);
            doctorTable = table;
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
