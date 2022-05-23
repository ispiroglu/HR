package org.ytu.hr.core.util.validators.todayDate;

import javassist.Loader;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TodaysDate {
    private SimpleDateFormat spf;
    private java.sql.Date date;

    public boolean validate(String dateStr)
    {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            java.util.Date d = sdf.parse(dateStr);
            java.sql.Date tempDate = new java.sql.Date(d.getTime());
            Date date = new Date(System.currentTimeMillis());
            if (tempDate.before(date))
                return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
