package org.ytu.hr.core.util.monetary;

import org.ytu.hr.core.models.employee.Employee;

import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

public class Monetary {
    // Calcualtes the compensation that should be giving to the employee upon firing
    public Integer compensation(Employee emp) {
        int compensationLimit = 10596;
        int compensation;

        Date today = Calendar.getInstance().getTime();
        int daysBetween = (int) DAYS.between((Temporal) emp.getApplicationDate(), (Temporal) today);

        compensation = (daysBetween / 365) * emp.getSalary();

        return Math.min(compensation, compensationLimit);
    }

    // Calculates salary with current absentance penalties
    public int reducedSalary(Employee emp) {
        int reduced = (emp.getSalary() * ((30 - emp.getAbsentDay() * 2)) / 30);
        return Math.max(reduced, 0);
    }
}
