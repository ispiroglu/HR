package org.ytu.hr.core.util.validators.salary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalaryValidator {
    private final int maxSalary = 50000;
    public boolean validate(String salaryText) {
        int salary = Integer.parseInt(salaryText);
        return salary < maxSalary && salary > 0;
    }

}
