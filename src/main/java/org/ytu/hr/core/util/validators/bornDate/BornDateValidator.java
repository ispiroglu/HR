package org.ytu.hr.core.util.validators.bornDate;

import javassist.Loader;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class BornDateValidator {
    private SimpleDateFormat spf;
    private java.sql.Date date;
    public BornDateValidator()
    {
    }

    public boolean validate(String dateStr)
    {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
