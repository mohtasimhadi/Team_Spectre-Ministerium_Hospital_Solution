package Spectre.MHS.com.OperationsNTools.Lists;

import Spectre.MHS.com.OperationsNTools.Display;
import Spectre.MHS.com.OperationsNTools.SQLConnector;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractList{
    SQLConnector sqlConnector;
    Display display;
    String query;
    JTable table;
    JScrollPane contentPanel;

    void setQuery(String Query){
        query = Query;
    }

    void connectSQL(){
        sqlConnector = new SQLConnector();
        //sqlConnector.connect();
    }

    private int getNumberOfRows(ResultSet resultSet){
        int i = 0;
        try {
            while (resultSet.next()){
                i++;
            }
        }catch (SQLException throwable){
            throwable.printStackTrace();
        }
        return i;
    }

    String[][] getStringData(ResultSet resultSet){
        int rows = getNumberOfRows(resultSet);
        String[][] data = new String[rows][3];
        try {
            resultSet.beforeFirst();
            int rowNum = 0;
            while (resultSet.next()){
                String[] eachRow = new String[3];
                for(int i=1; i<=3; i++){
                    eachRow[i-1] = resultSet.getString(i);
                }
                data[rowNum] = eachRow;
                rowNum++;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return data;
    }

    private void onClick(JTextField field){
        int index = table.getSelectedRow();
        field.setText((String) table.getValueAt(index, 0));
        display.displayOff();
    }

    void addMouseListener(JTextField field){
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick(field);
            }
        });
        display.displayOff();
    }

}
