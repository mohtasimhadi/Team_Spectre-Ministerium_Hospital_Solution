package Spectre.MHS.com.Tools.Lists;

import Spectre.MHS.com.Tools.Display;
import Spectre.MHS.com.Tools.SQLConnector;
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
}
