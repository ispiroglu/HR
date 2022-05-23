package org.ytu.hr.core.util.payment;

import org.ytu.hr.core.models.employee.Employee;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;


public class Payment {
    // Calcualtes the compensation that should be giving to the employee upon firing
    public long compensation(Employee emp) {
        long compensationLimit = 10596;
        long compensation;


        java.util.Date today = Calendar.getInstance().getTime();
        java.util.Date applicationDate = new java.util.Date(emp.getApplicationDate().getTime());

        double daysBetween = (double) ChronoUnit.DAYS.between(applicationDate.toInstant(), today.toInstant());
        //long timeBetween = today.getTime() - applicationDate.getTime();
        //daysBetween = (timeBetween / (1000 * 60 * 60 * 24)) % 365;


        compensation = (long)((daysBetween / 365) * (emp.getSalary()));

        /*
        System.out.println("Days: " + daysBetween);
        System.out.println("Salary: " + emp.getSalary());
        System.out.println("Compensation: " + compensation);
        */

        return Math.min(compensation, compensationLimit);
    }

    // Calculates salary with current absentance penalties
    public int reducedSalary(Employee emp) {
        int reduced = (emp.getSalary() * ((30 - emp.getAbsentDay() * 2)) / 30);
        return Math.max(reduced, 0);
    }
}
