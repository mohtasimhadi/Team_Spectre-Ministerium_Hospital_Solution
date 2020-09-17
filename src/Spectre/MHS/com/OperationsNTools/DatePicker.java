package Spectre.MHS.com.OperationsNTools;

import org.jdesktop.swingx.JXDatePicker;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePicker extends JPanel{

    JPanel contentPanel;
    JXDatePicker picker;

    public DatePicker(){
        picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
        contentPanel = new JPanel();
        contentPanel.add(picker);
        this.add(picker);
    }

    public String getText(){
        Date date = picker.getDate();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public void setText(String Text){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(Text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        picker.setDate(date);
    }
}
