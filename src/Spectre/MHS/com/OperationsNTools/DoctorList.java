package Spectre.MHS.com.OperationsNTools;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorList {
    private JTable Table;
    private JScrollPane contentPanel;
    SQLConnector sqlConnector;

    DoctorList(){
        sqlConnector = new SQLConnector();
        sqlConnector.connect();

        String query = "SELECT ID, NAME, DESIGNATION FROM DOCTOR";

        try {
            sqlConnector.preparedStatement = sqlConnector.connection.prepareStatement(query);
            sqlConnector.resultSet = sqlConnector.preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String data[][] = getStringData(sqlConnector.resultSet);
        String columnNames[] = {"ID", "Name", "Designation"};
        Table = new JTable(data , columnNames);
        contentPanel = new JScrollPane(Table);
    }

    int getNumberOfRows(ResultSet resultSet){
        int i = 0;
        try {
            while (resultSet.next()){
                i++;
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return i;
    }

    String[][] getStringData(ResultSet resultSet){
        int rows = getNumberOfRows(resultSet);
        String data[][] = new String[rows][3];
        try {
            resultSet.beforeFirst();
            int rowNum = 0;
            while (resultSet.next()){
                String eachRow[] = new String[3];
                for(int i=1; i<=3; i++){
                    eachRow[i-1] = resultSet.getString(i);
                }
                data[rowNum] = eachRow;
                rowNum++;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        DoctorList d = new DoctorList();
        JFrame jf = new JFrame("title");
        jf.setSize(720, 650);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(d.contentPanel);
        jf.setVisible(true);
    }
}
