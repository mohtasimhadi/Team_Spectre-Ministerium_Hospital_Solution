package Spectre.MHS.com.OperationsNTools;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePicker{

    JPanel contentPanel;
    JXDatePicker picker;

    public DatePicker(){
        picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("yyyy-mm-dd"));
        contentPanel = new JPanel();
        contentPanel.add(picker);
    }



    public String getDate(){
        Date date = picker.getDate();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static void main(String[] args) {
        DatePicker d = new DatePicker();
        Display a = new Display("ASD", d.contentPanel);
        a.displayOn();
        System.out.println(d.getDate());
    }
}
